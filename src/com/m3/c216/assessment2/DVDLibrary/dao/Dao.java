package com.m3.c216.assessment2.DVDLibrary.dao;
import com.m3.c216.assessment2.DVDLibrary.dto.DVD;

import java.util.List;

/**
 * This interface defines the methods that must be implemented
 * by any class that wants to play the role of DAO in the application.
 * Each class would be different but all would implement that
 * same interface, ensuring that they are all well encapsulated.
 *
 * The DAO is responsible for the persistence and retrieval of Student data.
 */

public interface Dao {

    DVD addDVD(String title, DVD dvd)throws DaoException;

    DVD removeDVD(String title)throws DaoException;

    DVD searchDVD(String title)throws DaoException;

    DVD editDVD(String title, DVD dvd) throws DaoException;

    List<DVD> getAllDVDs() throws DaoException;







}
