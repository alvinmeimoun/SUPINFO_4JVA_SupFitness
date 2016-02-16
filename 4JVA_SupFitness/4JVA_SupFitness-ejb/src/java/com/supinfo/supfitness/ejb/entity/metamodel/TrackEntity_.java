/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.entity.metamodel;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author Antonin
 */
@StaticMetamodel(TrackEntity_.class)
public class TrackEntity_ {
    
        public static volatile SingularAttribute<TrackEntity_, Long> id;
        public static volatile SingularAttribute<TrackEntity_, Long> latitude;
        public static volatile SingularAttribute<TrackEntity_, Long> longitude;
        public static volatile SingularAttribute<TrackEntity_, Long> speed;
        public static volatile SingularAttribute<TrackEntity_, Date> startDate;
        public static volatile SingularAttribute<TrackEntity_, RaceEntity_> race;
}
