package com.mediops.service;

import com.mediops.entity.Ward;
import com.mediops.repository.WardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mediops.exception.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
public class WardService {

    private final WardRepository wardRepository;

    public WardService(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    public Ward create(Ward ward) {
        return wardRepository.save(ward);
    }

    @Transactional(readOnly = true)
    public List<Ward> getAll() {

        List<Ward> wards = wardRepository.findAll();

        wards.forEach(ward -> {
            ward.getDepartment().getDepartmentCode();
            ward.getDepartment().getName();
        });

        return wards;
    }

    @Transactional(readOnly = true)
    public Ward getById(Long id) {

        Ward ward = wardRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ward not found with id: " + id));

        ward.getDepartment().getDepartmentCode();
        ward.getDepartment().getName();

        return ward;
    }

    @Transactional
    public Ward update(Ward ward) {

        Ward updatedWard = wardRepository.save(ward);

        updatedWard.getDepartment().getDepartmentCode();
        updatedWard.getDepartment().getName();

        return updatedWard;
    }
    public void delete(Long id) {
        wardRepository.deleteById(id);
    }
}