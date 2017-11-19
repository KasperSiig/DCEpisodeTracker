package com.example.kaspe.dcepisodetracker.be;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kaspe on 19-Nov-17.
 */

public class Episode implements Serializable{

    private String name;
    private Integer season;
    private Integer episode;
    Date date;

    public Episode(String name, Integer season, Integer episode, String date) {
        this.name = name;
        this.season = season;
        this.episode = episode;
        this.date = stringToDate(date);
    }

    private Date stringToDate(String date) {
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm dd-MM-yyyy");
        Date t = null;
        try {
            t = ft.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return t;
    }

    public String getName() {
        return name;
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
