package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.FrontSkill;
import com.portfolio.martinsepulveda.Repository.IFrontSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FrontSkillService {
    @Autowired
    IFrontSkillRepository ifrontskillRepository;
    
    public List<FrontSkill> list() {
        return ifrontskillRepository.findAll(Sort.by("position"));
    }
    
    public Optional<FrontSkill> getOne(int id) {
        return ifrontskillRepository.findById(id);
    }
    
    public Optional<FrontSkill> getByName(String name) {
        return ifrontskillRepository.findByName(name);
    }
    
    public void save(FrontSkill skill) {
        ifrontskillRepository.save(skill);
    }
    
    public void delete(int id) {
        ifrontskillRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return ifrontskillRepository.existsById(id);
    }
    
    public boolean existsByName(String name) {
        return ifrontskillRepository.existsByName(name);
    }
}
