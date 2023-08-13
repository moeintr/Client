package com.a.model.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("person-service")
public interface PersonServiceClient {
    @GetMapping("person/savePerson.do")
    Object savePerson(@RequestParam String name, @RequestParam String family);
}
