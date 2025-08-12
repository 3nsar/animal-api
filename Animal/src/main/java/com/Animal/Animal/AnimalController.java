package com.Animal.Animal;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimals(){
        return new ResponseEntity<>(animalService.getAllAnimals(), HttpStatus.OK);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int id){
        return new ResponseEntity<>(animalService.getAnimalById(id),HttpStatus.OK);
    }

    @PostMapping("/animal")
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal){
        Animal animal1 = animalService.addAnimal(animal);
        if( animal1 != null){
            return new ResponseEntity<>(animal1,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/animal/{id}")
    public ResponseEntity<String> deleteAnimalById(@PathVariable int id){
        Animal animal = animalService.getAnimalById(id);

        if(animal != null){
            animalService.deleteAnimalById(id);
            return new ResponseEntity<>("Animal Deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error could not delete animal", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
