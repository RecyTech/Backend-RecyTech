package com.acme.recytechbackend.devices.interfaces.rest;

import com.acme.recytechbackend.auth.domain.model.aggregates.Customer;
import com.acme.recytechbackend.customer_branch_devices.interfaces.acl.CustomerContextFacade;
import com.acme.recytechbackend.devices.domain.model.aggregates.Brand;
import com.acme.recytechbackend.devices.domain.model.aggregates.Category;
import com.acme.recytechbackend.devices.domain.model.commands.CreateDeviceCommand;
import com.acme.recytechbackend.devices.domain.model.queries.*;
import com.acme.recytechbackend.devices.domain.services.BrandQueryService;
import com.acme.recytechbackend.devices.domain.services.CategoryQueryService;
import com.acme.recytechbackend.devices.domain.services.DeviceCommandService;
import com.acme.recytechbackend.devices.domain.services.DeviceQueryService;
import com.acme.recytechbackend.devices.interfaces.rest.resources.CreateDeviceResource;
import com.acme.recytechbackend.devices.interfaces.rest.resources.DeviceResource;
import com.acme.recytechbackend.devices.interfaces.rest.transform.CreateDeviceResourceFromEntityAssembler;
import com.acme.recytechbackend.devices.interfaces.rest.transform.DeviceResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/api/devices", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Devices", description = "Devices Management Endpoints")
public class DeviceController {
    private final DeviceCommandService deviceCommandService;
    private final DeviceQueryService deviceQueryService;
    private final CustomerContextFacade customerContextFacade;
    private final CategoryQueryService categoryQueryService;
    private final BrandQueryService brandQueryService;

    public DeviceController(DeviceCommandService deviceCommandService,
                            DeviceQueryService deviceQueryService,
                            CustomerContextFacade customerContextFacade,
                            CategoryQueryService categoryQueryService,
                            BrandQueryService brandQueryService) {
        this.deviceCommandService = deviceCommandService;
        this.deviceQueryService = deviceQueryService;
        this.customerContextFacade = customerContextFacade;
        this.categoryQueryService = categoryQueryService;
        this.brandQueryService = brandQueryService;
    }

    public List<Category> getCategory(List<Integer> categories) {
        List<Optional<Category>> optionalCategory = categories.stream()
                .map(item -> {
                    var getCategoryById = new GetCategoryByIdQuery(item);
                    return this.categoryQueryService.handle(getCategoryById);
                }).collect(Collectors.toList());

        List<Category> categoryList = optionalCategory.stream()
                .map(Optional::get)
                .collect(Collectors.toList());
        return categoryList;
    }
    public List<Brand> getBrand(List<Integer> brands) {
        List<Optional<Brand>> optionalBrands = brands.stream()
                .map(item -> {
                    var getBrandById = new GetBrandByIdQuery(item);
                    return this.brandQueryService.handle(getBrandById);
                }).collect(Collectors.toList());

        List<Brand> brandList=optionalBrands.stream()
                .map(Optional::get)
                .collect(Collectors.toList());
        return brandList;
    }

    @Operation(summary = "Create devices")
    @PostMapping
    public ResponseEntity<CreateDeviceResource> createDevice(@RequestBody CreateDeviceResource resource) {
        var customer = this.customerContextFacade.getCustomerById(resource.customerId());
        if (customer == null) { return ResponseEntity.badRequest().build(); }
        var category = getCategory(resource.categories());
        var brand = getBrand(resource.brands());
        var createDeviceCommand = new CreateDeviceCommand(resource.name(),resource.description(), resource.precio(), resource.imageURL(), customer, category, brand);
        var device = this.deviceCommandService.handle(createDeviceCommand);
        if (device.isEmpty()) return ResponseEntity.badRequest().build();

        var createDeviceResource = CreateDeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());
        return new ResponseEntity<>(createDeviceResource, HttpStatus.CREATED);
    }

    @Operation(summary = "Get All devices")
    @GetMapping
    public ResponseEntity<List<DeviceResource>> getAllDevices() {
        var getAllDevicesQuery = new GetAllDevicesQuery();
        var devices = this.deviceQueryService.handle(getAllDevicesQuery);
        var devicesResources = devices.stream()
                .map(DeviceResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(devicesResources);
    }

    @Operation(summary = "Get All Device By State")
    @GetMapping(value = "/by-state")
    public ResponseEntity<List<DeviceResource>> getAllDevicesByState(@RequestParam String state) {
        try {
            var getAllDevicesByStateQuery = new GetAllDeviceByStateQuery(state);
            var devices = this.deviceQueryService.handle(getAllDevicesByStateQuery);
            var devicesResources = devices.stream()
                    .map(DeviceResourceFromEntityAssembler::toResourceFromEntity)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(devicesResources);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Get Device By Id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<DeviceResource> getDeviceById(@PathVariable Long id) {
        var getDeviceByIdQuery = new GetDeviceByIdQuery(id);
        var device = this.deviceQueryService.handle(getDeviceByIdQuery);
        if (device.isEmpty()) return ResponseEntity.badRequest().build();
        var deviceResource = DeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());
        return ResponseEntity.ok(deviceResource);
    }

}
