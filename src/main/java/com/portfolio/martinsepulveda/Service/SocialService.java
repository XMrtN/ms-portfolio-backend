package com.portfolio.martinsepulveda.Service;

import com.portfolio.martinsepulveda.Entity.Social;
import com.portfolio.martinsepulveda.Repository.ISocialRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SocialService {
    @Autowired
    ISocialRepository isocialRepository;
    
    public List<Social> list() {
        return isocialRepository.findAll();
    }
    
    public Optional<Social> getOne(int id) {
        return isocialRepository.findById(id);
    }
    
    public Optional<Social> getByUrl(String url) {
        return isocialRepository.findByUrl(url);
    }
    
    public void save(Social skill) {
        isocialRepository.save(skill);
    }
    
    public void delete(int id) {
        isocialRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return isocialRepository.existsById(id);
    }
    
    public boolean existsByUrl(String url) {
        return isocialRepository.existsByUrl(url);
    }
}
