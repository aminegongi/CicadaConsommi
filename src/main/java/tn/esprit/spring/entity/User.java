package tn.esprit.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Please enter your first name")
	@Size(max = 20)
	private String firstname;
	
	@NotBlank(message="Please enter your last name")
	@Size(max = 20)
	private String lastname;
	

	private long phone_number;
	
	@NotBlank(message="Please enter your home address")
	@Size(max = 100)
	private String address;
	
	@Size(max = 64)
	private String verificationCode;
	
	private boolean activated;
	
	@NotBlank(message="Please enter your username")
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}


	public User(String firstname,String lastname, long phone_number,String address,String verificationCode, boolean activated,String username,String password,Set<Role> roles) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone_number = phone_number;
		this.address = address;
		this.verificationCode = verificationCode;
		this.activated = activated;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}


	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(String firstname, String lastname, long phone_number, String address, String username, String email, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone_number = phone_number;
		this.address = address;
		this.username = username;
		this.email = email;
		this.password = password;
	}


	public User(String firstname, String lastname, long phone_number, String address, String verificationCode , boolean activated ,String username, String email, String password){
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone_number = phone_number;
		this.address = address;
		this.verificationCode = verificationCode;
		this.activated = activated;
		this.username = username;
		this.email = email;
		this.password = password;
	
	}


	public boolean isActivated() {
		return activated;
	}


	public void setActivated(boolean activated) {
		this.activated = activated;
	}


	public String getVerificationCode() {
		return verificationCode;
	}


	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}


	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
