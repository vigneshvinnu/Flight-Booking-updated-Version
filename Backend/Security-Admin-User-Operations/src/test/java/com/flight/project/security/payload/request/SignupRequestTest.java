package com.flight.project.security.payload.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class SignupRequestTest {
    @Test
    public void testConstructor() {
        SignupRequest actualSignupRequest = new SignupRequest();
        actualSignupRequest.setEmail("jane.doe@example.org");
        actualSignupRequest.setPassword("iloveyou");
        HashSet<String> stringSet = new HashSet<String>();
        actualSignupRequest.setRole(stringSet);
        actualSignupRequest.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualSignupRequest.getEmail());
        assertEquals("iloveyou", actualSignupRequest.getPassword());
        assertSame(stringSet, actualSignupRequest.getRoles());
        assertEquals("janedoe", actualSignupRequest.getUsername());
    }
}

