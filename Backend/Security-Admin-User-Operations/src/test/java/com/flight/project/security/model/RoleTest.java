package com.flight.project.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RoleTest {
    @Test
    public void testConstructor() {
        Role actualRole = new Role();
        actualRole.setId("42");
        actualRole.setName(ERole.ROLE_USER);
        assertEquals("42", actualRole.getId());
        assertEquals(ERole.ROLE_USER, actualRole.getName());
    }

    @Test
    public void testConstructor2() {
        Role actualRole = new Role(ERole.ROLE_USER);
        actualRole.setId("42");
        actualRole.setName(ERole.ROLE_USER);
        assertEquals("42", actualRole.getId());
        assertEquals(ERole.ROLE_USER, actualRole.getName());
    }
}

