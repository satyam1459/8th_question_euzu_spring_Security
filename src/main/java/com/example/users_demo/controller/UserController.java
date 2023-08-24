package com.example.users_demo.controller;

import com.example.users_demo.entities.User;
import com.example.users_demo.exception.ConfigDataResourceNotFoundException;
import com.example.users_demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException(id));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException(id));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    @PreAuthorize("hasRole('NORMAL')")
    @PatchMapping("/{id}")
    public User deleteAttributes(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException(id));

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String key = entry.getKey();
            switch (key) {
                case "username":
                    user.setUsername(null);
                    break;
                case "email":
                    user.setEmail(null);
                    break;
            }
        }

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException(id));

        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}

