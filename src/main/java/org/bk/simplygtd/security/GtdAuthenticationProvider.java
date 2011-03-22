package org.bk.simplygtd.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.bk.simplygtd.dao.GtdUserDao;
import org.bk.simplygtd.domain.GtdAuthority;
import org.bk.simplygtd.domain.GtdUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class GtdAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Resource private GtdUserDao gtdUserDao;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
	        throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		GtdUser user = this.gtdUserDao.findUserByUserName(username);
		String expectedPassword = user.getPassword();
		String inputPassword  = (String)authentication.getCredentials();
		if (expectedPassword.equals(inputPassword)){
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			Collection<GtdAuthority> gtdAuthorities = user.getGtdAuthorities();
			if (gtdAuthorities!=null){
				for (GtdAuthority gtdAuthority: gtdAuthorities){
					authorities.add(new GrantedAuthorityImpl(gtdAuthority.getName().toString()));
				}
			}
			return new User(username, expectedPassword, true, true, true, true, authorities);
		}
		
		return null;
	}

	public void setGtdUserDao(GtdUserDao gtdUserDao) {
    	this.gtdUserDao = gtdUserDao;
    }

}
