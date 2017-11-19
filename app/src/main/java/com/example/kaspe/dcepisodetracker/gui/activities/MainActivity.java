package com.example.kaspe.dcepisodetracker.gui.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
            showEpisodes();

        } catch (IOException e) {
            TextView tv = new TextView(this);
            tv.setText("hello");
            lLayout.addView(tv);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showEpisodes() throws IOException, ClassNotFoundException {
        List<Episode> episodes = mainModel.getEpisodes();
        for(Episode episode : episodes) {
            TextView textView = new TextView(this);
            textView.setText(String.valueOf(episode.getDate()));
            lLayout.addView(textView);
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
}
