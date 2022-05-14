package com.m3.c216.assessment2.DVDLibrary;

import com.m3.c216.assessment2.DVDLibrary.controller.Controller;
import com.m3.c216.assessment2.DVDLibrary.dao.Dao;
import com.m3.c216.assessment2.DVDLibrary.dao.DaoFileImpl;
import com.m3.c216.assessment2.DVDLibrary.ui.View;
import com.m3.c216.assessment2.DVDLibrary.ui.UserIO;
import com.m3.c216.assessment2.DVDLibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        Dao myDao = new DaoFileImpl();

        View myView = new View(myIo);
        Controller controller = new Controller(myDao, myView);
        controller.run();
    }

}
