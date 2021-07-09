package mx.rsalcidoa.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.rsalcidoa.webapp.model.Task;

public interface ITaskRepository extends JpaRepository<Task, Long> {

}
