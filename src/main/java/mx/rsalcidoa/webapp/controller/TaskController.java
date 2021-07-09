package mx.rsalcidoa.webapp.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.rsalcidoa.webapp.model.Task;
import mx.rsalcidoa.webapp.repository.ITaskRepository;

@RestController
public class TaskController {
	
	@Autowired
	ITaskRepository repository;
	
	@GetMapping("/task")
	public List<Task> listTasks() {
		return repository.findAll();
	}
	
	@GetMapping("/task/{taskID}")
	public Optional<Task> getTask(@PathVariable Long taskID) {
		return repository.findById(taskID);
	}
	
	@PostMapping("/task")
	public Task addTask(@RequestBody Task newTask) {
		newTask.setIsDone(false);
		newTask.setCreationDate(Calendar.getInstance());
		return repository.save(newTask);
	}

	@PutMapping("/task/{taskID}")
	public Optional<Task> updateTask(@RequestBody Task newTask, @PathVariable Long taskID) {
		return repository.findById(taskID)
				.map(task -> {
					task.setTaskDescription(newTask.getTaskDescription());
					task.setIsDone(newTask.getIsDone());
					if (task.getIsDone().equals(Boolean.TRUE)) {
						task.setFinishDate(Calendar.getInstance());
					}
					return repository.save(task);
				});
	}
	
	@DeleteMapping("/task/{taskID}")
	public void deleteTask(@PathVariable Long taskID) {
		repository.deleteById(taskID);
	}

}
