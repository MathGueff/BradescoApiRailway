package matheus.edu.controller;

import matheus.edu.domain.model.Tutor;
import matheus.edu.service.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("tutores")
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> findById(@PathVariable Long id){
        Tutor tutor = tutorService.findByid(id);
        return ResponseEntity.ok(tutor);
    }

    @PostMapping
    public ResponseEntity<Tutor> create(@RequestBody Tutor tutorToCreate){
        Tutor tutorCreated = tutorService.create(tutorToCreate);
        //Para retornar o caminho de busca por id do novo tutor criado
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(tutorCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(tutorCreated);
    }
}
