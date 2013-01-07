package forecast;

import static org.junit.Assert.*;

import javax.security.auth.Subject;

import org.junit.Test;

import forecast.security.MockRolePrincipal;
import forecast.security.MockUserPrincipal;
import forecast.security.SecurityUtils;


public class SecurityUtilTest {
	
	@Test
	public void testPrincipals() {
		Subject s = new Subject();
		s.getPrincipals().add(new MockUserPrincipal("t1"));
		
		assertEquals(SecurityUtils.getUserId(s),"t1");
		
		s.getPrincipals().add(new MockRolePrincipal("Admin"));
		
		assertFalse(SecurityUtils.isUserInRole(s, "User"));		
		s.getPrincipals().add(new MockRolePrincipal("User"));
		assertTrue(SecurityUtils.isUserInRole(s, "User"));
		assertTrue(SecurityUtils.isUserInRole(s, "Admin"));
		
		assertEquals(SecurityUtils.getUserName(s),"Tarja Tuntematon");
		
	}

}
