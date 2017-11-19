package com.example.kaspe.dcepisodetracker.gui.models;

import com.example.kaspe.dcepisodetracker.be.Episode;
import com.example.kaspe.dcepisodetracker.bll.AppLogic;

import java.io.IOException;
import java.util.List;

/**
 * Created by kaspe on 19-Nov-17.
 */

public class MainModel {

    private AppLogic appLogic;

    public MainModel() {
        appLogic = AppLogic.getInstance();
    }

    public List<Episode> getEpisodes() throws IOException, ClassNotFoundException {
        return appLogic.getEpisodes();
    }


}
