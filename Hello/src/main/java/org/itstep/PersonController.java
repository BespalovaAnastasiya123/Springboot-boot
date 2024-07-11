package org.itstep;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person(1L, "Ivan", "Ivanov"));
        persons.add(new Person(2L, "Petr", "Petrov"));
    }
    @GetMapping({"", "/"})
    public List<Person> getAllPerson(){
        return persons;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id")Long id){
        Person person = persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(person == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        persons.add(person);
             return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    /*
  fetch('
http://localhost:8080/persons'
', {
    method: 'GET'
  })
  .then(response=>response.json());

fetch('
http://localhost:8080/persons'
', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({"name": "Jane"})
          });

  fetch('
http://localhost:8080/persons/1
', {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({"id":"name":"surname"})
  });

  fetch('
http://localhost:8080/persons/1
', {
    method: 'DELETE'
  });
 */

}
