package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@NonNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPepole(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonByid(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }
    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id")UUID id){
        personService.deletePerson(id);
    }
    @PutMapping(path="{id}")
    public void updatePersonById(@PathVariable("id")UUID id,@NonNull @RequestBody Person persontoupdate){
        personService.updatePerson(id,persontoupdate);
    }
}
