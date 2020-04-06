/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.models;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author davidsteffes
 */

@Entity
public class Page {
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private int pageId;
    
    private String pageName;
    
    private String pageType;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.getPageId();
        hash = 47 * hash + Objects.hashCode(this.getPageName());
        hash = 47 * hash + Objects.hashCode(this.getPageType());
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
        final Page other = (Page) obj;
        if (this.getPageId() != other.getPageId()) {
            return false;
        }
        if (!Objects.equals(this.pageName, other.pageName)) {
            return false;
        }
        if (!Objects.equals(this.pageType, other.pageType)) {
            return false;
        }
        return true;
    }
    
    

    /**
     * @return the pageId
     */
    public int getPageId() {
        return pageId;
    }

    /**
     * @param pageId the pageId to set
     */
    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    /**
     * @return the pageName
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * @param pageName the pageName to set
     */
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    /**
     * @return the pageType
     */
    public String getPageType() {
        return pageType;
    }

    /**
     * @param pageType the pageType to set
     */
    public void setPageType(String pageType) {
        this.pageType = pageType;
    }
    
    
}
