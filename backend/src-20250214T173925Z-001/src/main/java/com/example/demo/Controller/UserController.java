package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.pojo.Users;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userservice;

   
    @GetMapping("/display")
    public List<UsersDTO> displayUsers() {
        List<Users> usersList = userservice.Display();
        
        return usersList.stream().map(user -> new UsersDTO(
                user.getUser_id(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getGroup_id(),
                user.getRole(),
                user.getProfile_picture(),
                user.getCreated_at(),
                user.getUpdated_at()
        )).collect(Collectors.toList());
    }

    
    @PostMapping()
    public Users saveUser(@RequestBody UsersDTO obj) {
        Users user = new Users();
        user.setUser_id(obj.getUser_id());
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPassword(obj.getPassword());
        user.setPhone(obj.getPhone());
        user.setGroup_id(obj.getGroup_id());
        user.setRole(obj.getRole());
        user.setProfile_picture(obj.getProfile_picture());
        user.setCreated_at(obj.getCreated_at());
        user.setUpdated_at(obj.getUpdated_at());
        
        return userservice.saveinfo(user);
    }

    @PostMapping("/login")
    public Users loginUser(@RequestBody LoginRequest loginRequest) {
        return userservice.login(loginRequest);
    }

    @DeleteMapping("/{id}")
    public Users deleteUser(@PathVariable Long id) {
        return userservice.deleteinfo(id);
    }

  
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody UsersDTO obj) {
        Users user = new Users();
        user.setUser_id(obj.getUser_id());
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPassword(obj.getPassword());
        user.setPhone(obj.getPhone());
        user.setGroup_id(obj.getGroup_id());
        user.setRole(obj.getRole());
        user.setProfile_picture(obj.getProfile_picture());
        user.setCreated_at(obj.getCreated_at());
        user.setUpdated_at(obj.getUpdated_at());

        return userservice.updateinfo(id, user);
    }

    @PutMapping("/pass/{id}")
    public void updatePassword(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String password = requestBody.get("password");

        System.out.println("User ID: " + id);
        System.out.println("Password: " + password);

        userservice.updatepass(id, password);
    }
}

