package com.example.Task.Manager.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Task.Manager.Controller.dto.taskItem;
import com.example.Task.Manager.Repository.Entity.TaskRepository;
import com.example.Task.Manager.Repository.Entity.tasksEntity;
import com.example.Task.Manager.Service.mapper.TaskMapper;

@Service
public class taskServiceImpl implements taskService {

    private final TaskRepository taskRepository;

    public taskServiceImpl (TaskRepository taskRepository){
        this.taskRepository= taskRepository;
    }

    public List<taskItem> list() {

        return taskRepository.findAll().stream()
        .map(e->TaskMapper.fromEntityToDto(e, new taskItem()))
        .collect(Collectors.toList());
    }

    public Optional<taskItem> listId(Integer id){

        return taskRepository.findById(id)
        .map(e->TaskMapper.fromEntityToDto(e, new taskItem()));
       
    }

    @Override
    public void create (taskItem item){
        tasksEntity entity= TaskMapper.fromDtoToEntity(item,new tasksEntity());
        taskRepository.save(entity);
    }

    @Override
    public void update (Integer id, taskItem item){
        tasksEntity entity=taskRepository.getReferenceById(id);
        entity.setDescription(item.getDescription());
        entity.setCompleted(item.isCompleted());

        taskRepository.save(entity);
    }

    @Override
    public void delete(Integer id){
        taskRepository.deleteById(id);
    }

  
}
