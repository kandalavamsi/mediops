package com.mediops.controller;

import com.mediops.dto.department.DepartmentCreateRequest;
import com.mediops.dto.department.DepartmentResponse;
import com.mediops.dto.department.DepartmentUpdateRequest;
import com.mediops.entity.Department;
import com.mediops.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponse> create(
            @RequestBody DepartmentCreateRequest request) {

        Department department = new Department();

        department.setDepartmentCode(request.getDepartmentCode());
        department.setName(request.getName());
        department.setDescription(request.getDescription());
        department.setStatus(request.getStatus());

        OffsetDateTime now = OffsetDateTime.now();
        department.setCreatedAt(now);
        department.setUpdatedAt(now);

        Department savedDepartment = departmentService.create(department);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(savedDepartment));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAll() {

        List<DepartmentResponse> departments = departmentService.getAll()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getById(
            @PathVariable Long id) {

        Department department = departmentService.getById(id);

        return ResponseEntity.ok(toResponse(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> update(
            @PathVariable Long id,
            @RequestBody DepartmentUpdateRequest request) {

        Department department = departmentService.getById(id);

        department.setDepartmentCode(request.getDepartmentCode());
        department.setName(request.getName());
        department.setDescription(request.getDescription());
        department.setStatus(request.getStatus());
        department.setUpdatedAt(OffsetDateTime.now());

        Department updatedDepartment = departmentService.update(department);

        return ResponseEntity.ok(toResponse(updatedDepartment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        departmentService.getById(id);
        departmentService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private DepartmentResponse toResponse(Department department) {

        return new DepartmentResponse(
                department.getId(),
                department.getDepartmentCode(),
                department.getName(),
                department.getDescription(),
                department.getStatus(),
                department.getCreatedAt(),
                department.getUpdatedAt()
        );
    }
}