package com.a.api;

import com.a.common.annotation.TestURL;
import com.a.model.domain.Car;
import com.a.model.domain.Person;
import com.a.model.service.ReadService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/read")
@Scope("singleton")
public class ReadAPI {
    private final ReadService readService;

    public ReadAPI(ReadService readService) {
        this.readService = readService;
    }
    @TestURL(url = "http://localhost:9909/read/savePerson.do?name=moein&family=torogh")
    @GetMapping("/savePerson.do")
    public ResponseEntity<Object> savePerson(@RequestParam String name, @RequestParam String family) {
        return new ResponseEntity<>(readService.savePerson(new Person().setName(name).setFamily(family)), HttpStatus.OK);
    }
    @TestURL(url = "http://localhost:9909/read/saveCar.do?model=bmw&personId=1")
    @GetMapping("/saveCar.do")
    public ResponseEntity<Object> saveCar(@RequestParam String model, @RequestParam String personId) {
        return new ResponseEntity<>(readService.saveCar(new Car().setModel(model).setPersonId(Long.parseLong(personId))), HttpStatus.OK);
    }
    @TestURL(url = "http://localhost:9909/read/findCarsByPersonId?personId=1")
    @GetMapping("/findCarsByPersonId")
    public ResponseEntity<Object> findCarsByPersonId(@RequestParam String personId) {
        return new ResponseEntity<>(readService.findCarsByPersonId(Long.parseLong(personId)), HttpStatus.OK);
    }
    @TestURL(url = "http://localhost:9909/read/findAllPersonWithCars?")
    @GetMapping("/findAllPersonWithCars")
    public ResponseEntity<Object> findAllPersonWithCars() {
        return new ResponseEntity<>(readService.findAllPersonWithCars(), HttpStatus.OK);
    }
    @TestURL(url = "http://localhost:9909/read/findPersonWithCarsByPersonId?personId=1")
    @GetMapping("/findPersonWithCarsByPersonId")
    public ResponseEntity<Object> findPersonWithCarsByPersonId(@RequestParam String personId) {
        return new ResponseEntity<>(readService.findPersonWithCarsByPersonId(new Person().setPersonId(Long.parseLong(personId))), HttpStatus.OK);
    }
}
