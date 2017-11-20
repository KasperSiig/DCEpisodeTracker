package com.example.kaspe.dcepisodetracker.gui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.kaspe.dcepisodetracker.R;
import com.example.kaspe.dcepisodetracker.be.Episode;
import com.example.kaspe.dcepisodetracker.gui.models.MainModel;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainModel mainModel;

    private LinearLayout lLayout;
    private Button btnAdd;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainModel = new MainModel();

        lLayout = (LinearLayout) findViewById(R.id.lLayout);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        setBtnStart();
        try {
            makeButtons();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        try {
            makeButtons();
            mainModel.setDate();
            mainModel.setTime();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setBtnStart() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdd();
            }
        });
    }

    private void openAdd() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    private void makeButtons() throws IOException, ClassNotFoundException {
        lLayout.removeAllViews();
        List<Episode> episodes = mainModel.getEpisodes(this);
        for (final Episode episode : episodes) {
            Button btn = new Button(this);
            String text = episode.getSeason() + "x" + episode.getEpisode() + " - " + episode.getName();
            btn.setText(text);
            final Context ctx = this;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        mainModel.removeEpisode(episode, ctx);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        makeButtons();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            lLayout.addView(btn);
        }
    }
}
