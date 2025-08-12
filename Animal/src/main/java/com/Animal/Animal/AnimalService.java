package com.Animal.Animal;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepo animalRepo;

    public AnimalService(AnimalRepo animalRepo){
        this.animalRepo = animalRepo;
    }

    public List<Animal> getAllAnimals(){
        return animalRepo.findAll();
    }

    public Animal getAnimalById(int id){
        return animalRepo.findById(id).orElse(null);
    }

    public Animal addAnimal(Animal animal){
        return animalRepo.save(animal);
    }

    public Animal updateAnimal(int id, Animal animal){
        if(animalRepo.existsById(id)){
            animal.setId(id);
            return animalRepo.save(animal);
        }else{
            return null;
        }
    }

    public void deleteAnimalById(int id){
        animalRepo.deleteById(id);
    }



}
