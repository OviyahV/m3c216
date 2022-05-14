package com.m3.c216.assessment2.DVDLibrary.dao;

import com.m3.c216.assessment2.DVDLibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class DaoFileImpl implements Dao {

    public static final String DVD_FILE = "DVDLibrary/dvd.txt";
    public static final String DELIMITER = "::";


    private DVD unmarshallDVD(String dvdAsText){
        // studentAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // 1234::Ada::Lovelace::Java-September1842
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in studentTokens.
        // Which should look like this:
        // ______________________________________
        // |    |   |        |                  |
        // |1234|Ada|Lovelace|Java-September1842|
        // |    |   |        |                  |
        // --------------------------------------
        //  [0]  [1]    [2]         [3]
        String[] dvdTokens = dvdAsText.split(DELIMITER);


        // Given the pattern above, the dvd title is in index 0 of the array.
        String dvdTitle = dvdTokens[0];

        // Which we can then use to create a new dvd object to satisfy
        // the requirements of the dvd constructor.
        DVD dvdFromFile = new DVD(dvdTitle);

        // However, there are 3 remaining tokens that need to be set into the
        // new dvd object. Do this manually by using the appropriate setters.

        // Index 1 - releaseDate
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        // Index 2 - mpaaRating
        dvdFromFile.setMpaaRating(dvdTokens[2]);

        // Index 3 - director
        dvdFromFile.setDirector(dvdTokens[3]);

        // Index 4 - studio
        dvdFromFile.setStudio(dvdTokens[4]);

        // Index 5 - userRating
        dvdFromFile.setUserRating(dvdTokens[5]);

        // We have now created a dvd! Return it!
        return dvdFromFile;

    }


    /**UNLOAD DVD FILE INTO MEMORY : For each line in the file, do the following:
     * * * Read the line into a String variable.
     * * * Pass the line to our unmarshallStudent method to parse it into Student
     * * * Put the newly created and initialized Student object into the student map.
     * * * Close the file.
     * */

    /**LOAD DVD ROSTER*/
    private void loadDvdRoster() throws DaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DaoException( "-_- Could not load roster data into memory.", e);
        }

        // currentLine holds the most recent line read from the file
        String currentLine;

        // currentStudent holds the most recent student unmarshalled
        DVD currentDVD;

        // Go through ROSTER_FILE line by line, decoding each line into a
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while(scanner.hasNextLine()){
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Dvd
            currentDVD = unmarshallDVD(currentLine);

            // We are going to use the dvd title as the map key for our dvd object.
            // Put currentDVD into the map using dvd title as the key
            dvds.put(currentDVD.getTitle(), currentDVD);
        }

        //close scanner
        scanner.close();
    }


    /** MARSHALL DVDs
     *
     * Organizes the dvd information from the memory object into
     * a line of text,so it can be properly written into a file:
     *
     * * * Take in a dvd.
     * * * Create a String consisting of dvd title, releaseDate...etc (in that order)
     * * * separated by the :: delimiter.
     *
     * IMPORTANT ! We must preserve the order of information as we translate our dvd
     * into text because we are eventually expecting to unmarshall it back into a dvd again.
     * */


    /**MARSHALL DVDs*/
    private String marshallDvd(DVD aDvd){
        // We need to turn a Dvd object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.

        // Start with the dvd title, since that's supposed to be first.
        String dvdAsText = aDvd.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;
        dvdAsText += aDvd.getDirector() + DELIMITER;
        dvdAsText += aDvd.getStudio() + DELIMITER;

        // last property - don't forget to skip the DELIMITER here.
        dvdAsText += aDvd.getUserRating();

        // We have now turned a dvd to text! Return it!
        return dvdAsText;

    }



    /** MARSHALL DVDs
     *
     * * * Open the file for writing.
     * * * Go through the Student objects in the student map one by one.
     * * * For each Student, do the following:
     * * * * * * Turn a Student to text, using our marshallStudent method, spaced by our delimiter
     * * * * * * Write the String to the output file.
     * * * Close the file.
     *
     * * * At the top of this method, in the try-catch block, we catch the IOException and translate it into a ClassRosterDaoException.
     * * * We're using a PrintWriter to write to the file (this was demonstrated in the Simple File IO lesson).
     * * * We flush the PrintWriter buffer each time through the for loop to force it to write the student to the file.
     * * *  We close the PrintWriter at the end.
     * */


    /**WRITE DVD ROSTER*/
    public void writeDvdRoster() throws DaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DaoException("Could not save DVD data.", e);
        }

        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            dvdAsText = marshallDvd(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }

        out.close();
    }










    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) throws DaoException {
        //loadDvdRoster();
        DVD newDvd = dvds.put(title, dvd);
        //writeDvdRoster();
        return newDvd;
    }

    @Override
    public DVD removeDVD(String title) throws DaoException {
        loadDvdRoster();
        DVD removeDvd = dvds.remove(title);
        writeDvdRoster();
        return removeDvd;
    }

    @Override
    public DVD searchDVD(String title) throws DaoException {
        //loadDvdRoster();
        return dvds.get(title);
    }

    @Override
    public DVD editDVD(String title, DVD dvd)throws DaoException {
        //loadDvdRoster();
        DVD editedDVD = dvds.put(title, dvd);
        //writeDvdRoster();
        return editedDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DaoException {
        //loadDvdRoster();
        return new ArrayList<>(dvds.values());
    }





}
