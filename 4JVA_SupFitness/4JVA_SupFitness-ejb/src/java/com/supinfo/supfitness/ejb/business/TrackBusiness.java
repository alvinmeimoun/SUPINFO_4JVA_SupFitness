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



@Stateless
@LocalBean
public class TrackBusiness  {
    @EJB
    private TrackFacade trackFacade;
    
    public TrackBusiness(){
        
    }
    
    /**
     * Create or update a new track
     * @param trackObject TrackEntity
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
    
    public List<TrackEntity> findAllTrack(Long raceId){
        if(raceId == null){
            return trackFacade.findAll();
        } else {
            return trackFacade.findByRaceId(raceId);
        }
    }
    
    public TrackEntity find(Long trackId)
    {
        return trackFacade.find(trackId);
    }
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
