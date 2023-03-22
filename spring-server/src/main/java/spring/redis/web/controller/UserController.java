package spring.redis.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import spring.redis.web.model.dto.request.UserSaveRequest;
import spring.redis.web.model.dto.response.UserDetailResponse;
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

    @Cacheable(cacheNames = "userDetailResponse")
    @GetMapping("/{userId}")
    public UserDetailResponse get(@PathVariable String userId) {
        return userService.get(userId);
    }
}
