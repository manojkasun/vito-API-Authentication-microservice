package vitos.pzza.authpart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vitos.pzza.authpart.entity.User;
import vitos.pzza.authpart.payload.UserDto;
import vitos.pzza.authpart.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import vitos.pzza.authpart.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @GetMapping("/userId")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId){
        return new ResponseEntity<>(UserDto.builder().build(), HttpStatus.OK);
    }

@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){
    // add check for email exist in the database

    if(userRepository.existsByEmail(userDto.getEmail())){
        return new ResponseEntity<>("Email Already taken!!", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);
}
}
