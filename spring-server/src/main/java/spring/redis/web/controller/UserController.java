package spring.redis.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.redis.web.model.dto.request.UserSaveRequest;
import spring.redis.web.model.entity.UserEntity;
import spring.redis.web.service.UserService;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserService userService;
    @PostMapping()
    public UserEntity save(@RequestBody UserSaveRequest userSaveRequest) {
        return userService.save(userSaveRequest);
    }
}
