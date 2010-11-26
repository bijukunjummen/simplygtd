package org.bk.simplygtd.dao;

import java.util.Date;
import java.util.List;

import org.bk.simplygtd.domain.GtdAction;
import org.bk.simplygtd.domain.GtdUser;

public interface GtdActionDao extends BaseDao<Long, GtdAction>{
    List<GtdAction> findGTDActionsByGtdUser(GtdUser gtdUser);
    
    List<GtdAction> findGTDActionsByStartDateLessThanEquals(Date startDate);

}
