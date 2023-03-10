package spring.redis.web.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.redis.web.model.CustomBaseIdEntity;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity extends CustomBaseIdEntity {
    private String name;

    private int age;

}
