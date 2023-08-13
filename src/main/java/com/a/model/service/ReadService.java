package com.a.model.service;

import com.a.model.domain.Car;
import com.a.model.domain.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ReadService {
    private final PersonServiceClient personServiceClient;
    private final CarServiceClient carServiceClient;
    private final FindServiceClient findServiceClient;

    public ReadService(PersonServiceClient personServiceClient, CarServiceClient carServiceClient, FindServiceClient findServiceClient) {
        this.personServiceClient = personServiceClient;
        this.carServiceClient = carServiceClient;
        this.findServiceClient = findServiceClient;
    }
    public Object savePerson(Person person) {
        return personServiceClient.savePerson(person.getName(), person.getFamily());
    }
    public Object saveCar(Car car) {
        return carServiceClient.saveCar(car.getModel(), car.getPersonId());
    }
    public Object findCarsByPersonId(Long personId) {
        return carServiceClient.findCarsByPersonId(personId);
    }
    public Object findAllPersonWithCars() {
        return findServiceClient.findAllPersonWithCars();
    }
    public Object findPersonWithCarsByPersonId(Person person) {
        return findServiceClient.findPersonWithCarsByPersonId(person.getPersonId());
    }
}
