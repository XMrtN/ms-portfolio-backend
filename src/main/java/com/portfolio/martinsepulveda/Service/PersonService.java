package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.Person;
import com.portfolio.martinsepulveda.Repository.IPersonRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {
    @Autowired IPersonRepository ipersonrepository;
    
    public List<Person> list() {
        return ipersonrepository.findAll();
    }
    
    public Optional<Person> getOne(int id) {
        return ipersonrepository.findById(id);
    }
    
    public Optional<Person> getByName(String name) {
        return ipersonrepository.findByName(name);
    }
    
    public void save(Person person) {
        ipersonrepository.save(person);
    }
    
    public void delete(int id) {
        ipersonrepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return ipersonrepository.existsById(id);
    }
    
    public boolean existsByName(String name) {
        return ipersonrepository.existsByName(name);
    }
}
