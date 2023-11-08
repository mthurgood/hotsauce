package com.thugsoft.hotsauce.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/count")
    public Long countUsers() {
        return userRepository.count();
    }

    @GetMapping("/{id}")
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setUserStatus(user.getUserStatus());
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return "Deleted user with id: " + id;
        } catch (Exception e) {
            return "User not found.";
        }
    }
}
