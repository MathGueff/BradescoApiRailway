package matheus.edu.service.impl;

import matheus.edu.controller.TutorController;
import matheus.edu.domain.model.Animal;
import matheus.edu.domain.model.Tutor;
import matheus.edu.domain.repository.AnimalRepository;
import matheus.edu.domain.repository.TutorRepository;
import matheus.edu.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal findByid(Long id) {
        return animalRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
