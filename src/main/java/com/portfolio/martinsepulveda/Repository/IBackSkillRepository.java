package com.portfolio.martinsepulveda.Repository;

import com.portfolio.martinsepulveda.Entity.BackSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBackSkillRepository extends JpaRepository<BackSkill, Integer> {
    public Optional<BackSkill> findByName(String name);
    public boolean existsByName(String name);
}
