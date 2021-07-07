package com.flight.project.security.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import com.flight.project.security.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AuthControllerTest {
    @Test
    public void testUpdateUserDetails() {
        AuthController authController = new AuthController();
        ResponseEntity<?> actualUpdateUserDetailsResult = authController
                .updateUserDetails(new User("janedoe", "jane.doe@example.org", "iloveyou"));
        assertNull(actualUpdateUserDetailsResult.getBody());
        assertEquals("<500 INTERNAL_SERVER_ERROR Internal Server Error,[]>", actualUpdateUserDetailsResult.toString());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualUpdateUserDetailsResult.getStatusCode());
    }

    @Test
    public void testUpdateUserDetails2() {
        ResponseEntity<?> actualUpdateUserDetailsResult = (new AuthController()).updateUserDetails(null);
        assertNull(actualUpdateUserDetailsResult.getBody());
        assertEquals("<500 INTERNAL_SERVER_ERROR Internal Server Error,[]>", actualUpdateUserDetailsResult.toString());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualUpdateUserDetailsResult.getStatusCode());
    }

    @Test
    public void testUpdateUserDetails3() {
        ResponseEntity<?> actualUpdateUserDetailsResult = (new AuthController()).updateUserDetails(mock(User.class));
        assertNull(actualUpdateUserDetailsResult.getBody());
        assertEquals("<500 INTERNAL_SERVER_ERROR Internal Server Error,[]>", actualUpdateUserDetailsResult.toString());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualUpdateUserDetailsResult.getStatusCode());
    }

    @Test
    public void testGetUserDetails() {
        ResponseEntity<?> actualUserDetails = (new AuthController()).getUserDetails("42");
        assertNull(actualUserDetails.getBody());
        assertEquals("<500 INTERNAL_SERVER_ERROR Internal Server Error,[]>", actualUserDetails.toString());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualUserDetails.getStatusCode());
    }
}

