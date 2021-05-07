package tn.esprit.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;
import tn.esprit.spring.entity.ERole;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.UserConnected;
import tn.esprit.spring.payload.request.LoginRequest;
import tn.esprit.spring.payload.request.SignupRequest;
import tn.esprit.spring.payload.response.JwtResponse;
import tn.esprit.spring.payload.response.MessageResponse;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.jwt.JwtUtils;
import tn.esprit.spring.security.services.UserDetailsImpl;
import tn.esprit.spring.service.MailService;
import tn.esprit.spring.service.UserService;
import tn.esprit.spring.service.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	UserService userservice;
	@Autowired
	UserServiceImpl userserviceI;
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
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if(userserviceI.chackact(loginRequest.getUsername())){
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		UserConnected.iduser = userDetails.getId();
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}
        else {
        	return ResponseEntity.ok("user not activated");
        }
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		String randomCode = RandomString.make(64);

		// Create new user's account
		
		User user = new User(signUpRequest.getFirstname(), 
							 signUpRequest.getLastname(),
							 signUpRequest.getPhone_number(), 
							 signUpRequest.getAddress(), 
							 randomCode, 
							 signUpRequest.isActivated(),
							 signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

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
		
		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
	    
		if (userservice.verify(code)) {
	        return "verify_success";
	    } else {
	        return "verify_fail";
	    }
	}

	@PutMapping("/update")
	public User updateprof(@RequestBody User u){
		return userserviceI.UpdateProfile(u);
	}
	
	@GetMapping("/getuser")
	public User getconnecteduser(){
		return userserviceI.getuserconnected();
	}
	@GetMapping("/logout")
	public String logout(){
		return userserviceI.Logout();
	}
	@GetMapping("/getAll")
	@ResponseBody
	private List<User> getAllusers() {
		return userserviceI.getAll();
				
	}
	
}
