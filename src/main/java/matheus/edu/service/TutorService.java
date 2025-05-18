package matheus.edu.service;

import matheus.edu.domain.model.Tutor;

public interface TutorService {
    Tutor findByid(Long id);

    Tutor create(Tutor tutorToCreate);
}
