package com.example.Task.Manager.Repository.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<tasksEntity,Integer>{

}
