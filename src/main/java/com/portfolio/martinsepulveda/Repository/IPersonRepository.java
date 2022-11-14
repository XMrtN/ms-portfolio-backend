package com.portfolio.martinsepulveda.Repository;

import com.portfolio.martinsepulveda.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    
}
