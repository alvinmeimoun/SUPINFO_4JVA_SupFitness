/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.business;

import com.supinfo.supfitness.ejb.entity.RaceEntity;
import com.supinfo.supfitness.ejb.facade.RaceFacade;
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
            raceFacade.create(raceObject);
        } else {
            raceFacade.edit(raceObject);
        }
    }
    
      public List<RaceEntity> findAllByUserId(Long id) {
          
          return raceFacade.findAllByUserId(id);
      }
}
