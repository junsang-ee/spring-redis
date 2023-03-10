package spring.redis.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.redis.web.model.dto.request.UserSaveRequest;
import spring.redis.web.model.entity.UserEntity;
import spring.redis.web.repository.UserRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserEntity save(UserSaveRequest userSaveRequest) {
        return userRepository.save(toEntity(userSaveRequest));
    }

    private UserEntity toEntity(UserSaveRequest userSaveRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userSaveRequest.getName());
        userEntity.setAge(userSaveRequest.getAge());
        return userEntity;
    }
}
