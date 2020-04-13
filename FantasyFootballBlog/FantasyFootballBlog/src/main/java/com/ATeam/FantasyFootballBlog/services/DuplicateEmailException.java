/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.services;

/**
 *
 * @author Buddy
 */
public class DuplicateEmailException extends Exception {
    public DuplicateEmailException(String msg) {

        super(msg);
    }

    public DuplicateEmailException(String msg, Throwable innerCause) {

        super(msg, innerCause);
    }
    
}
