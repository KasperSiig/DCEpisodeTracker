package com.example.kaspe.dcepisodetracker.dal;

import com.example.kaspe.dcepisodetracker.be.Episode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaspe on 19-Nov-17.
 */

public class DataManager {

    public void saveEpisodes(List<Episode> episodes) throws IOException {
        FileOutputStream out = new FileOutputStream("episodes.ser");

        ObjectOutputStream oout = new ObjectOutputStream(out);
        oout.writeObject(episodes);
        oout.close();
        out.close();
    }

    public List<Episode> loadEpisodes() throws IOException, ClassNotFoundException {

        List<Episode> episodes = new ArrayList<>();
        FileInputStream in = new FileInputStream("episodes.ser");

        ObjectInputStream ois = new ObjectInputStream(in);
        Episode episode;
        while ((episode = (Episode) ois.readObject()) != null) {
            episodes.add(episode);
        }
        in.close();
        ois.close();
        return episodes;
    }

}
