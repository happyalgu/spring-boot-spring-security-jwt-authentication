package com.bezkoder.springjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.repository.RoleRepository;

@Component
public class RoleRunner implements CommandLineRunner{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		for (ERole role : ERole.values()) {
			if( roleRepository.findByName(role).isPresent() ) {
				
			}else {
				roleRepository.save(new Role(role));
				System.out.println(role+" added succesfully !");
			}
		}
	}

}
