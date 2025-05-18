package matheus.edu.controller;

import matheus.edu.domain.model.Animal;
import matheus.edu.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("animais")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Long id){
        Animal animal = animalService.findByid(id);
        return ResponseEntity.ok(animal);
    }
}
