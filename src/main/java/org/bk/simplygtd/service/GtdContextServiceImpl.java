package org.bk.simplygtd.service;

import java.util.List;

import javax.annotation.Resource;

import org.bk.simplygtd.dao.GtdContextDao;
import org.bk.simplygtd.domain.GtdContext;
import org.bk.simplygtd.domain.GtdUser;
import org.springframework.stereotype.Service;

@Service
public class GtdContextServiceImpl implements GtdContextService{

	@Resource private GtdContextDao gtdContextDao;
	@Override
    public List<GtdContext> findContextsByGtdUser(GtdUser gtdUser) {
	    return this.gtdContextDao.findContextsByGtdUser(gtdUser);
    }
	
	@Override
    public GtdContext persist(GtdContext gtdContext) {
	    return gtdContextDao.persist(gtdContext);
    }

	@Override
    public GtdContext findById(Long id) {
		return this.gtdContextDao.findById(id);
    }

	@Override
    public List<GtdContext> findContextsByGtdUser(GtdUser gtdUser, int firstResult, int maxResults) {
		return this.gtdContextDao.findContextsByGtdUser(gtdUser,firstResult, maxResults);
    }

	@Override
    public long countContexts(GtdUser gtdUser) {
		return this.gtdContextDao.countContexts(gtdUser);
    }

	@Override
    public GtdContext update(GtdContext gtdContext) {
		return this.gtdContextDao.update(gtdContext);
    }

	@Override
    public void remove(GtdContext gtdContext) {
	    this.gtdContextDao.remove(gtdContext);
	    
    }
}
