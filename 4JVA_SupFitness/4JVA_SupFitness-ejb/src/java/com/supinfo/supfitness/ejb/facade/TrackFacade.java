/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.facade;

import com.supinfo.supfitness.ejb.entity.RaceEntity_;
import com.supinfo.supfitness.ejb.entity.TrackEntity;
import com.supinfo.supfitness.ejb.entity.TrackEntity_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class TrackFacade {
   @PersistenceContext(unitName = "4JVA_SupFitness-ejbPU")
    private EntityManager em;

    public void create(TrackEntity trackEntity) {
        em.persist(trackEntity);
    }

    public void edit(TrackEntity trackEntity) {
        em.merge(trackEntity);
    }

    public void remove(TrackEntity trackEntity) {
        em.remove(em.merge(trackEntity));
    }

    public TrackEntity find(Long id) {
        return em.find(TrackEntity.class, id);
    }
    
    public List<TrackEntity> findByRaceId(Long raceId){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TrackEntity> criteriaQuery = criteriaBuilder.createQuery(TrackEntity.class);
        Root<TrackEntity> tracks = criteriaQuery.from(TrackEntity.class);
        
        criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(
                tracks.get(TrackEntity_.race).get(RaceEntity_.id), raceId));
        
        criteriaQuery = criteriaQuery.orderBy(criteriaBuilder.asc(tracks.get(TrackEntity_.startDate)));
        
        try{
            return em.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException nre){
            return null;
        }
    }
    
   /* public TrackEntity findByUsername(String username) throws NoResultException{
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TrackEntity> criteriaQuery = criteriaBuilder.createQuery(TrackEntity.class);
        Root<TrackEntity> user = criteriaQuery.from(TrackEntity.class);
        
        criteriaQuery.where(criteriaBuilder.equal(user.get(TrackEntity_.), username));
        
        try{
            return em.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException nre){
            return null;
        }
    }*/

    public List<TrackEntity> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TrackEntity.class));
        return em.createQuery(cq).getResultList();
    }

    public List<TrackEntity> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TrackEntity.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<TrackEntity> rt = cq.from(TrackEntity.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
