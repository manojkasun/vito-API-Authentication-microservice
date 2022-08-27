package vitos.pzza.authpart.service;

import vitos.pzza.authpart.payload.UserDto;

public interface UserService {
    UserDto registerUser(UserDto userDto);
}
