package org.bk.simplygtd.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bk.simplygtd.domain.GtdProject;
import org.bk.simplygtd.domain.GtdUser;
import org.springframework.stereotype.Repository;

@Repository
public class JpaGtdProjectDao extends JpaDao<Long, GtdProject> implements GtdProjectDao{
    public JpaGtdProjectDao(){
        super(GtdProject.class);
    }
	@Override
	public List<GtdProject> findGTDProjectsByGtdUser(GtdUser gtdUser) {
		TypedQuery<GtdProject> q = this.entityManager.createQuery("select o from GtdProject o where o.gtdUser=:user", GtdProject.class);
		q.setParameter("user", gtdUser);
		return q.getResultList();
	}

	@Override
    public List<GtdProject> findGTDProjectsByGtdUserAndName(GtdUser gtdUser, String name) {
		TypedQuery<GtdProject> q = this.entityManager.createQuery("select o from GtdProject o where o.gtdUser=:user and o.name=:name", GtdProject.class);
		q.setParameter("user", gtdUser);
		q.setParameter("name", name);
		return q.getResultList();
    }
	
	
}
