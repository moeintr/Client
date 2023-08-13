package com.a.model.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("car-service")
public interface CarServiceClient {
    @GetMapping("/car/saveCar.do")
    Object saveCar(@RequestParam String model, @RequestParam Long personId);

    @GetMapping("/car/findCarsByPersonId")
    Object findCarsByPersonId(@RequestParam Long personId);
}
