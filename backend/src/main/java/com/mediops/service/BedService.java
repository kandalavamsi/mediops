package com.mediops.service;

import com.mediops.entity.Bed;
import com.mediops.repository.BedRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mediops.exception.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
public class BedService {
    private final BedRepository bedRepository;

    public BedService(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    public Bed create(Bed bed){
        return bedRepository.save(bed);
    }

    @Transactional(readOnly = true)
    public List<Bed> getAll(){
        return bedRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Bed getById(Long id){
        return bedRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("bed not  found with:"+id));
    }

    @Transactional
    public Bed update(Bed bed) {

        Bed updatedBed = bedRepository.save(bed);

        updatedBed.getWard().getWardCode();
        updatedBed.getWard().getName();

        return updatedBed;
    }
    public void delete(Long id){
         bedRepository.deleteById(id);
    }
}
