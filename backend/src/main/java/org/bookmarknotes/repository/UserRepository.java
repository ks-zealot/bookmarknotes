package org.bookmarknotes.repository;

import org.bookmarknotes.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zealot on 08.08.18.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Query("SELECT CASE  WHEN count(c)> 0 THEN true ELSE false END FROM " +
            "Customer c WHERE c.login = :username")
    boolean exist(@Param(value = "username") String username);
    @Query("SELECT c.password FROM " +
            "Customer c WHERE c.login = :username")
    String password(@Param(value = "username") String username);
    @Query("SELECT c FROM " +
            "Customer c WHERE c.login = :username")
    UserEntity loadByUserName(@Param(value = "username") String username);
}
