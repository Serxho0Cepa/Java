package com.springexample.SpringDataJPA1.main;


import com.springexample.SpringDataJPA1.model.entity.User;
import com.springexample.SpringDataJPA1.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationRunner implements InitializingBean {

    private final UserRepository userRepository;

    public ApplicationRunner(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void afterPropertiesSet() {
        // Method testing here

        List<User> users = userRepository.findByUsername("JohnUsername");
        users.forEach(user -> System.out.println(user));

        // Change a user's password (example user ID and new password)
        Long userIdToChangePassword = 5L;
        String newPassword = "newPassword555";
        userRepository.changeUserPassword(userIdToChangePassword, newPassword);
        System.out.println("Changed password for user ID: " + userIdToChangePassword);


//        // Delete a user by username (replace with actual username)
//        String usernameToDelete = "JohnUsername";
//        userRepository.deleteUserByUsername(usernameToDelete);
//        System.out.println("Deleted user with username: " + usernameToDelete);

//        // Delete a user by ID (replace with actual user ID)
//        Long userIdToDelete = 2L;
//        userRepository.deleteUserByIdCustom(userIdToDelete);
//        System.out.println("Deleted user with ID: " + userIdToDelete);

    }

    // Specification executor example
    //    private Specification<User> getSpecification() {
    //        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), "JohnUsername");
    //    }
}
