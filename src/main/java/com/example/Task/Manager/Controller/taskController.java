package com.example.Task.Manager.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task.Manager.Controller.dto.taskItem;
import com.example.Task.Manager.Service.taskService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;





@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor

public class taskController {

    private final taskService taskService;

    @GetMapping
    public ResponseEntity<List<taskItem>> list(){
        List<taskItem> items= taskService.list();
        return ResponseEntity.ok(items);
       
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<taskItem> listId(@PathVariable("id") Integer id){

        Optional<taskItem> item=taskService.listId(id);
        return item
        .map(t->ResponseEntity.ok(t))
        .orElseGet(() ->ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody taskItem item){
        taskService.create(item);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody taskItem item){
        taskService.update(id,item);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}
