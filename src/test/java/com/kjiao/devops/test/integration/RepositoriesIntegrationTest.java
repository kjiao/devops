package com.kjiao.devops.test.integration;

import com.kjiao.devops.backend.persistence.domain.backend.Plan;
import com.kjiao.devops.backend.persistence.domain.backend.Role;
import com.kjiao.devops.backend.persistence.domain.backend.User;
import com.kjiao.devops.backend.persistence.domain.backend.UserRole;
import com.kjiao.devops.backend.persistence.repositories.PlanRepository;
import com.kjiao.devops.backend.persistence.repositories.RoleRepository;
import com.kjiao.devops.backend.persistence.repositories.UserRepository;
import com.kjiao.devops.enums.PlansEnum;
import com.kjiao.devops.enums.RolesEnum;
import com.kjiao.devops.utils.UsersUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kjiao on 03/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoriesIntegrationTest {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {
        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        Plan retrievedPlan = planRepository.findOne(PlansEnum.BASIC.getId());
        Assert.assertNotNull(retrievedPlan);
     }
     @Test
     public void testCreateNewRole() throws Exception {
        Role userRole = createBasicRole(RolesEnum.BASIC);
        roleRepository.save(userRole);

        Role retrieve = roleRepository.findOne(RolesEnum.BASIC.getId());
        Assert.assertNotNull(retrieve);
     }
    @Test
    public void createNewUser() throws Exception {
        Plan basicPlan =  createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        User basicUser = UsersUtils.createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createBasicRole(RolesEnum.BASIC);
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole(basicUser, basicRole);

        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);
        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        basicUser = userRepository.save(basicUser);
        User newlyCreatedUser = userRepository.findOne(basicUser.getId());

        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId() != 0);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        Assert.assertNotNull(newlyCreatedUser.getPlan().getId());

        Set<UserRole> newlyCreatedUserUserRoles = newlyCreatedUser.getUserRoles();
        for (UserRole ur : newlyCreatedUserUserRoles) {
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());
        }
     }
    private Plan createPlan(PlansEnum plansEnum) {
        return new Plan(PlansEnum.BASIC);
     }

     private Role createBasicRole(RolesEnum rolesEnum) {
        return new Role(rolesEnum);
     }

}
