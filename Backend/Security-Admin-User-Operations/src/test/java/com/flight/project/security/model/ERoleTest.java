package com.flight.project.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ERoleTest {
    @Test
    public void testValueOf() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        ERole.valueOf("Name");
    }

    @Test
    public void testValueOf2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        ERole.valueOf("foo");
    }

    @Test
    public void testValueOf3() {
        assertEquals(ERole.ROLE_ADMIN, ERole.valueOf("ROLE_ADMIN"));
    }

    @Test
    public void testValues() {
        ERole[] actualValuesResult = ERole.values();
        assertEquals(2, actualValuesResult.length);
        assertEquals(ERole.ROLE_USER, actualValuesResult[0]);
        assertEquals(ERole.ROLE_ADMIN, actualValuesResult[1]);
    }
}

