package com.flight.project.security.security.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.flight.project.security.model.ERole;
import com.flight.project.security.model.Role;
import com.flight.project.security.model.User;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

public class UserDetailsImplTest {
    @Test
    public void testConstructor() {
        ArrayList<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        UserDetailsImpl actualUserDetailsImpl = new UserDetailsImpl("42", "janedoe", "jane.doe@example.org", "iloveyou",
                grantedAuthorityList);
        assertSame(grantedAuthorityList, actualUserDetailsImpl.getAuthorities());
        assertEquals("jane.doe@example.org", actualUserDetailsImpl.getEmail());
        assertEquals("42", actualUserDetailsImpl.getId());
        assertEquals("iloveyou", actualUserDetailsImpl.getPassword());
        assertEquals("janedoe", actualUserDetailsImpl.getUsername());
        assertTrue(actualUserDetailsImpl.isAccountNonExpired());
        assertTrue(actualUserDetailsImpl.isAccountNonLocked());
        assertTrue(actualUserDetailsImpl.isCredentialsNonExpired());
        assertTrue(actualUserDetailsImpl.isEnabled());
    }

    @Test
    public void testBuild() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        user.setId("42");
        user.setRoles(new HashSet<Role>());
        UserDetailsImpl actualBuildResult = UserDetailsImpl.build(user);
        assertEquals("janedoe", actualBuildResult.getUsername());
        assertEquals("iloveyou", actualBuildResult.getPassword());
        assertEquals("42", actualBuildResult.getId());
        assertEquals("jane.doe@example.org", actualBuildResult.getEmail());
    }

    @Test
    public void testBuild2() {
        Role role = new Role();
        role.setId("42");
        role.setName(ERole.ROLE_USER);

        HashSet<Role> roleSet = new HashSet<Role>();
        roleSet.add(role);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        user.setId("42");
        user.setRoles(roleSet);
        UserDetailsImpl actualBuildResult = UserDetailsImpl.build(user);
        assertEquals("jane.doe@example.org", actualBuildResult.getEmail());
        assertEquals("janedoe", actualBuildResult.getUsername());
        assertEquals("iloveyou", actualBuildResult.getPassword());
        assertEquals("42", actualBuildResult.getId());
        assertEquals("ROLE_USER",
                ((ArrayList<? extends GrantedAuthority>) actualBuildResult.getAuthorities()).get(0).getAuthority());
    }

    @Test
    public void testBuild3() {
        Role role = new Role();
        role.setId("42");
        role.setName(ERole.ROLE_USER);

        Role role1 = new Role();
        role1.setId("42");
        role1.setName(ERole.ROLE_USER);

        HashSet<Role> roleSet = new HashSet<Role>();
        roleSet.add(role1);
        roleSet.add(role);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        user.setId("42");
        user.setRoles(roleSet);
        UserDetailsImpl actualBuildResult = UserDetailsImpl.build(user);
        assertEquals("jane.doe@example.org", actualBuildResult.getEmail());
        assertEquals("iloveyou", actualBuildResult.getPassword());
        assertEquals("janedoe", actualBuildResult.getUsername());
        assertEquals("42", actualBuildResult.getId());
        assertEquals("ROLE_USER",
                ((ArrayList<? extends GrantedAuthority>) actualBuildResult.getAuthorities()).get(1).toString());
        assertEquals("ROLE_USER",
                ((ArrayList<? extends GrantedAuthority>) actualBuildResult.getAuthorities()).get(0).toString());
    }

    @Test
    public void testEquals() {
        assertFalse(UserDetailsImpl.build(new User("janedoe", "jane.doe@example.org", "iloveyou")).equals("42"));
        assertFalse(UserDetailsImpl.build(new User("janedoe", "jane.doe@example.org", "iloveyou")).equals(null));
    }
}

