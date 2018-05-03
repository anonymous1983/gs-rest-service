package com.commun.application.controller;

import com.commun.application.entity.Issue;
import com.commun.application.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class IssueController {
    @Autowired
    private IssueRepository issueRepository;


    @GetMapping(path = "/issue")
    public @ResponseBody
    Iterable<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
}
