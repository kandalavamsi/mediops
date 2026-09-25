package com.mediops.controller;

import com.mediops.dto.bed.BedCreateRequest;
import com.mediops.dto.bed.BedResponse;
import com.mediops.dto.bed.BedUpdateRequest;
import com.mediops.entity.Bed;
import com.mediops.entity.Ward;
import com.mediops.service.BedService;
import com.mediops.service.WardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beds")
public class BedController {

    private final BedService bedService;
    private final WardService wardService;

    public BedController(
            BedService bedService,
            WardService wardService) {

        this.bedService = bedService;
        this.wardService = wardService;
    }

    @PostMapping
    public ResponseEntity<BedResponse> create(
            @RequestBody BedCreateRequest request) {

        Ward ward = wardService.getById(request.getWardId());

        Bed bed = new Bed();
        bed.setBedCode(request.getBedCode());
        bed.setWard(ward);
        bed.setBedType(request.getBedType());
        bed.setStatus(request.getStatus());
        bed.setNotes(request.getNotes());

        OffsetDateTime now = OffsetDateTime.now();
        bed.setCreatedAt(now);
        bed.setUpdatedAt(now);

        Bed createdBed = bedService.create(bed);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(createdBed));
    }

    @GetMapping
    public ResponseEntity<List<BedResponse>> getAll() {

        List<BedResponse> responses = bedService.getAll()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BedResponse> getById(
            @PathVariable Long id) {

        Bed bed = bedService.getById(id);

        return ResponseEntity.ok(toResponse(bed));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BedResponse> update(
            @PathVariable Long id,
            @RequestBody BedUpdateRequest request) {

        Bed bed = bedService.getById(id);
        Ward ward = wardService.getById(request.getWardId());

        bed.setBedCode(request.getBedCode());
        bed.setWard(ward);
        bed.setBedType(request.getBedType());
        bed.setStatus(request.getStatus());
        bed.setNotes(request.getNotes());
        bed.setUpdatedAt(OffsetDateTime.now());

        Bed updatedBed = bedService.update(bed);

        return ResponseEntity.ok(toResponse(updatedBed));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        bedService.getById(id);
        bedService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private BedResponse toResponse(Bed bed) {

        Ward ward = bed.getWard();

        return new BedResponse(
                bed.getId(),
                bed.getBedCode(),
                ward.getId(),
                ward.getWardCode(),
                ward.getName(),
                bed.getBedType(),
                bed.getStatus(),
                bed.getNotes(),
                bed.getCreatedAt(),
                bed.getUpdatedAt()
        );
    }
}