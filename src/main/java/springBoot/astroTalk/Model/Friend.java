package springBoot.astroTalk.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	private Long fId;
	
	public Friend(Long id, User user, Long fId) {
		super();
		Id = id;
		this.user = user;
		this.fId = fId;
	}

	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	@Override
	public String toString() {
		return "Friend [Id=" + Id + ", user=" + user + ", fId=" + fId + "]";
	}
		
}
