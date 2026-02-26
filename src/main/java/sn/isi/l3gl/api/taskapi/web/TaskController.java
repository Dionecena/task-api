package sn.isi.l3gl.api.taskapi.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.api.taskapi.web.dto.CreateTaskRequest;
import sn.isi.l3gl.api.taskapi.web.dto.UpdateStatusRequest;
import sn.isi.l3gl.core.taskcore.domain.Task;
import sn.isi.l3gl.core.taskcore.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody CreateTaskRequest request) {
        return taskService.createTask(request.getTitle(), request.getDescription());
    }

    @GetMapping
    public List<Task> listTasks() {
        return taskService.listTasks();
    }

    @PutMapping("/{id}/status")
    public Task updateStatus(@PathVariable("id") Long id, @RequestBody UpdateStatusRequest request) {
        return taskService.updateStatus(id, request.getStatus());
    }

    @GetMapping("/done/count")
    public long countCompletedTasks() {
        return taskService.countCompletedTasks();
    }
}
