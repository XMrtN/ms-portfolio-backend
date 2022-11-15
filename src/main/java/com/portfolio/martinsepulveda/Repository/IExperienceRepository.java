package com.portfolio.martinsepulveda.Repository;

import com.portfolio.martinsepulveda.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Integer> {
    public Optional<Experience> findByExpName(String expName);
    public boolean existsByExpName(String expName);
}
