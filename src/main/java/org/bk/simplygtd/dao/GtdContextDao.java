package org.bk.simplygtd.dao;

import java.util.List;

import org.bk.simplygtd.domain.GtdContext;

public interface GtdContextDao extends BaseDao<Long, GtdContext>{
    List<GtdContext> findContextEntries(int firstResult, int maxResults);
    List<GtdContext> findContextsByGtdUser(String userName, int firstResult, int maxResults);
    List<GtdContext> findContextsByName(String name);
    Long countContextsByUserName(String userName);
}
