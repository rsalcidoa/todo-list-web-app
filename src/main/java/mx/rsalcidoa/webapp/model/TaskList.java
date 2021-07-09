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
public class TaskList {
	
	@Id @Column(name = "LIST_ID")
	private Long listID;
	
    @JoinColumn(name = "USER_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    
	@Column(name = "LIST_NAME", length = 25)
	private String listName;
	    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", nullable = false)
    private Calendar creationDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FINISH_DATE", nullable = false)
    private Calendar finishDate;

	public Long getListID() {
		return listID;
	}

	public void setListID(Long listID) {
		this.listID = listID;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
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
		return Objects.hash(creationDate, finishDate, listID, listName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskList other = (TaskList) obj;
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(finishDate, other.finishDate)
				&& listID == other.listID && Objects.equals(listName, other.listName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskList [listID=");
		builder.append(listID);
		builder.append(", user=");
		builder.append(user);
		builder.append(", listName=");
		builder.append(listName);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", finishDate=");
		builder.append(finishDate);
		builder.append("]");
		return builder.toString();
	}

}
