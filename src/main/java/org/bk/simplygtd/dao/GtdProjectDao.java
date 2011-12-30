package org.bk.simplygtd.dao;

import java.util.List;

import org.bk.simplygtd.domain.GtdProject;

public interface GtdProjectDao extends BaseDao<Long, GtdProject>{
	List<GtdProject> findGTDProjectsByGtdUser(String userName, int firstResult, int maxResults);
    Long countProjectsByUserName(String userName);
}
