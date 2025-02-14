package com.example.EasyLearn.repository;

import com.example.EasyLearn.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(path = "resttasks")
public interface TaskRepository extends JpaRepository<Task, Long> {
}
