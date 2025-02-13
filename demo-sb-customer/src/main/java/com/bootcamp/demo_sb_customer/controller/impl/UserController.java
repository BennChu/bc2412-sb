package com.bootcamp.demo_sb_customer.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_sb_customer.dto.UserDTO;
import com.bootcamp.demo_sb_customer.dto.mapper.UserDTOMapper;
import com.bootcamp.demo_sb_customer.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {

    // field injection
    @Autowired
    private UserService userService;
    @Autowired
    private UserDTOMapper userDTOMapper;

    // @Autowired
    // public UserController(UserService userService, UserDTOMapper userDTOMapper){
    //     this.userService = userService;
    //     this.userDTOMapper = userDTOMapper;
    // }    
    // @Override
    // public List<UserDto> getUser() {
    //     return this.userService.getUser();
    // }

    // http://localhost:8082/jsonplaceholder/users
    @GetMapping("/jsonplaceholder/users")
    public List<UserDTO> getUsers() {

        // List<UserDto> serviceResults = this.userService.getUsers();
        // List<UserDTO> userDTOs = new ArrayList<>();

        // for (UserDto dto : serviceResults) {
        //     // create Objects
        //     UserDTO.Address.Geo.builder()
        //         .latitude(dto.getAddress().getGeo().getLatitude())
        //         .longitude(dto.getAddress().getGeo().getLongtitude());

        //     UserDTO.Address.builder()
        //             .street(dto.getAddress().getStreet())
        //             .suite(dto.getAddress().getSuite())
        //             .city(dto.getAddress().getCity())
        //             .zipcode(dto.getAddress().getCity())
        //             .geo(null);

        //     UserDTO.builder()
        //             .id(dto.getId())
        //             .name(dto.getName())
        //             .email(dto.getEmail())
        //             .username(dto.getUsername())
        //             .address(null);

        //     userDTOs.add(userDto);



        //     // return this.userService.getUsers().stream()
        //     //         .map(e -> UserDTOMapper.map(dto))
        //     //         .userDTOs.add(userDto);
        // }

        // List of UserDto -> List of UserDTO
        return this.userService.getUsers().stream()
                    .map(e -> userDTOMapper.map(e))
                    .collect(Collectors.toList());
    }
}
