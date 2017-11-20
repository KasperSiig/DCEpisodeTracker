package com.example.kaspe.dcepisodetracker.bll;

import android.content.Context;

import com.example.kaspe.dcepisodetracker.be.Episode;
import com.example.kaspe.dcepisodetracker.dal.DataManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public List<Episode> getEpisodes(Context ctx) throws IOException, ClassNotFoundException {
        episodes = dm.getEpisodes(ctx);
        Collections.sort(episodes, new Comparator<Episode>() {
            @Override
            public int compare(Episode o1, Episode o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return episodes;
    }

    public void addEpisode(Episode episode, Context ctx) throws IOException {
        episodes.add(episode);
        dm.saveEpisodes(episodes, ctx);
    }

    public void removeEpisode(Episode episode, Context ctx) throws IOException {
        for(Episode episode1 : episodes) {
            if (episode1.getName().equals(episode.getName())) {
                episodes.remove(episode1);
                break;
            }
        }
        dm.saveEpisodes(episodes, ctx);
    }
}
