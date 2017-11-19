package com.example.kaspe.dcepisodetracker.gui.models;

import com.example.kaspe.dcepisodetracker.be.Episode;
import com.example.kaspe.dcepisodetracker.bll.AppLogic;

import java.io.IOException;

/**
 * Created by kaspe on 19-Nov-17.
 */

public class AddModel {

    private AppLogic appLogic;

    public AddModel() {
        appLogic = AppLogic.getInstance();
    }

    public void addEpisode(Episode episode) throws IOException {
        appLogic.addEpisode(episode);
    }

}
