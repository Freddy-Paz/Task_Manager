package com.example.Task.Manager.Service;

import java.util.List;
import java.util.Optional;

import com.example.Task.Manager.Controller.dto.taskItem;

public interface taskService {

    List<taskItem> list();

    void create(taskItem item);

    void update(Integer id, taskItem item);

    void delete(Integer id);

    Optional<taskItem> listId(Integer id);

   



    
}
