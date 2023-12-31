package com.example.copsboot.user;

import com.example.copsboot.jpa.AbstractEntity;
import com.example.copsboot.jpa.AbstractEntityId;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;
@Entity
@Table(name = "copsboot_user")
public class User extends AbstractEntity<UserId> {

    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;

    protected User(){

    }
    public User(UserId id, String email, String password, Set<UserRole> roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }
}
