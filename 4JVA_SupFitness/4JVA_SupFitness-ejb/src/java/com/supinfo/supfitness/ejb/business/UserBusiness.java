package com.supinfo.supfitness.ejb.business;

import com.supinfo.supfitness.ejb.entity.UserEntity;
import com.supinfo.supfitness.ejb.facade.UserFacade;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class UserBusiness {
    
    @EJB
    private UserFacade userFacade;
    
    public UserBusiness(){
        
    }
    
    /**
     * Create or update a new user
     * @param userObject UserEntity
     */
    public void addOrUpdateUser(UserEntity userObject){
        boolean isNew = false;
        if(userObject.getId() == null || userObject.getId() == 0){
            isNew = true;
        } else {
            if(userFacade.find(userObject.getId()) == null){
                isNew = true;
            }
        }
        if(isNew){
            userFacade.create(userObject);
        } else {
            userFacade.edit(userObject);
        }
    }
    
     public UserEntity find(Long id) {
         
         return userFacade.find(id);
     }
    
}
