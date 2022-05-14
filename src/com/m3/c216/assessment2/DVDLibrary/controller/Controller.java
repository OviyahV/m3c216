package com.m3.c216.assessment2.DVDLibrary.controller;

import com.m3.c216.assessment2.DVDLibrary.dao.Dao;
import com.m3.c216.assessment2.DVDLibrary.dao.DaoException;
import com.m3.c216.assessment2.DVDLibrary.dto.DVD;
import com.m3.c216.assessment2.DVDLibrary.ui.View;

import java.util.List;

public class Controller {
    private final View view;
    private final Dao dao;

    public Controller(Dao dao, View view){
        this.dao = dao;
        this.view = view;
    }


    /** ADDING NEW DVDs */
    private void createDVD() throws DaoException {
        view.displayCreateDvdBanner();
        DVD newDvd = view.addDvdInfo();
        dao.addDVD(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    /** LISTING DVDs */
    private void listDVD() throws DaoException {
        view.displayDvdListBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDvdList(dvdList);
    }

    /** REMOVING DVDs */
    private void removeDVD() throws DaoException {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdTitle();
        DVD removeDvd = dao.removeDVD(dvdTitle);
        view.displayRemoveDvdResult(removeDvd);
    }

    /** SEARCHING THROUGH THE DVDs LIST */
    private void searchDVD() throws DaoException {
        view.displayDvdListBanner();
        String dvdTitle = view.getDvdTitle();
        DVD dvd = dao.searchDVD(dvdTitle);
        view.searchDvd(dvd);
    }

    //  BANNERS

    /** UNKNOWN COMMAND BANNER */
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    /** EXIT MESSAGE BANNER */
    private void exitMessage() {
        view.displayExitBanner();
    }







    /** MAIN CONTROLLER */
    public void run(){
        boolean loop = true;
        int menu;

        try{
            while(loop){
                menu = view.menuSelectionPrint();
                switch (menu){
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVD();
                        break;
                    case 5:
                        searchDVD();
                        break;
                    case 6:
                        loop = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
        }
        catch (DaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    /** EDIT DVDs */
    private void editDVD() throws DaoException {
        //Display edit banner once editDVD() is selected in menu controller
        view.displayEditDvdBanner();
        // allow user to input the title of the DVD
        String dvdTitle = view.getDvdTitle();
        // Searching if dvd exist in the database
        DVD dvdToEdit = dao.searchDVD(dvdTitle);
        // if dvd does not exist
        if(!view.dvdInDbCheck(dvdToEdit)){
            // allow the user the option to add the dvd
            if(view.displayNullAndAddDvdBanner().equalsIgnoreCase("Yes")){
                createDVD();
            }
        // if dvd exist
        }else{
            // loop through the menu options for
            boolean loop = true;
            while (loop) {
                // the category they would like to edit
                String menu = view.editMenuSelection();
                switch (menu) {

                    case "Release date":
                        dvdToEdit.setReleaseDate(menu);
                        break;
                    case "MPAA rating":
                        dvdToEdit.setMpaaRating(menu);
                        break;
                    case "Director's name":
                        dvdToEdit.setDirector(menu);
                        break;
                    case "Studio name":
                        dvdToEdit.setStudio(menu);
                        break;
                    case "User rating":
                        dvdToEdit.setUserRating(menu);
                        break;
                    case "Exit":
                        loop = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        }
    }
}


