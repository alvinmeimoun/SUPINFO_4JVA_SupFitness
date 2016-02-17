/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.entity;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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

    
    @Expose private Long id;
    @Expose private Double longitude;
    @Expose private Double latitude;
    @Expose private Double speed;
    @Expose private Date startDate;
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
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public TrackEntity setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * @return the longitude
     */
    @NotNull
    @Column(name = "LONGITUDE", nullable = false)
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public TrackEntity setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * @return the latitude
     */
    @NotNull
    @Column(name = "LATITUDE", nullable = false)
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public TrackEntity setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * @return the speed
     */
    @NotNull
    @Column(name = "SPEED", nullable = false)
    public Double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public TrackEntity setSpeed(Double speed) {
        this.speed = speed;
        return this;
    }

    /**
     * @return the startDate
     */
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public TrackEntity setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * @return the race
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="race_id")
    public RaceEntity getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public TrackEntity setRace(RaceEntity race) {
        this.race = race;
        return this;
    }
    
}
