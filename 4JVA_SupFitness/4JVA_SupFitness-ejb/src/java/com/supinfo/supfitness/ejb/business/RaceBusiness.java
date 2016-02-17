/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.business;

import com.supinfo.supfitness.ejb.entity.RaceEntity;
import com.supinfo.supfitness.ejb.entity.TrackEntity;
import com.supinfo.supfitness.ejb.entity.UserEntity;
import com.supinfo.supfitness.ejb.facade.RaceFacade;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RaceBusiness {
    
    @EJB
    private RaceFacade raceFacade;
    
    public RaceBusiness(){
        
    }
    
    public RaceEntity findOne(Long raceId){
        return raceFacade.find(raceId);
    }

    public void addOrUpdateRace(RaceEntity raceObject){
        boolean isNew = false;
        if(raceObject.getId() == null || raceObject.getId() == 0){
            isNew = true;
        } else {
            if(raceFacade.find(raceObject.getId()) == null){
                isNew = true;
            }
        }
        if(isNew){
            if(raceObject.getTracks() == null)
            {
                List<TrackEntity> tracks = new ArrayList<TrackEntity>();
                raceObject.setTracks(tracks);
            }
    
            raceFacade.create(raceObject);
        } else {
            raceFacade.edit(raceObject);
        }
    }
    
      public List<RaceEntity> findAllByUser(UserEntity user) {
          
          return raceFacade.findAllByUser(user);
      }
}
