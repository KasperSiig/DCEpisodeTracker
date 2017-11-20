package com.example.kaspe.dcepisodetracker.gui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kaspe.dcepisodetracker.R;
import com.example.kaspe.dcepisodetracker.be.Episode;
import com.example.kaspe.dcepisodetracker.gui.models.AddModel;

import java.io.IOException;

public class AddActivity extends AppCompatActivity {

    private AddModel addModel;
    private Button btnAdd;
    private EditText etName;
    private EditText etSeason;
    private EditText etEpisode;
    private EditText etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addModel = new AddModel();
        btnAdd = (Button) findViewById(R.id.btnAdd);
        etName = (EditText) findViewById(R.id.etName);
        etSeason = (EditText) findViewById(R.id.etSeason);
        etEpisode = (EditText) findViewById(R.id.etEpisode);
        etDate = (EditText) findViewById(R.id.etDate);

        setBtnAdd();

    }

    public void setBtnAdd() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    addEpisode();
                } catch (IOException e) {
                    etName.setText("hello");
                    e.printStackTrace();
                }
                finish();
            }
        });
    }

    private void addEpisode() throws IOException {
        String name = etName.getText().toString();
        String season = etSeason.getText().toString();
        String episodeText = etEpisode.getText().toString();
        String date = etDate.getText().toString();
        Episode episode = new Episode(name, Integer.parseInt(season), Integer.parseInt(episodeText), date);
        addModel.addEpisode(episode, this);
    }
}
