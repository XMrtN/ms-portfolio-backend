package com.portfolio.martinsepulveda.Repository;

import com.portfolio.martinsepulveda.Entity.Social;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocialRepository extends JpaRepository<Social, Integer> {
    public Optional<Social> findByUrl(String url);
    public boolean existsByUrl(String url);
}
