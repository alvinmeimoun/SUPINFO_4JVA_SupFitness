/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Antonin
 */
@Entity
@Table(name = "RACE")
public class RaceEntity implements Serializable {
    
    private static long serialVersionUID = 1L;

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
    
    private Long id;
    private UserEntity user;
    private List<TrackEntity> tracks;
    private Date startDate;
    private String name;

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
    public RaceEntity setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * @return the user
     */
    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public RaceEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    /**
     * @return the tracks
     */
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="race")
    public List<TrackEntity> getTracks() {
        return tracks;
    }

    /**
     * @param tracks the tracks to set
     */
    public RaceEntity setTracks(List<TrackEntity> tracks) {
        this.tracks = tracks;
        return this;
    }

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public RaceEntity setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    @NotNull
    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
