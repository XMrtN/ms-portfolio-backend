package com.portfolio.martinsepulveda.Security.Repository;

import com.portfolio.martinsepulveda.Security.Entity.Role;
import com.portfolio.martinsepulveda.Security.Enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
