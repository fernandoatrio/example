package com.demo.web.user;

import static com.demo.persistence.user.UserDemoData.allData;

import static com.demo.persistence.user.UserSpecifications.hasLastName;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.persistence.user.User;
import com.demo.persistence.user.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository repo;
	
	@PostConstruct
	public void populateUserTable() {
		log.info("*** Populate Demo Data Base ***");
		this.repo.save(allData());
	}
	
	@GetMapping(value="/paginate", produces={MediaType.APPLICATION_JSON_VALUE})
	public Page<User> paginate(@PageableDefault(size=1) Pageable page) {
		return this.repo.findAll(page);
	}
	
	@GetMapping(value="/list", produces={MediaType.APPLICATION_JSON_VALUE})
	public List<User> list() {		
		return repo.findAll(new PageRequest(0, 20)).getContent();
	}
	
	@GetMapping(value="/listby", produces={MediaType.APPLICATION_JSON_VALUE})
	public List<User> listAll(@RequestParam String lastName) {
		return repo.findAll(hasLastName(lastName));
	}

}
