package com.ciclo3.juanparra.service;

import com.ciclo3.juanparra.model.Audience;
import com.ciclo3.juanparra.repository.AudienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll() {
        return audienceRepository.getAll();
    }

    public Optional<Audience> getAudience(int id) {
        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience audi) {
        if (audi.getNumId() == null) {
            return audienceRepository.save(audi);
        } else {
            Optional<Audience> consulta = audienceRepository.getAudience(audi.getNumId());
            if (consulta.isEmpty()) {
                return audienceRepository.save(audi);
            } else {
                return audi;

            }
        }
    }

}
