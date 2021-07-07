package com.flight.project.security.payload.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MessageResponseTest {
    @Test
    public void testConstructor() {
        MessageResponse actualMessageResponse = new MessageResponse("Not all who wander are lost");
        actualMessageResponse.setMessage("Not all who wander are lost");
        assertEquals("Not all who wander are lost", actualMessageResponse.getMessage());
    }
}

