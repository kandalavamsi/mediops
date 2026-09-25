package com.mediops.controller;

import com.mediops.dto.ward.WardCreateRequest;
import com.mediops.dto.ward.WardResponse;
import com.mediops.dto.ward.WardUpdateRequest;
import com.mediops.entity.Department;
import com.mediops.entity.Ward;
import com.mediops.service.DepartmentService;
import com.mediops.service.WardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wards")
public class WardController {

    private final WardService wardService;
    private final DepartmentService departmentService;

    public WardController(
            WardService wardService,
            DepartmentService departmentService) {
        this.wardService = wardService;
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<WardResponse> create(
            @RequestBody WardCreateRequest request) {

        Department department =
                departmentService.getById(request.getDepartmentId());

        Ward ward = new Ward();

        ward.setWardCode(request.getWardCode());
        ward.setName(request.getName());
        ward.setWardType(request.getWardType());
        ward.setDepartment(department);
        ward.setFloor(request.getFloor());
        ward.setCapacity(request.getCapacity());
        ward.setStatus(request.getStatus());

        OffsetDateTime now = OffsetDateTime.now();
        ward.setCreatedAt(now);
        ward.setUpdatedAt(now);

        Ward savedWard = wardService.create(ward);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(savedWard));
    }

    @GetMapping
    public ResponseEntity<List<WardResponse>> getAll() {

        List<WardResponse> wards = wardService.getAll()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(wards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WardResponse> getById(
            @PathVariable Long id) {

        Ward ward = wardService.getById(id);

        return ResponseEntity.ok(toResponse(ward));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WardResponse> update(
            @PathVariable Long id,
            @RequestBody WardUpdateRequest request) {

        Ward ward = wardService.getById(id);

        Department department =
                departmentService.getById(request.getDepartmentId());

        ward.setWardCode(request.getWardCode());
        ward.setName(request.getName());
        ward.setWardType(request.getWardType());
        ward.setDepartment(department);
        ward.setFloor(request.getFloor());
        ward.setCapacity(request.getCapacity());
        ward.setStatus(request.getStatus());
        ward.setUpdatedAt(OffsetDateTime.now());

        Ward updatedWard = wardService.update(ward);

        return ResponseEntity.ok(toResponse(updatedWard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        wardService.getById(id);
        wardService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private WardResponse toResponse(Ward ward) {

        Department department = ward.getDepartment();

        return new WardResponse(
                ward.getId(),
                ward.getWardCode(),
                ward.getName(),
                ward.getWardType(),
                department.getId(),
                department.getDepartmentCode(),
                department.getName(),
                ward.getFloor(),
                ward.getCapacity(),
                ward.getStatus(),
                ward.getCreatedAt(),
                ward.getUpdatedAt()
        );
    }
}