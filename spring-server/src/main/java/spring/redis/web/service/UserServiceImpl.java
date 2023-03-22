package spring.redis.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.redis.web.model.dto.request.UserSaveRequest;
import spring.redis.web.model.dto.response.UserDetailResponse;
import spring.redis.web.model.entity.UserEntity;
import spring.redis.web.repository.UserRepository;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserEntity save(UserSaveRequest userSaveRequest) {
        return userRepository.save(toEntity(userSaveRequest));
    }

    @Override
    public UserDetailResponse get(String userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("not exists user")
        );
        String version = org.springframework.core.SpringVersion.getVersion();
        log.info("version : " + version);
        return getDetailUserReponse(userEntity);
    }

    private UserEntity toEntity(UserSaveRequest userSaveRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userSaveRequest.getName());
        userEntity.setAge(userSaveRequest.getAge());

        return userEntity;
    }

    private UserDetailResponse getDetailUserReponse(UserEntity userEntity) {
        UserDetailResponse result = new UserDetailResponse();
        result.setName(userEntity.getName());
        result.setAge(userEntity.getAge());
        return result;
    }
}
