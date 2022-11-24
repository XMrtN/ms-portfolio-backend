package com.portfolio.martinsepulveda.Repository;

import com.portfolio.martinsepulveda.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer> {
    public Optional<Education> findByEdCareerName(String edCareerName);
    public boolean existsByEdCareerName(String edCareerName);
}
