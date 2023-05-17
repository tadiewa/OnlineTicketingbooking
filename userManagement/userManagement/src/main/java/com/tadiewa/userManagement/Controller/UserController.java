/**
 * @author : tadiewa
 * date: 5/11/2023
 */


package com.tadiewa.userManagement.Controller;

import com.tadiewa.userManagement.Service.UserServiceImpl;
import com.tadiewa.userManagement.model.Uzar;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImpl service;


    @GetMapping("/get-all-users")
    public ResponseEntity<List<Uzar>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Uzar uzar){
        service.saveUser(uzar);
    }

    @PutMapping("/update-user-info")
    public ResponseEntity<Uzar> updateUserInfo(@RequestBody @Valid Uzar updateUserInfoDto) {
        return ResponseEntity.ok(service.updateUserInfo(updateUserInfoDto));
    }
    @GetMapping("/{userId}")
   public ResponseEntity<Uzar> getUserById(@PathVariable String userId) {
       return ResponseEntity.ok(service.findUserByID(userId));
   }
}
