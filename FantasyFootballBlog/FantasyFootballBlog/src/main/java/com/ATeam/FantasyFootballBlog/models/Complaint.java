/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.models;

import java.util.Objects;

/**
 *
 * @author Buddy
 */
public class Complaint {
    private int complaintId;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.complaintId;
        hash = 97 * hash + Objects.hashCode(this.userComplaint);
        hash = 97 * hash + Objects.hashCode(this.userId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complaint other = (Complaint) obj;
        if (this.complaintId != other.complaintId) {
            return false;
        }
        if (!Objects.equals(this.userComplaint, other.userComplaint)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }
    private String userComplaint;
    private User userId;

    /**
     * @return the complaintId
     */
    public int getComplaintId() {
        return complaintId;
    }

    /**
     * @param complaintId the complaintId to set
     */
    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    /**
     * @return the userComplaint
     */
    public String getUserComplaint() {
        return userComplaint;
    }

    /**
     * @param userComplaint the userComplaint to set
     */
    public void setUserComplaint(String userComplaint) {
        this.userComplaint = userComplaint;
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }
    
}
