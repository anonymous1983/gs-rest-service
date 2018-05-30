package com.commun.application.controller;

import com.commun.application.entity.Status;
import com.commun.application.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/v1")
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    // -------------------Retrieve All Status
    @GetMapping(path = "/status")
    public @ResponseBody
    Iterable<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    // -------------------Retrieve Single Status
    @GetMapping(path = "/status/{id}")
    public @ResponseBody
    Optional<Status> getStatus(@PathVariable("id") Integer id) {
        return statusRepository.findById(id);
    }

    // -------------------Retrieve Single Status
    @DeleteMapping(path = "/status/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteStatus(@PathVariable("id") Integer id, UriComponentsBuilder ucBuilder) {
        statusRepository.deleteById(id);
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = new HttpStatus();
        headers.setLocation(ucBuilder.path("/status/{id}").buildAndExpand(id).toUri());
        headers.set("id", id);
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // -------------------Create a Status
    @PostMapping(path = "/status")
    public @ResponseBody
    ResponseEntity<?> addNewStatus(@RequestBody Status status, UriComponentsBuilder ucBuilder) {
        Status s = new Status();
        s.setName(status.getName());
        s.setDescription(status.getDescription());
        s.setColor(status.getColor());
        s.setIcon(status.getIcon());
        statusRepository.save(s);
        //return "Saved";
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/status/{id}").buildAndExpand(status.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


}