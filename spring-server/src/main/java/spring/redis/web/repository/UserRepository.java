package spring.redis.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.redis.web.model.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

}
