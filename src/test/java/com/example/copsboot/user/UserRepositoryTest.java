package com.example.copsboot.user;

import com.example.copsboot.jpa.InMemoryUniqueIdGenerator;
import com.example.copsboot.jpa.UniqueIdGenerator;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashSet;
import java.util.UUID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void testStoreUser(){
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        User user = repository.save(new User(repository.nextId(),
                                    "rabariari.sa@gmail.com",
                                    "my-secret-pwd",roles
        ));

        assertThat(user).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
    }
    @TestConfiguration
    static class TestConfig{
        @Bean
        public UniqueIdGenerator<UUID> generator(){
            return new InMemoryUniqueIdGenerator();
        }
    }
}
