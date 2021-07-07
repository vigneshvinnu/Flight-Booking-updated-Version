package com.flight.project.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testConstructor() {
        User actualUser = new User();
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setId("42");
        actualUser.setPassword("iloveyou");
        HashSet<Role> roleSet = new HashSet<Role>();
        actualUser.setRoles(roleSet);
        actualUser.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("42", actualUser.getId());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(roleSet, actualUser.getRoles());
        assertEquals("janedoe", actualUser.getUsername());
    }

    @Test
    public void testConstructor2() {
        User actualUser = new User("janedoe", "jane.doe@example.org", "iloveyou");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setId("42");
        actualUser.setPassword("iloveyou");
        HashSet<Role> roleSet = new HashSet<Role>();
        actualUser.setRoles(roleSet);
        actualUser.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("42", actualUser.getId());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(roleSet, actualUser.getRoles());
        assertEquals("janedoe", actualUser.getUsername());
    }
}

