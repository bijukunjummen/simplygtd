package org.bk.simplygtd.service;

import java.util.List;

import org.bk.simplygtd.domain.GtdContext;
import org.bk.simplygtd.domain.GtdUser;

public interface GtdContextService {
	List<GtdContext> findContextsByGtdUser(GtdUser gtdUser);
	GtdContext persist(GtdContext gtdContext);
	GtdContext findById(Long id);
	List<GtdContext> findContextsByGtdUser(GtdUser gtdUser, int firstResult, int maxResults);
	long countContexts(GtdUser gtdUser);
	GtdContext update(GtdContext gtdContext);
	void remove(GtdContext gtdContext);
}
