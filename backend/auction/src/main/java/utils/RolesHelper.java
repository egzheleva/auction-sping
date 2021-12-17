package utils;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.auction.config.Constants;
import com.auction.model.User;

public class RolesHelper {

	public static Long getUserId(Authentication auth) {
		Long userId = null;
		if (!isAnonymousUser(auth)) {
			User user = (User) auth.getPrincipal();
			userId = user.getId();
		}
		
		return userId;
	}
	
	private static boolean isAnonymousUser(Authentication auth) {
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
		while(iterator.hasNext()) {
			GrantedAuthority next = iterator.next();
			if (next.getAuthority().equals(Constants.ROLE_ANONYMOUS)) {
				return true;
			}
		}
		
		return false;
	}
	
}
