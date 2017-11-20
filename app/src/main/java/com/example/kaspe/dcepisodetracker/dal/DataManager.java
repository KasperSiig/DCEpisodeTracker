package com.example.kaspe.dcepisodetracker.dal;

import android.content.Context;

import com.example.kaspe.dcepisodetracker.be.Episode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by kaspe on 19-Nov-17.
 */

public class DataManager {

    public void saveEpisodes(List<Episode> episodes, Context ctx) throws IOException {
        FileOutputStream out = ctx.openFileOutput("episodes.ser", Context.MODE_PRIVATE);


        ObjectOutputStream oout = new ObjectOutputStream(out);
        oout.writeObject(episodes);
        oout.close();
        out.close();
    }

    public List<Episode> getEpisodes(Context ctx) throws IOException, ClassNotFoundException {

        List<Episode> episodes;
        FileInputStream in = ctx.openFileInput("episodes.ser");

        ObjectInputStream ois = new ObjectInputStream(in);
        episodes = (List<Episode>) ois.readObject();
        in.close();
        ois.close();
        return episodes;
    }

}
