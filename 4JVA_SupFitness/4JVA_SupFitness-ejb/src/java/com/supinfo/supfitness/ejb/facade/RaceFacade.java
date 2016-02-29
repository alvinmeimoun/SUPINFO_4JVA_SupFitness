package com.supinfo.supfitness.ejb.facade;

import com.supinfo.supfitness.ejb.entity.RaceEntity;
import com.supinfo.supfitness.ejb.entity.RaceEntity_;
import com.supinfo.supfitness.ejb.entity.UserEntity;
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
 * Méthodes d'accès à la BDD pour l'entité Race
 */
@Stateless
public class RaceFacade {
    @PersistenceContext(unitName = "4JVA_SupFitness-ejbPU")
    private EntityManager em;

    /**
     * Ajoute une nouvelle entité
     * @param raceEntity RaceEntity à ajouter
     */
    public void create(RaceEntity raceEntity) {
        em.persist(raceEntity);
    }

    /**
     * Modifie une entité existante
     * @param raceEntity Entité à mettre à jour
     */
    public void edit(RaceEntity raceEntity) {
        em.merge(raceEntity);
    }

    /**
     * Supprime une entité de la BDD
     * @param raceEntity RaceEntity
     */
    public void remove(RaceEntity raceEntity) {
        em.remove(em.merge(raceEntity));
    }

    /**
     * Récupère une entité par son ID
     * @param id ID de la Race à récupérer
     * @return RaceEntity
     */
    public RaceEntity find(Long id) {
        return em.find(RaceEntity.class, id);
    }
    
    /**
     * Récupère la dernière Race liée à un utilisateur
     * @param user Entité de l'utilisateur
     * @return RaceEntity
     */
    public RaceEntity getLastRaceByUser(UserEntity user)
    {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<RaceEntity> q = criteriaBuilder.createQuery(RaceEntity.class);
        Root<RaceEntity> race = q.from(RaceEntity.class);
        q.select(race);
        
        q.where(criteriaBuilder.equal(race.get(RaceEntity_.user),user));
        q.orderBy(criteriaBuilder.desc(race.get(RaceEntity_.startDate)));
        
        return em.createQuery(q).setMaxResults(1).getSingleResult();
       
    }
    
    /**
     * Récupère toutes les Race liées à un utilisateur
     * @param user UserEntity
     * @return List de RaceEntity
     * @throws NoResultException aucune Race trouvée
     */
    public List<RaceEntity> findAllByUser(UserEntity user) throws NoResultException{
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<RaceEntity> criteriaQuery = criteriaBuilder.createQuery(RaceEntity.class);
        Root<RaceEntity> race = criteriaQuery.from(RaceEntity.class);
        
        criteriaQuery.where(criteriaBuilder.equal(race.get(RaceEntity_.user), user));
        
        
        try{
            return em.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException nre){
            return null;
        }
    }

    /**
     * Récupère toutes les Race de la base de données
     * @return Liste de RaceEntity
     */
    public List<RaceEntity> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(RaceEntity.class));
        return em.createQuery(cq).getResultList();
    }

    /**
     * Récupère un certains nombre de Race
     * @param range Tableau à 2 valeurs indiquant en première position la position de départ et en deuxième la position limite
     * @return Liste de RaceEntity
     */
    public List<RaceEntity> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(RaceEntity.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * @return Nombre de Race existantes en base de données
     */
    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<RaceEntity> rt = cq.from(RaceEntity.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    
    
}
