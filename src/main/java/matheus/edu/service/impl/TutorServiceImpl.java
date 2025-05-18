package matheus.edu.service.impl;

import matheus.edu.domain.model.Tutor;
import matheus.edu.domain.repository.TutorRepository;
import matheus.edu.service.TutorService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Tutor findByid(Long id) {
        return tutorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Tutor create(Tutor tutorToCreate) {
        if(tutorToCreate.getId() != null && tutorRepository.existsById(tutorToCreate.getId())){
            throw new IllegalArgumentException("Esse ID de tutor já existe");
        }

        return tutorRepository.save(tutorToCreate);
    }
}
