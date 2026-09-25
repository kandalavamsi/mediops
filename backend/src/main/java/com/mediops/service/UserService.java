package com.mediops.service;

import com.mediops.entity.User;
import com.mediops.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mediops.exception.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found with id:"+id));
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
