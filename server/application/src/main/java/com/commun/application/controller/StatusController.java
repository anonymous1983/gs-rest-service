package com.commun.application.controller;

import com.commun.application.entity.Status;
import com.commun.application.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping(path = "/status")
    public @ResponseBody
    Iterable<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    @PostMapping(path = "/status")
    public @ResponseBody
    String addNewStatus(@RequestBody Status status){
        Status s = new Status();
        s.setName(status.getName());
        s.setDescription(status.getDescription());
        s.setColor(status.getColor());
        s.setIcon(status.getIcon());
        statusRepository.save(s);
        return "Saved";
    }


}
