package com.m3.c216.assessment2.DVDLibrary.ui;

import com.m3.c216.assessment2.DVDLibrary.dao.DaoException;
import com.m3.c216.assessment2.DVDLibrary.dto.DVD;

import java.util.List;
import java.util.Locale;

public class View {
    private UserIO io;

    public View(UserIO io){
        this.io = io;
    }

    /**DVD TITLE*/
    public String getDvdTitle(){
        return io.readString("Please enter the DVD title");
    }

    /**CONTROLLER*/
    public int menuSelectionPrint() throws DaoException {
        io.print("Main Menu");
        io.print("1. Add a DVD to the collection ");
        io.print("2. Remove a DVD from the collection ");
        io.print("3. Edit an existing DVD ");
        io.print("4. List all DVDs in the collection");
        io.print("5. Search for a DVD");
        io.print("6. Exit the program");

        return io.readInt("Please select from the above choices.", 1,6);
    }


    /**EDITING DVDs*/
    public String editMenuSelection() throws DaoException {
        io.print("=== Edit DVD menu ===");
        io.print("Release date" +
                "\nMPAA rating" +
                "\nDirector's name" +
                "\nUser rating" +
                "\nStudio name" +
                "\nExit");
        return io.readString("Which category would you like to edit?");
        //String change = io.readString("Please enter the new edits:" );
        //return change;
    }

    public String edited(String edits){
        String changed = io.readString("Please enter the new " + edits);
        return changed;
    }




    /** ADDING DVDS:*/
    public DVD addDvdInfo(){
        //Method allows the user to provide a title, releaseDate...and returns the newly generated DVD object.
        String title = io.readString("Please enter the DVD title");
        String releaseDate = io.readString("Please enter the DVD release date.");
        String mpaaRating = io.readString("Please enter the DVD MPAA rating.");
        String director = io.readString("Please enter the director");
        String studio = io.readString("Please enter the studio name.");
        String userRating = io.readString("Please enter your new rating.");

        //Instantiating a new DVD object using the title as constructors
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }


    /**REMOVING DVDs*/
    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }
    public void displayRemoveDvdResult(DVD DvdInfo){
        if(DvdInfo != null){
            io.print(DvdInfo + " successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }


    /** LISTING ALL DVDS:*/
    public void displayDvdList(List<DVD> DVDList){
        //Don't make new a variable; it needs to take 'currentDVD' from addDvdInfo() method
        //The objects that are being changed are a result of those added in the list.
        for( DVD currentDVD : DVDList){
            String DvdInfo = String.format("" +
                            " %s \n" +
                            " Release : %s ||" +
                            " Rating : %s ||" +
                            " Director : %s ||" +
                            " Studio : %s ||" +
                            " Your Rating : %s ||",
                    currentDVD.getTitle().toUpperCase(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMpaaRating(),
                    currentDVD.getDirector(),
                    currentDVD.getStudio(),
                    currentDVD.getUserRating());
            io.print(DvdInfo);
        }
        io.readString(" \n Please hit enter to continue.");
    }



    public void searchDvd(DVD dvd){
        if( dvd != null){
            String searchInfo = String.format("" +
                            " %s  ---> ||" +
                            " Release : %s ||" +
                            " Rating : %s ||" +
                            " Director : %s ||" +
                            " Studio : %s ||" +
                            " Your Rating : %s ||",
                    dvd.getTitle(),
                    dvd.getReleaseDate(),
                    dvd.getMpaaRating(),
                    dvd.getDirector(),
                    dvd.getStudio(),
                    dvd.getUserRating());
            io.print(searchInfo);
        }else{
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue.");

//        if( dvd != null){
//            io.print(dvd.getTitle());
//            io.print(dvd.getReleaseDate());
//            io.print(dvd.getMpaaRating());
//            io.print(dvd.getDirector());
//            io.print(dvd.getStudio());
//            io.print(dvd.getUserRating());
//        }else{
//            io.print("No such DVD");
//        }
//        io.readString("Please hit enter to continue.");
    }


    public boolean dvdInDbCheck(DVD dvdToEdit){
        return dvdToEdit != null;
    }








    /**BANNERS: UI indicates user will be creating a new DVD*/
    public void displayCreateDvdBanner(){
        io.print("=== Create Student ===");
    }

    /**BANNERS: UI indicates user will be creating a new DVD*/
    public String displayNullAndAddDvdBanner(){
        return io.readString("That DVD does not exist. Would you like to add one? Please type Yes/No");
    }

    /**BANNERS: UI indicates user sucessfully created a new DVD*/
    public void displayCreateSuccessBanner(){
        io.readString("Student successfully created. Please hit enter to continue");
    }

    /**BANNERS: UI for viewing all DVDs*/
    public void displayDvdListBanner() {
        io.print("=== Display all DVDs ===");
    }

    /**BANNERS: UI for displaying edit command*/
    public void displayEditDvdBanner() {
        io.print("=== Edit DVDs ===");
    }

    /**BANNERS: UI for displaying successful edit*/
    public void displayEditResultBanner() {
        io.print("DVD Successfully edited.");
    }

    /**BANNERS: UI for displaying exit*/
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    /**BANNERS: UI displaying unknown commands*/
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    /**BANNERS: UI for displaying error*/
    public void displayErrorMessage(String errorMessage) {
        io.print("=== ERROR ===");
        io.print(errorMessage);
    }
}

