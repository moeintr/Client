package com.a.model.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("find-person-with-car-service")
public interface FindServiceClient {
    @GetMapping("/find/findAllPersonWithCars")
    Object findAllPersonWithCars();

    @GetMapping("/find/findPersonWithCarsByPersonId")
    Object findPersonWithCarsByPersonId(@RequestParam Long personId);
}
