package com.commun.application.repository;

import com.commun.application.entity.Issue;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Integer> {
}
