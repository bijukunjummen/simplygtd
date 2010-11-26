package org.bk.simplygtd.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bk.simplygtd.domain.GtdUser;
import org.springframework.stereotype.Repository;

@Repository
public class JpaGtdUserDao extends JpaDao<Long, GtdUser> implements GtdUserDao {

	@Override
	public List<GtdUser> findAllGTDUsers(int firstResult, int maxResults) {
		return getEntityManager()
				.createQuery("select o from GtdUser o", GtdUser.class)
				.setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();
	}

	@Override
    public GtdUser findUserByUserName(String username) {
		TypedQuery<GtdUser> q = this.getEntityManager().createQuery("select o from GtdUser o where o.username=:username", GtdUser.class);
		q.setParameter("username", username);
		return  q.getSingleResult();
    }
}
