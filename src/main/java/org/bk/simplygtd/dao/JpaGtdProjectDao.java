package org.bk.simplygtd.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bk.simplygtd.domain.GtdProject;
import org.springframework.stereotype.Repository;

@Repository
public class JpaGtdProjectDao extends JpaDao<Long, GtdProject> implements GtdProjectDao{
    public JpaGtdProjectDao(){
        super(GtdProject.class);
    }
    
	@Override
	public List<GtdProject> findGTDProjectsByGtdUser(String userName, int firstResult, int maxResults) {
		TypedQuery<GtdProject> q = this.entityManager.createQuery("select o from GtdProject o where o.gtdUser.username=:userName", GtdProject.class);
		q.setParameter("userName", userName);
		return q.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	
    @Override
    public Long countProjectsByUserName(String userName) {
        TypedQuery<Long> q = this.entityManager.createQuery("select count(o) from GtdProject o where o.gtdUser.username=:userName", Long.class);
        q.setParameter("userName", userName);
        return q.getSingleResult();
    }
	
	
}
