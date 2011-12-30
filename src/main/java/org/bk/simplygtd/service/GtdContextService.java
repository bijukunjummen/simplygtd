package org.bk.simplygtd.service;

import java.util.List;

import org.bk.simplygtd.domain.GtdContext;

public interface GtdContextService {
	GtdContext persistForUser(GtdContext gtdContext, String userName);
	GtdContext findById(Long id);
	List<GtdContext> findContextsByGtdUserName(String userName, int firstResult, int maxResults);
	Long countContextsByUserName(String userName);
	GtdContext updateForUser(GtdContext gtdContext, String userName);
	void remove(GtdContext gtdContext);
}
