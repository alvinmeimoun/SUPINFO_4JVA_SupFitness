/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.facade;

import com.supinfo.supfitness.ejb.entity.RaceEntity;
import com.supinfo.supfitness.ejb.entity.RaceEntity_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Antonin
 */
@Stateless
public class RaceFacade {
    @PersistenceContext(unitName = "4JVA_SupFitness-ejbPU")
    private EntityManager em;

    public void create(RaceEntity raceEntity) {
        em.persist(raceEntity);
    }

    public void edit(RaceEntity raceEntity) {
        em.merge(raceEntity);
    }

    public void remove(RaceEntity raceEntity) {
        em.remove(em.merge(raceEntity));
    }

    public RaceEntity find(Long id) {
        return em.find(RaceEntity.class, id);
    }
    
   public List<RaceEntity> findAllByUserId(Long id) throws NoResultException{
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<RaceEntity> criteriaQuery = criteriaBuilder.createQuery(RaceEntity.class);
        Root<RaceEntity> race = criteriaQuery.from(RaceEntity.class);
        
        criteriaQuery.where(criteriaBuilder.equal(race.get(RaceEntity_.user), id));
        
        
        try{
            return em.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException nre){
            return null;
        }
    }

    public List<RaceEntity> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(RaceEntity.class));
        return em.createQuery(cq).getResultList();
    }

    public List<RaceEntity> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(RaceEntity.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<RaceEntity> rt = cq.from(RaceEntity.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
