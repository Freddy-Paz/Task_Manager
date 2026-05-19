package com.example.Task.Manager.Service.mapper;

import com.example.Task.Manager.Controller.dto.taskItem;
import com.example.Task.Manager.Repository.Entity.tasksEntity;

public class TaskMapper {

    private TaskMapper(){};

    public static tasksEntity fromDtoToEntity(taskItem item, tasksEntity entity){

        entity.setDescription(item.getDescription());
        entity.setCompleted(item.isCompleted());

        return entity;
    }

    public static taskItem fromEntityToDto (tasksEntity entity, taskItem item){

        item.setId(entity.getId());
        item.setDescription(entity.getDescription());
        item.setCompleted(entity.isCompleted());
        
        return item;

    }
}
