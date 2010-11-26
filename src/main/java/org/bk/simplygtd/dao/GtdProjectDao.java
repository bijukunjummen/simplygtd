package org.bk.simplygtd.dao;

import java.util.List;

import org.bk.simplygtd.domain.GtdProject;
import org.bk.simplygtd.domain.GtdUser;

public interface GtdProjectDao extends BaseDao<Long, GtdProject>{
	List<GtdProject> findGTDProjectsByGtdUser(GtdUser gtdUser);
	List<GtdProject> findGTDProjectsByGtdUserAndName(GtdUser gtdUser, String name);
}
