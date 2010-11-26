package org.bk.simplygtd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class GtdUser{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Size(min = 1)
	private String fullname;

	@NotNull
	@Size(min = 1)
	private String username;

	@NotNull
	@Size(min = 1)
	private String password;

	@Version
	@Column(name = "version")
	private Integer version;

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: ").append(getId()).append(", ");
		sb.append("Version: ").append(getVersion()).append(", ");
		sb.append("Fullname: ").append(getFullname()).append(", ");
		sb.append("Username: ").append(getUsername()).append(", ");
		sb.append("Password: ").append(getPassword());
		return sb.toString();
	}

}
