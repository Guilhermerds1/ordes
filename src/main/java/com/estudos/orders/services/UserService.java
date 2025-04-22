package com.estudos.orders.services;

import com.estudos.orders.entities.User;
import com.estudos.orders.exceptions.ResourceNotFoundException;
import com.estudos.orders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findId(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User user){
        User user1 = userRepository.getReferenceById(id);
        updateData(user1, user);
        return userRepository.save(user1);
    }

    private void updateData(User user1, User user){
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
    }
}
