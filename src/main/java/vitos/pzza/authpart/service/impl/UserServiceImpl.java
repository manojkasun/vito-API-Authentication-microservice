package vitos.pzza.authpart.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vitos.pzza.authpart.entity.User;
import vitos.pzza.authpart.payload.UserDto;
import vitos.pzza.authpart.repository.UserRepository;
import vitos.pzza.authpart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private ModelMapper mapper;
    private UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        // encrypt the password
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        //convert DTO to entity
        User user = mapToEntity(userDto);

        User newUser = userRepository.save(user);

        // convert entity to dto
        UserDto userResponse = mapToDto(newUser);
        return userResponse;
    }

    private UserDto mapToDto(User post){
        UserDto userDto = mapper.map(post, UserDto.class);
        return userDto;
    }

    // converted dti in to entity
    private User mapToEntity(UserDto userDto){
        User user = mapper.map(userDto, User.class);
        return user;
    }
}
