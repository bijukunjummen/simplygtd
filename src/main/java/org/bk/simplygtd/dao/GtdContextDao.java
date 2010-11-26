package org.bk.simplygtd.dao;

import java.util.List;

import org.bk.simplygtd.domain.GtdContext;
import org.bk.simplygtd.domain.GtdUser;

public interface GtdContextDao extends BaseDao<Long, GtdContext>{
    List<GtdContext> findContextEntries(int firstResult, int maxResults);
    List<GtdContext> findContextsByGtdUser(GtdUser gtdUser);
    List<GtdContext> findContextsByGtdUser(GtdUser gtdUser, int firstResult, int maxResults);
    List<GtdContext> findContextsByName(String name);
    long countContexts(GtdUser gtdUser);
}
