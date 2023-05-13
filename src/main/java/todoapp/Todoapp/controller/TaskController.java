package todoapp.Todoapp.controller;

import org.jetbrains.annotations.Contract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import todoapp.Todoapp.model.Task;
import todoapp.Todoapp.model.TaskRepository;

import java.awt.print.Pageable;
import java.util.List;

@RepositoryRestController
public class TaskController
{
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;


    TaskController(final TaskRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/todos", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks()
    {
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    ResponseEntity<List<Task>> readAllTasks(Pageable page)
    {
        logger.warn("Custom pageable");
        return ResponseEntity.ok(repository.findAll((Sort) page));
    }

}
