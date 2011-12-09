package org.bk.simplygtd.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.bk.simplygtd.domain.GtdContext;
import org.springframework.stereotype.Repository;

@Repository
public class JpaGtdContextDao extends JpaDao<Long, GtdContext> implements GtdContextDao{

    public JpaGtdContextDao(){
        super(GtdContext.class);
    }
	@Override
	public List<GtdContext> findContextEntries(int firstResult, int maxResults) {
		return this.entityManager.createQuery("select o from GtdContext o", GtdContext.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}



	@Override
	public List<GtdContext> findContextsByName(String name) {
		if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<GtdContext> c = cb.createQuery(GtdContext.class);
		Root<GtdContext> contexts = c.from(GtdContext.class);
		c.select(contexts).where(cb.equal(contexts.get("name"), name));
		
		
		TypedQuery<GtdContext> q = this.entityManager.createQuery(c);
		return q.getResultList();
	}


	@Override
    public List<GtdContext> findContextsByGtdUser(String userName, int firstResult, int maxResults) {
        TypedQuery<GtdContext> q = this.entityManager.createQuery("SELECT o FROM GtdContext o WHERE o.gtdUser.username = :userName order by o.name", GtdContext.class);
        q.setParameter("userName", userName);
        return q.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }


	@Override
    public Long countContextsByUserName(String userName) {
		TypedQuery<Long> q = this.getEntityManager().createQuery("select count(o) from GtdContext o where o.gtdUser.username=:userName", Long.class);
        q.setParameter("userName", userName);
		return q.getSingleResult();
    }

}
