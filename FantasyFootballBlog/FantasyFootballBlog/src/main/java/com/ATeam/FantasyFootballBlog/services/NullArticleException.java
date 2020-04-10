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
public class NullArticleException extends Exception {

    public NullArticleException(String msg) {

        super(msg);
    }

    public NullArticleException(String msg, Throwable innerCause) {

        super(msg, innerCause);
    }

}
