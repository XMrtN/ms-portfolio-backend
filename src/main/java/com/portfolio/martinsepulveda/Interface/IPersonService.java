package com.portfolio.martinsepulveda.Interface;

import com.portfolio.martinsepulveda.Entity.Person;
import java.util.List;


public interface IPersonService {
    //Traer una persona
    public List<Person> getPerson();
    
    //Guardar objeto tipo persona
    public void savePerson(Person person);
    
    //Eliminar persona por Id
    public void deletePerson(Long id);
    
    //Buscar persona por Id
    public Person findPerson(Long id);
}
