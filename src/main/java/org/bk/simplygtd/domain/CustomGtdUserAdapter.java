package org.bk.simplygtd.domain;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomGtdUserAdapter implements UserDetails {

    private static final long serialVersionUID = 1L;
	private final GtdUser gtdUser;
	public CustomGtdUserAdapter(GtdUser gtdUser){
		this.gtdUser = gtdUser;
	}
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		GrantedAuthority grantedAuthority = new GrantedAuthorityImpl("ROLE_USER");
		return Collections.singletonList(grantedAuthority);
	}

	@Override
	public String getPassword() {
		return this.gtdUser.getPassword();
	}

	@Override
	public String getUsername() {
		return this.gtdUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	public GtdUser getGtdUser() {
    	return gtdUser;
    }
	
	

}
