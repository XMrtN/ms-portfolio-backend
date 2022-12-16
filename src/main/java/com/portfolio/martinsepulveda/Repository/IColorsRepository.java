package com.portfolio.martinsepulveda.Repository;

import com.portfolio.martinsepulveda.Entity.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColorsRepository extends JpaRepository<Colors, Integer> {
}
