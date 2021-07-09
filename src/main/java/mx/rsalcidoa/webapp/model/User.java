package mx.rsalcidoa.webapp.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id @Column(name = "USER_ID")
	private Long userID;
	
	@Column(name = "USER_NAME", length = 25)
	private String userName;
	
	@Column(name = "USER_PASS")
	private String userPassword;
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userID, userName, userPassword);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return userID == other.userID && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userID=");
		builder.append(userID);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userPassword=");
		builder.append(userPassword);
		builder.append("]");
		return builder.toString();
	}
	
}
