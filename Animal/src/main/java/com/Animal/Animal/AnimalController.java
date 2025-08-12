package com.Animal.Animal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimal(){
        return new ResponseEntity<>(animalService.getAllAnimals(),HttpStatus.OK);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int id){
        Animal animal = animalService.getAnimalById(id);

        if(animal != null){
            return new ResponseEntity<>(animal,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/animal")
    public ResponseEntity<Animal> addAnimal(@RequestPart Animal animal){
        Animal animal1 = animalService.addAnimal(animal);

        if(animal1 != null){
            return new ResponseEntity<>(animal1, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
