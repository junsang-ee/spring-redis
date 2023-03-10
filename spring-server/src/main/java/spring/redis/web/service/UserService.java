package spring.redis.web.service;

import spring.redis.web.model.dto.request.UserSaveRequest;
import spring.redis.web.model.entity.UserEntity;

public interface UserService {
    UserEntity save(UserSaveRequest userSaveRequest);
}
