package org.bk.simplygtd.service;

import javax.annotation.Resource;

import org.bk.simplygtd.dao.GtdUserDao;
import org.bk.simplygtd.domain.CustomGtdUserAdapter;
import org.bk.simplygtd.domain.GtdUser;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Resource private GtdUserDao gtdUserDao;
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
	    GtdUser gtdUser = this.gtdUserDao.findUserByUserName(userName);
	    CustomGtdUserAdapter userDetails = new CustomGtdUserAdapter(gtdUser);
	    return userDetails;
    }
}
