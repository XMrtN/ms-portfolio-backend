package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.BackSkill;
import com.portfolio.martinsepulveda.Repository.IBackSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BackSkillService {
    @Autowired
    IBackSkillRepository ibackskillRepository;
    
    public List<BackSkill> list() {
        return ibackskillRepository.findAll();
    }
    
    public Optional<BackSkill> getOne(int id) {
        return ibackskillRepository.findById(id);
    }
    
    public Optional<BackSkill> getByName(String name) {
        return ibackskillRepository.findByName(name);
    }
    
    public void save(BackSkill skill) {
        ibackskillRepository.save(skill);
    }
    
    public void delete(int id) {
        ibackskillRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return ibackskillRepository.existsById(id);
    }
    
    public boolean existsByName(String name) {
        return ibackskillRepository.existsByName(name);
    }
}
