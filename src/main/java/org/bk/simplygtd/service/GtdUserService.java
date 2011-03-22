package org.bk.simplygtd.service;

import java.util.List;

import org.bk.simplygtd.domain.GtdUser;

public interface GtdUserService {
	List<GtdUser> findAllGTDUsers(int firstResult, int maxResults);
	GtdUser findUserByUserName(String userName);
}
