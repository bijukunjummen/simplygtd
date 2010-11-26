package org.bk.simplygtd.dao;

import java.util.List;

import org.bk.simplygtd.domain.GtdUser;

public interface GtdUserDao extends BaseDao<Long, GtdUser> {
	List<GtdUser> findAllGTDUsers(int firstResult, int maxResults);
	GtdUser findUserByUserName(String userName);
}
