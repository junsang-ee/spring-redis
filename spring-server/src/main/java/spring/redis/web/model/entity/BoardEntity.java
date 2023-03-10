package spring.redis.web.model.entity;

import spring.redis.web.model.CustomBaseIdEntity;

import javax.persistence.Entity;

@Entity(name = "board")
public class BoardEntity extends CustomBaseIdEntity {
    private String title;

}
