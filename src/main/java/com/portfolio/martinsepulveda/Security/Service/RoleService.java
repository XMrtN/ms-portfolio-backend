package com.portfolio.martinsepulveda.Security.Service;

import com.portfolio.martinsepulveda.Security.Entity.Role;
import com.portfolio.martinsepulveda.Security.Enums.RoleName;
import com.portfolio.martinsepulveda.Security.Repository.IRoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    @Autowired
    IRoleRepository iroleRepository;
    
    public Optional<Role> getByRoleName(RoleName roleName) {
        return iroleRepository.findByRoleName(roleName);
    }
    
    public void save(Role role) {
        iroleRepository.save(role);
    }
}
