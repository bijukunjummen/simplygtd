package org.bk.simplygtd.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.bk.simplygtd.domain.GtdAction;
import org.bk.simplygtd.domain.GtdUser;
import org.springframework.stereotype.Repository;

@Repository
public class JpaGtdActionDao extends JpaDao<Long, GtdAction> implements GtdActionDao{
    public List<GtdAction> findGTDActionsByGtdUser(GtdUser gtdUser) {
        if (gtdUser == null) throw new IllegalArgumentException("The gtdUser argument is required");
        EntityManager em = this.getEntityManager();
        TypedQuery<GtdAction> q = em.createQuery("SELECT GtdAction FROM GtdAction AS gtdaction WHERE gtdaction.gtdUser = :gtdUser", GtdAction.class);
        q.setParameter("gtdUser", gtdUser);
        return q.getResultList();
    }
    
    public List<GtdAction> findGTDActionsByStartDateLessThanEquals(Date startDate) {
        if (startDate == null) throw new IllegalArgumentException("The startDate argument is required");
        EntityManager em = this.getEntityManager();
        TypedQuery<GtdAction> q = em.createQuery("SELECT GtdAction FROM GtdAction AS gtdaction WHERE gtdaction.startDate <= :startDate", GtdAction.class);
        q.setParameter("startDate", startDate);
        return q.getResultList();
    }

}
