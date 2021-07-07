package com.flight.project.security.controller;

import com.flight.project.security.model.ERole;
import com.flight.project.security.model.Role;
import com.flight.project.security.model.User;
import com.flight.project.security.payload.request.LoginRequest;
import com.flight.project.security.payload.request.SignupRequest;
import com.flight.project.security.payload.response.JwtResponse;
import com.flight.project.security.payload.response.MessageResponse;
import com.flight.project.security.repository.RoleRepository;
import com.flight.project.security.repository.UserRepository;
import com.flight.project.security.security.jwt.JwtUtils;
import com.flight.project.security.security.services.UserDetailsImpl;
import com.flight.project.security.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userrepository;

	@Autowired
	RoleRepository rolerepository;

	@Autowired
	UserService userservice;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userrepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userrepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = rolerepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = rolerepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: ARole is not found."));
					roles.add(adminRole);

					break;
				
				default:
					Role userRole =rolerepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: URole is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userrepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	 @PutMapping("/update-user")
	    public ResponseEntity<?> updateUserDetails(@RequestBody User user){
	        try{
	            User fetchUser = this.userservice.getUserById(user.getId());
	            user.setPassword(fetchUser.getPassword());
	            this.userservice.updateUser(user);
	            return new ResponseEntity<>(user, HttpStatus.OK);
	        }catch (Exception e){
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/get-user")
	    public ResponseEntity<?> getUserDetails(@RequestParam String id){
	        try{
	            User user = this.userservice.getUserById(id);
	            User filteredUser = new User();
	            filteredUser.setId(user.getId());
	            filteredUser.setEmail(user.getEmail());
	            filteredUser.setUsername(user.getUsername());
	            filteredUser.setRoles(user.getRoles());



	            return new ResponseEntity<>(filteredUser, HttpStatus.OK);
	        }catch (Exception e){
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	    }
}
