package tn.esprit.spring.FrontController;


import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import javax.mail.MessagingException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import net.bytebuddy.utility.RandomString;
import tn.esprit.spring.entity.ERole;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.payload.request.SignupRequest;
import tn.esprit.spring.payload.response.MessageResponse;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.MailService;



@Scope(value = "session")
@Controller(value = "fregisterController")
@ELBeanName(value = "fregisterController")
@Join(path = "/user/register", to = "/pages/client/userRegister.jsf")
public class UserRegisterFrontController {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	MailService mail;
	@Autowired
	UserRepository userRepository;
	@Autowired
    RoleRepository roleRepository;
	private String firstname;
	private String lastname;
	private long phone_number;
	private String address;
	private String username;
	private String email;
	private String password;
	
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
	public String register(){

		String randomCode = RandomString.make(64);

		// Create new user's account
		
		User user = new User(this.getFirstname(), 
				this.getLastname(),
				this.getPhone_number(), 
				this.getAddress(), 
				randomCode, 
				false,
				this.getUsername(),
				this.getEmail(),
				encoder.encode(this.getPassword()));

		Set<Role> roles = new HashSet<>();

		 
		Role r = roleRepository.findByName(ERole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(r);
		user.setRoles(roles);
		
		System.err.println("marhbee");
		try {
			mail.sendVerificationEmail(user);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userRepository.save(user);
		
		

		System.err.println("User registered successfully!");
		return "/pages/client/plsverify.xhtml?faces-redirect=true";

	}
}