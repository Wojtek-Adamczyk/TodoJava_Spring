package todoapp.Todoapp.controller;

import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import todoapp.Todoapp.model.Task;
import todoapp.Todoapp.model.TaskRepository;

import java.util.List;
import java.util.logging.Logger;

@RepositoryRestController
public class TaskController
{
    private static final Logger logger = (Logger) LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;

    TaskController(final TaskRepository repository)
    {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    ResponseEntity<?> readAllTasks()
    {
        logger.warning("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

}
