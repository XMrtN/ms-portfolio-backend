package com.portfolio.martinsepulveda.Security.Repository;

import com.portfolio.martinsepulveda.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
