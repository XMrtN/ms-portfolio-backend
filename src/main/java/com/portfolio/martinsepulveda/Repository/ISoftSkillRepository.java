package com.portfolio.martinsepulveda.Repository;

import com.portfolio.martinsepulveda.Entity.SoftSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftSkillRepository extends JpaRepository<SoftSkill, Integer> {
    public Optional<SoftSkill> findByName(String name);
    public boolean existsByName(String name);
}
