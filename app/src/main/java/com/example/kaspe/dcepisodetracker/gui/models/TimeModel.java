package com.example.kaspe.dcepisodetracker.gui.models;

import com.example.kaspe.dcepisodetracker.bll.AppLogic;

/**
 * Created by kaspe on 20-Nov-17.
 */

public class TimeModel {

    private AppLogic appLogic;

    public TimeModel() {
        appLogic = AppLogic.getInstance();
    }

    public void setTime(String time) {
        appLogic.setTime(time);
    }
}
