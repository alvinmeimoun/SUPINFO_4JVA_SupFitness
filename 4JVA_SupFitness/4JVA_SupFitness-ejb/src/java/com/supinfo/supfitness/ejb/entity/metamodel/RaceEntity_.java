/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.entity.metamodel;

import java.util.Date;
import java.util.List;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author Antonin
 */
@StaticMetamodel(RaceEntity_.class)
public class RaceEntity_ {
    
    	public static volatile SingularAttribute<RaceEntity_, Long> id;
        public static volatile SingularAttribute<RaceEntity_, UserEntity_> user;
        public static volatile SingularAttribute<RaceEntity_, List<TrackEntity_>> tracks;
        public static volatile SingularAttribute<RaceEntity_, String> name;
        public static volatile SingularAttribute<RaceEntity_, Date> startDate;
}
