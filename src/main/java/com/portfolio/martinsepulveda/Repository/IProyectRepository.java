package com.portfolio.martinsepulveda.Repository;

import com.portfolio.martinsepulveda.Entity.Proyect;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectRepository extends JpaRepository<Proyect, Integer> {
    public Optional<Proyect> findByTitle(String title);
    public boolean existsByTitle(String title);
}
