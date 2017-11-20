package com.example.kaspe.dcepisodetracker.gui.models;

import android.content.Context;

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

    public void addEpisode(Episode episode, Context ctx) throws IOException {
        appLogic.addEpisode(episode, ctx);
    }

    public String getDate() {
        return appLogic.getDate();
    }

    public String getTime() {
        return appLogic.getTime();
    }

}
