package com.example.kaspe.dcepisodetracker.bll;

import com.example.kaspe.dcepisodetracker.be.Episode;
import com.example.kaspe.dcepisodetracker.dal.DataManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaspe on 19-Nov-17.
 */

public class AppLogic {

    // Start Singleton
    private static AppLogic instance;

    public static AppLogic getInstance() {
        if (instance == null) {
            instance = new AppLogic();
        }
        return instance;
    }

    private AppLogic() {
        dm = new DataManager();
    }
    // End Singleton

    private DataManager dm;

    private List<Episode> episodes = new ArrayList<>();

    public List<Episode> getEpisodes() throws IOException, ClassNotFoundException {
        loadEpisodes();
        episodes.add(new Episode("name", 2, 5, "02:00 12-12-2017"));
        return episodes;
    }

    public void addEpisode(Episode episode) throws IOException {
        episodes.add(episode);
        dm.saveEpisodes(episodes);
    }

    public void loadEpisodes() throws IOException, ClassNotFoundException {
        episodes = dm.loadEpisodes();
    }
}
