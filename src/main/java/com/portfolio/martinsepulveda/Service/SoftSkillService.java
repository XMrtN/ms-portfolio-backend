package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.SoftSkill;
import com.portfolio.martinsepulveda.Repository.ISoftSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoftSkillService {
    @Autowired
    ISoftSkillRepository isoftskillRepository;
    
    public List<SoftSkill> list() {
        return isoftskillRepository.findAll(Sort.by("position"));
    }
    
    public Optional<SoftSkill> getOne(int id) {
        return isoftskillRepository.findById(id);
    }
    
    public Optional<SoftSkill> getByName(String name) {
        return isoftskillRepository.findByName(name);
    }
    
    public void save(SoftSkill skill) {
        isoftskillRepository.save(skill);
    }
    
    public void delete(int id) {
        isoftskillRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return isoftskillRepository.existsById(id);
    }
    
    public boolean existsByName(String name) {
        return isoftskillRepository.existsByName(name);
    }
}
