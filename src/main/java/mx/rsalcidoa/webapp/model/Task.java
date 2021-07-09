package mx.rsalcidoa.webapp.model;

import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {
	
	@Id @Column(name="TASK_ID")
	private Long taskID;
	
	@JoinColumn(name = "LIST_ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private TaskList taskList; 
	
	@Column(name = "TASK_DESC", length = 25)
	private String taskDescription;
	
	@Column(name = "DONE")
    private Boolean isDone;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", nullable = false)
    private Calendar creationDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FINISH_DATE", nullable = false)
    private Calendar finishDate;

	public Long getTaskID() {
		return taskID;
	}

	public void setTaskID(Long taskID) {
		this.taskID = taskID;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList todoList) {
		this.taskList = todoList;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public Calendar getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Calendar finishDate) {
		this.finishDate = finishDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationDate, finishDate, isDone, taskDescription, taskID, taskList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(finishDate, other.finishDate)
				&& Objects.equals(isDone, other.isDone) && Objects.equals(taskDescription, other.taskDescription)
				&& taskID == other.taskID && Objects.equals(taskList, other.taskList);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Task [taskID=");
		builder.append(taskID);
		builder.append(", taskList=");
		builder.append(taskList);
		builder.append(", taskDesciption=");
		builder.append(taskDescription);
		builder.append(", isDone=");
		builder.append(isDone);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", finishDate=");
		builder.append(finishDate);
		builder.append("]");
		return builder.toString();
	}

}
