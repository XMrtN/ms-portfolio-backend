package com.portfolio.martinsepulveda.Repository;

import com.portfolio.martinsepulveda.Entity.FrontSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFrontSkillRepository extends JpaRepository<FrontSkill, Integer> {
    public Optional<FrontSkill> findByName(String name);
    public boolean existsByName(String name);
}
