package com.example.Task.Manager.Repository.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "task")
@Data
public class tasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "description",length = 225, nullable = false)
    private String description;

    @Column(name = "completed", nullable = false )
    private boolean completed;

}
