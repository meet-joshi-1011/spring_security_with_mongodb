package io.javabrains.springsecurityjwt.models;

import io.javabrains.springsecurityjwt.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
@Document(collection = "user_details")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Column(name = "user_Name")
    private String userName;
    private String password;
    private Boolean active;
    private String roles;


    public User(UserDTO userDto) {
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.active = userDto.isActive();
        this.roles = userDto.getRoles();
    }

}
