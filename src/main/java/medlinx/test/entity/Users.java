package medlinx.test.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class Users implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Max(value=10)
	@NotNull
	private int id;
	
	@Column(name="email")
	@NotNull
	@Max(value=255)
	private String email;
	
	@Column(name="password")
	@NotNull
	@Max(value=255)
	private String password;
	
	@Column(name="token")
	@Max(value=255)
	private String token;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;

}
