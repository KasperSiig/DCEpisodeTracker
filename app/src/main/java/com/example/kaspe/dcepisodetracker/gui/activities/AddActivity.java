package com.example.kaspe.dcepisodetracker.gui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    private Button btnDate;
    private Button btnTime;
    private TextView lblDate;
    private TextView lblTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addModel = new AddModel();
        btnAdd = (Button) findViewById(R.id.btnAdd);
        etName = (EditText) findViewById(R.id.etName);
        etSeason = (EditText) findViewById(R.id.etSeason);
        etEpisode = (EditText) findViewById(R.id.etEpisode);
        btnDate = (Button) findViewById(R.id.btnDate);
        btnTime = (Button) findViewById(R.id.btnTime);
        lblDate = (TextView) findViewById(R.id.lblDate);
        lblTime = (TextView) findViewById(R.id.lbltime);

        setBtnAdd();
        setBtnDate();
        setBtnTime();

    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        setDateText();
        setTimeText();
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

    public void setBtnDate() {
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDate();
            }
        });
    }

    public void setBtnTime() {
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTime();
            }
        });
    }

    private void openTime() {
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }

    public void openDate() {
        Intent intent = new Intent(this, DateActivity.class);
        startActivity(intent);
    }

    private void addEpisode() throws IOException {
        String name = etName.getText().toString();
        String season = etSeason.getText().toString();
        String episodeText = etEpisode.getText().toString();
        String date = addModel.getTime() + " " + addModel.getDate();
        Episode episode = new Episode(name, Integer.parseInt(season), Integer.parseInt(episodeText), date);
        addModel.addEpisode(episode, this);
    }

    private void setDateText() {
        lblDate.setText(addModel.getDate());
    }

    private void setTimeText() {
        lblTime.setText(addModel.getTime());
    }
}
