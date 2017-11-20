package com.example.kaspe.dcepisodetracker.gui.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.kaspe.dcepisodetracker.R;
import com.example.kaspe.dcepisodetracker.gui.models.TimeModel;

public class TimeActivity extends AppCompatActivity {

    private TimeModel timeModel;
    private TimePicker timePicker;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        timeModel = new TimeModel();

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        setBtnAdd();
    }

    public void setBtnAdd() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                String hour = String.valueOf(timePicker.getHour());
                String minute = String.valueOf(timePicker.getMinute());
                minute = (Integer.parseInt(minute) < 10) ? ("0" + minute) : minute;
                hour = (Integer.parseInt(hour) < 10) ? ("0" + hour) : hour;
                timeModel.setTime(hour + ":" + minute);
                finish();
            }
        });
    }
}
