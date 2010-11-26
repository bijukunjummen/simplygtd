package org.bk.simplygtd.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.bk.simplygtd.domain.GtdContext;
import org.bk.simplygtd.domain.GtdUser;
import org.springframework.stereotype.Repository;

@Repository
public class JpaGtdContextDao extends JpaDao<Long, GtdContext> implements GtdContextDao{

	@Override
	public List<GtdContext> findContextEntries(int firstResult, int maxResults) {
		return this.entityManager.createQuery("select o from GtdContext o", GtdContext.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	@Override
	public List<GtdContext> findContextsByGtdUser(GtdUser gtdUser) {
        if (gtdUser == null) throw new IllegalArgumentException("The gtdUser argument is required");
        TypedQuery<GtdContext> q = this.entityManager.createQuery("SELECT o FROM GtdContext o WHERE o.gtdUser = :gtdUser", GtdContext.class);
        q.setParameter("gtdUser", gtdUser);
        return q.getResultList();
	}

	@Override
	public List<GtdContext> findContextsByName(String name) {
		if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
		TypedQuery<GtdContext> q = this.entityManager.createQuery("SELECT o from GtdContext o where o.name=:name", GtdContext.class);
		q.setParameter("name", name);
		return q.getResultList();
	}

	@Override
    public List<GtdContext> findContextsByGtdUser(GtdUser gtdUser, int firstResult, int maxResults) {
        if (gtdUser == null) throw new IllegalArgumentException("The gtdUser argument is required");
        TypedQuery<GtdContext> q = this.entityManager.createQuery("SELECT o FROM GtdContext o WHERE o.gtdUser = :gtdUser", GtdContext.class);
        q.setParameter("gtdUser", gtdUser);
        return q.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Override
    public long countContexts(GtdUser gtdUser) {
		TypedQuery<Long> q = this.getEntityManager().createQuery("select count(o) from GtdContext o where o.gtdUser=:gtdUser", Long.class);
		q.setParameter("gtdUser", gtdUser);
		return q.getSingleResult();
    }

}
