package com.springexample.SpringDataJPA1.repository;

import com.springexample.SpringDataJPA1.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    List<User> findByUsernameOrderByUsernameDesc(final String username);

    List<User> findByUsername(final String username, final Sort sort);

    List<User> findByUsername(final String username, final Pageable pageable);

    List<User> findByUsername(final String username);

    List<User> findByUsernameLike(final String username);

    List<User> findByUsernameStartsWith(final String username);


    // Method to update a user's password
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :newPassword WHERE u.id = :id")
    void changeUserPassword(@Param("id") Long id, @Param("newPassword") String newPassword);

    // Method to delete a user by username
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.username = :username")
    void deleteUserByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id = :id")
    void deleteUserByIdCustom(@Param("id") Long id);



//    @Query("SELECT e FROM User AS e WHERE e.username = :username")
//    List<User> findByQuery(@Param("username") final String username);
//
//    @NativeQuery("SELECT * FROM user WHERE username = :username")
//    List<User> findByQueryNative(@Param("username") final String username);

}
