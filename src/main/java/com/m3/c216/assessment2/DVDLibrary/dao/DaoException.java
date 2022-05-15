package com.m3.c216.assessment2.DVDLibrary.dao;

/**
 * By extending Exception, we inherit all of the
 * capabilities of Exception and then can add any
 * special features that we wish to add.
 */


public class DaoException extends Exception {


    /**
     * First constructor on the Exception class:
     * In cases where something is wrong in our application,
     * but it isn't caused by another exception.
     */
    public DaoException(String message){
     super(message);
    }

    /**
     * Second constructor on the Exception class:
     * In cases where something is wrong in our application
     * that is caused by another exception
     * in the underlying implementation e.g.  FileNotFoundException
     */
    public DaoException(String message, Throwable cause){
        super(message, cause);
    }


}
