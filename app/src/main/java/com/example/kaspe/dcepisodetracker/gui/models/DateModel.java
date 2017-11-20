package com.example.kaspe.dcepisodetracker.gui.models;

import com.example.kaspe.dcepisodetracker.bll.AppLogic;

/**
 * Created by kaspe on 20-Nov-17.
 */

public class DateModel {
    private AppLogic appLogic;

    public DateModel() {
        appLogic = AppLogic.getInstance();
    }

    public void setDate(String date) {
        appLogic.setDate(date);
    }

    public void setTime(String time) {
        appLogic.setTime(time);
    }
}
