package tn.esprit.spring.FrontController;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import net.bytebuddy.utility.RandomString;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.UserConnected;
import tn.esprit.spring.payload.response.JwtResponse;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.jwt.JwtUtils;
import tn.esprit.spring.security.services.UserDetailsImpl;
import tn.esprit.spring.service.MailService;
import tn.esprit.spring.service.UserServiceImpl;

@Scope(value = "session")
@Controller(value = "fsigninController")
@ELBeanName(value = "fsigninController")
@Join(path = "/user/signin", to = "/pages/client/userSignIn.jsf")
public class UserSigninFrontController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	MailService mail;

	@Autowired
	UserServiceImpl userserviceI;
	private String npassword;
	private String firstname;
	private String lastname;
	private long phone_number;
	private String address;
	private String email;
	private String username;
	private String password;
	private String out;
	private String outmail;
	private String outreset;
	

	private User profile;

	private List<User> allusers;

	
	public String getOutreset() {
		return outreset;
	}


	public void setOutreset(String outreset) {
		this.outreset = outreset;
	}


	public String getOutmail() {
		return outmail;
	}

	
	public String getNpassword() {
		return npassword;
	}


	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}


	public void setOutmail(String outmail) {
		this.outmail = outmail;
	}

	public User getProfile() {
		if (profile == null) {
			profile = UserConnected.userconnected;
		}
		return profile;
	}

	public void setProfile(User profile) {
		this.profile = profile;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
	}

	public String signin() {
		if (userserviceI.chackact(this.getUsername())) {
			try {
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(this.getUsername(), this.getPassword()));

				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = jwtUtils.generateJwtToken(authentication);

				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
						.collect(Collectors.toList());
				UserConnected.iduser = userDetails.getId();
				UserConnected.userconnected = userserviceI.findById(userDetails.getId());
				System.err.println(UserConnected.iduser);
				System.err.println(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
						userDetails.getEmail(), roles));
				this.setOut("user signed in");
				return "/pages/client/sujet.xhtml?faces-redirect=true";
			} catch (BadCredentialsException bb) {
				this.setOut("no valid credentials");
			}
		} else {
			this.setOut("user not activated");
		}
		return null;
	}

	public void update() {
		System.err.println(profile.getFirstname());
		userserviceI.UpdateProfile(profile);
		UserConnected.userconnected = profile;

	}

	public String logout() {
		userserviceI.Logout();
		return "/pages/client/userSignIn.xhtml?faces-redirect=true";
	}

	public void verifymail() {
		System.err.println(this.getEmail());
		User u = userserviceI.findbyemail(this.getEmail());
		if (u == null) {
			this.setOutmail("enter existing mail");
			System.err.println("not good");
		} else {
			String randomCode = RandomString.make(64);
			this.setOutmail("Check you mail");
			u.setVerificationCode(randomCode);
			userserviceI.UpdateProfile(u);
			try {
				mail.sendresetpwd(u);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		

	}

	public String reset() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String token = request.getParameter("token");
		//System.err.println("hedha -> "+token);
		if(this.getPassword().equals(this.getNpassword())){
		String pwd =encoder.encode(this.getPassword());
		int i=userserviceI.resetpwd(pwd, token);
		System.err.println(i);
		if(i>0){
			return "/pages/client/userSignIn.xhtml?faces-redirect=true";
		}
		else{
			this.setOutreset("No valid token !");
			return null;
		}
		}
		else {
			this.setOutreset("Miss matching Password!");
			return null;
		}
		
	

	}
}