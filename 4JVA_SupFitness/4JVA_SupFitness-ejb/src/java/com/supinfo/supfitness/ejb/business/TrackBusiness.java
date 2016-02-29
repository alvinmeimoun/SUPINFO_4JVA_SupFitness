/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.business;

import com.supinfo.supfitness.ejb.entity.TrackEntity;
import com.supinfo.supfitness.ejb.facade.TrackFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;



/**
 * Logique correspondant à l'entité Track
 */
@Stateless
@LocalBean
public class TrackBusiness  {
    @EJB
    private TrackFacade trackFacade;
    
    public TrackBusiness(){
        
    }
    public List<TrackEntity> findAll(){
        return trackFacade.findAll();
    }
    /**
     * Insert ou met à jour un Track
     */
    public void addOrUpdateTrack(TrackEntity trackObject){
        boolean isNew = false;
        if(trackObject.getId() == null || trackObject.getId() == 0){
            isNew = true;
        } else {
            if(trackFacade.find(trackObject.getId()) == null){
                isNew = true;
            }
        }
        if(isNew){
            trackFacade.create(trackObject);
        } else {
            trackFacade.edit(trackObject);
        }
    }
    
    /**
     * Récupère la liste de tout les tracks
     * @param raceId null : tout les tracks<br/>Autre : Tout les tracks d'un Race
     * @return Liste de TrackEntity
     */
    public List<TrackEntity> findAllTrack(Long raceId){
        if(raceId == null){
            return trackFacade.findAll();
        } else {
            return trackFacade.findByRaceId(raceId);
        }
    }
    
    /**
     * Récupère un Track
     * @param trackId ID du track à récupérer
     * @return TrackEntity
     */
    public TrackEntity find(Long trackId)
    {
        return trackFacade.find(trackId);
    }
    
    /**
     * Supprime un track
     * @param track TrackEntity à supprimer
     * @return Succès
     */
    public boolean deleteTrack(TrackEntity track){
       
          try 
          {
          trackFacade.remove(track);
          return true;
          }
          catch(Exception e)
          {
              return false;
          }
    }
}
