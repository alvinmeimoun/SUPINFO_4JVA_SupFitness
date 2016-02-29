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

/**
 * Méthodes d'accès à la BDD pour l'entité Race
 */
@Stateless
public class TrackFacade {
    @PersistenceContext(unitName = "4JVA_SupFitness-ejbPU")
    private EntityManager em;

    /**
     * Insert un Track dans la base de données
     * @param trackEntity TrackEntity à ajouter
     */
    public void create(TrackEntity trackEntity) {
        em.persist(trackEntity);
    }

    /**
     * Modifie un Track dans la base de données
     * @param trackEntity TrackEntity à modifier
     */
    public void edit(TrackEntity trackEntity) {
        em.merge(trackEntity);
    }

    /**
     * Supprime un Track dans la base de données
     * @param trackEntity TrackEntity à supprimer
     */
    public void remove(TrackEntity trackEntity) {
        em.remove(em.merge(trackEntity));
    }

    /**
     * Récupère un track par son ID
     * @param id ID du track à récupérer
     * @return TrackEntity
     */
    public TrackEntity find(Long id) {
        return em.find(TrackEntity.class, id);
    }
    
    /**
     * Récupère la liste des Track d'une Race
     * @param raceId ID de la Race
     * @return Liste de TrackEntity
     */
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

    /**
     * Récupère la liste de toutes les Tracks
     * @return Liste de TrackEntity
     */
    public List<TrackEntity> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TrackEntity.class));
        return em.createQuery(cq).getResultList();
    }

    /**
     * Récupère un certains nombre de Track
     * @param range Tableau à 2 valeurs indiquant en première position la position de départ et en deuxième la position limite
     * @return Liste de TrackEntity
     */
    public List<TrackEntity> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TrackEntity.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * @return Nombre de Track dans la base de données
     */
    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<TrackEntity> rt = cq.from(TrackEntity.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
