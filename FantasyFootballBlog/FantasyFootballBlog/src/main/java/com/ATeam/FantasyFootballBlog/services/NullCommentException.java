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
public class NullCommentException extends Exception {
    
    public NullCommentException(String msg) {

        super(msg);
    }

    public NullCommentException(String msg, Throwable innerCause) {

        super(msg, innerCause);
    }
}
