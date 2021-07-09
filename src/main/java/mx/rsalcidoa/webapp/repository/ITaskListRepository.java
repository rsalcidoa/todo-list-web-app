package mx.rsalcidoa.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.rsalcidoa.webapp.model.TaskList;

public interface ITaskListRepository extends JpaRepository<TaskList, Long> {

}
