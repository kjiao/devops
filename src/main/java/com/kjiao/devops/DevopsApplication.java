package com.kjiao.devops;

import com.kjiao.devops.backend.persistence.domain.backend.Role;
import com.kjiao.devops.backend.persistence.domain.backend.User;
import com.kjiao.devops.backend.persistence.domain.backend.UserRole;
import com.kjiao.devops.backend.service.UserService;
import com.kjiao.devops.enums.PlansEnum;
import com.kjiao.devops.enums.RolesEnum;
import com.kjiao.devops.utils.UsersUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DevopsApplication implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(DevopsApplication.class);
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DevopsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User user = UsersUtils.createBasicUser();
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, new Role(RolesEnum.BASIC)));
		LOG.debug("creating user with username {}", user.getUsername());
		userService.createUser(user, PlansEnum.PRO,userRoles);
		LOG.debug("user {} created", user.getUsername());
	}
}
