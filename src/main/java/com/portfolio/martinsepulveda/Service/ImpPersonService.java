package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.Person;
import com.portfolio.martinsepulveda.Interface.IPersonService;
import com.portfolio.martinsepulveda.Repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonService implements IPersonService {
    @Autowired IPersonRepository ipersonrepository;
    
    @Override
    public List<Person> getPerson() {
        List<Person> person = ipersonrepository.findAll();
        return person;
    }

    @Override
    public void savePerson(Person person) {
        ipersonrepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        ipersonrepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = ipersonrepository.findById(id).orElse(null);
        return person;
    }
    
}
