package com.Hotel.Management.System.controller;


import com.Hotel.Management.System.payload.AppUserDto;
import com.Hotel.Management.System.payload.LoginDto;
import com.Hotel.Management.System.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class AppUserController {

   private AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    //------------------------------- Signup --------------------------------------//

    @PostMapping("/signup-owner")
    public ResponseEntity<?> verifySignupOwner(@RequestBody AppUserDto appUserDto) {
        if(appUserService.verifyEmail(appUserDto)) {
            return new ResponseEntity<>("Email Already Exist",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(appUserService.verifyUsername(appUserDto)) {
            return new ResponseEntity<>("Username Already Exist",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(appUserService.verifyMobile(appUserDto)) {
            return new ResponseEntity<>("Mobile Already Exist",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(appUserService.saveOwnerDetails(appUserDto), HttpStatus.OK);
    }

    @PostMapping("/signup-user")
    public ResponseEntity<?> verifySignupUser(@RequestBody AppUserDto appUserDto){
        if(appUserService.verifyEmail(appUserDto)) {
            return new ResponseEntity<>("Email Already Exist",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(appUserService.verifyUsername(appUserDto)) {
            return new ResponseEntity<>("Username Already Exist",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(appUserService.verifyMobile(appUserDto)) {
            return new ResponseEntity<>("Mobile Already Exist",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(appUserService.saveUserDetails(appUserDto), HttpStatus.OK);
    }

    //-------------------------------------- Login -----------------------------------//

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        String token = appUserService.verifyLogin(loginDto);
        if (token != null) {
            return new ResponseEntity<>(appUserService.tokenNumber(token), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username/password", HttpStatus.FORBIDDEN);
        }
    }

    // ------------------- GetUserDetails ------------------- //

    @GetMapping("/username")
    public ResponseEntity<AppUserDto> getByUsername(@RequestParam String username) {
        return new ResponseEntity<>(appUserService.findUsername(username), HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<AppUserDto> getByEmail(@RequestParam String email) {
        return new ResponseEntity<>(appUserService.findEmail(email), HttpStatus.OK);
    }

    @GetMapping("/all/data")
    public ResponseEntity<List<AppUserDto>> getAllInfo() {
        return new ResponseEntity<>(appUserService.getAllUserDetails(), HttpStatus.OK);
    }

    // ----------------------- Update ----------------------- //

    @PutMapping("/update/by-id/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id,
                                            @RequestBody AppUserDto appUserDto) {
        if (appUserService.findById(id)) {
            return new ResponseEntity<>(appUserService.updateUserById(id, appUserDto), HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/by-username")
    public ResponseEntity<?> updateUserByUsername(@RequestParam String username,
                                                  @RequestBody AppUserDto appUserDto) {
        if (appUserService.findByUsername(username)) {
            return new ResponseEntity<>(appUserService.updateUserByUsername(username, appUserDto), HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    // ----------------------- Delete ----------------------- //

    @DeleteMapping("/delete/by-id/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        if (appUserService.findById(id)) {
            appUserService.deleteUserById(id);
            return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/by-username")
    public ResponseEntity<String> deleteUserByUsername(@RequestParam String username) {
        if (appUserService.findByUsername(username)) {
            appUserService.deleteUserByUsername(username);
            return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

}
