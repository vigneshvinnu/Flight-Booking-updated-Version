package com.flight.project.security.payload.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class JwtResponseTest {
    @Test
    public void testConstructor() {
        ArrayList<String> stringList = new ArrayList<String>();
        JwtResponse actualJwtResponse = new JwtResponse("ABC123", "42", "janedoe", "jane.doe@example.org", stringList);
        actualJwtResponse.setAccessToken("ABC123");
        actualJwtResponse.setEmail("jane.doe@example.org");
        actualJwtResponse.setId("42");
        actualJwtResponse.setTokenType("ABC123");
        actualJwtResponse.setUsername("janedoe");
        assertEquals("ABC123", actualJwtResponse.getAccessToken());
        assertEquals("jane.doe@example.org", actualJwtResponse.getEmail());
        assertEquals("42", actualJwtResponse.getId());
        assertSame(stringList, actualJwtResponse.getRoles());
        assertEquals("ABC123", actualJwtResponse.getTokenType());
        assertEquals("janedoe", actualJwtResponse.getUsername());
    }
}

