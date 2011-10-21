package org.bk.simplygtd.service;

import java.util.List;

import javax.annotation.Resource;

import org.bk.simplygtd.dao.GtdContextDao;
import org.bk.simplygtd.dao.GtdUserDao;
import org.bk.simplygtd.domain.GtdContext;
import org.bk.simplygtd.domain.GtdUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GtdContextServiceImpl implements GtdContextService{

	@Resource private GtdContextDao gtdContextDao;
	@Resource private GtdUserDao gtdUserDao;

	@Override
	@Transactional
    public GtdContext persistForUser(GtdContext gtdContext, String userName) {
		GtdUser gtdUser = this.gtdUserDao.findUserByUserName(userName);
		gtdContext.setGtdUser(gtdUser);
	    return gtdContextDao.persist(gtdContext);
    }	
	

	@Override
    public GtdContext findById(Long id) {
		return this.gtdContextDao.findById(id);
    }


	@Override
    public List<GtdContext> findContextsByGtdUserName(String userName, int firstResult, int maxResults) {
		return this.gtdContextDao.findContextsByGtdUser(userName,firstResult, maxResults);    
	}
	

	@Override
	public Long countContextsByUserName(String userName){
		return this.gtdContextDao.countContextsByUserName(userName);
	}

	@Override
	@Transactional
    public GtdContext updateForUser(GtdContext gtdContext, String userName) {
		GtdUser gtdUser = this.gtdUserDao.findUserByUserName(userName);
		gtdContext.setGtdUser(gtdUser);		
		return this.gtdContextDao.update(gtdContext);
    }

	@Override
	@Transactional
    public void remove(GtdContext gtdContext) {
	    this.gtdContextDao.remove(gtdContext);
	    
    }

	
	public void setGtdContextDao(GtdContextDao gtdContextDao) {
    	this.gtdContextDao = gtdContextDao;
    }

	public void setGtdUserDao(GtdUserDao gtdUserDao) {
    	this.gtdUserDao = gtdUserDao;
    }


	@Override
	@Transactional
	public void removeContextWithIds(List<Long> deleteIds) {
		if (deleteIds!=null){
			for (Long deleteId: deleteIds){
				GtdContext gtdContext = this.gtdContextDao.findById(deleteId);
				this.gtdContextDao.remove(gtdContext);
			}
		}
	}

	@Override
	@Transactional
	public void updateContextsForUser(List<GtdContext> updatedata, String userName) {
		GtdUser gtdUser = this.gtdUserDao.findUserByUserName(userName);
		if (updatedata!=null){
			for (GtdContext gtdContext: updatedata){
				gtdContext.setGtdUser(gtdUser);
				if (gtdContext.getId()!=null){
					this.gtdContextDao.update(gtdContext);
				}else{
					this.gtdContextDao.persist(gtdContext);					
				}
			}
		}
	}


}
