/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ATeam.FantasyFootballBlog.services;

/**
 *
 * @author davidsteffes
 */
public class NullNameException extends Exception {

    public NullNameException (String msg) {

        super(msg);
    }

    public NullNameException (String msg, Throwable innerCause) {

        super(msg, innerCause);
    }
    
}
