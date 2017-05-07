package com.kjiao.devops.utils;

import com.kjiao.devops.backend.persistence.domain.backend.User;

/**
 * Created by kjiao on 07/05/2017.
 */
public class UsersUtils {

    private UsersUtils() {
        throw new AssertionError("Non instantiable");
    }

    public static User createBasicUser() {
        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("me@example.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("12334564");
        user.setCountry("GB");
        user.setEnabled(true);
        user.setDescription("a basic user");
        user.setProfileImageUrl("ab.com/image");
        return user;
    }

}
