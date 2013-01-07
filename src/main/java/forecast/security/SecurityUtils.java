package forecast.security;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import javax.security.auth.Subject;

/**
 * Mock class to mimic JAAS security access
 * @author pjohanss
 *
 */
public class SecurityUtils {
	
	/**
	 * Discover if user is a member of a role
	 * @param subject
	 * @param role
	 * @return
	 */
	
	public static boolean isUserInRole(Subject subject,String role) {
		Set <MockRolePrincipal> principals = subject.getPrincipals(MockRolePrincipal.class);
		for (Principal p:principals) {
			if (p.getName().equalsIgnoreCase(role)) return true;
		}
		return false;
	}
	/**
	 * Get user's username
	 * @param s
	 * @return
	 */
	public static String getUserName(Subject s) {
		Set<MockUserPrincipal> principals = s.getPrincipals(MockUserPrincipal.class);		
		for (Principal p:principals) {
			if ("ttesti".equals(p.getName())) {
				return "Teuvo Testi"; 
			}
		}
		return "Tarja Tuntematon";
	}
	/**
	 * Get user's userid (or null, if not authenticated)
	 * @return
	 */
	public static String getUserId(Subject s) {
		Set<MockUserPrincipal> principals = s.getPrincipals(MockUserPrincipal.class);		
		for (Principal p:principals) {
			return p.getName();
		}
		return null;
	}
	
	public static Subject getCurrentSubject() {
		Subject s = new Subject();
		s.getPrincipals().add(new MockUserPrincipal("ttesti"));
		s.getPrincipals().add(new MockRolePrincipal("Admin"));
		s.getPrincipals().add(new MockRolePrincipal("User"));
		s.getPrincipals().add(new MockRolePrincipal("Controller"));
		s.getPrincipals().add(new MockRolePrincipal("Manager"));
		return s;
	}
	

}
