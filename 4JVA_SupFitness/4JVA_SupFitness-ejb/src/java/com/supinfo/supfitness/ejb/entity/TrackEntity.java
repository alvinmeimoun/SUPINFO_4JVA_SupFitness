/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Antonin
 */
@Entity
@Table(name = "TRACK")
public class TrackEntity implements Serializable{
    
    private static long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private Long longitude;
    
    @NotNull
    private Long latitude;
    
    @NotNull
    private Long speed;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="race_id")
    private RaceEntity race;

    
    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the longitude
     */
    public Long getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public Long getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the speed
     */
    public Long getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the race
     */
    public RaceEntity getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public void setRace(RaceEntity race) {
        this.race = race;
    }
    
}
