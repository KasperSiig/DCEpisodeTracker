package com.example.kaspe.dcepisodetracker.gui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.kaspe.dcepisodetracker.R;
import com.example.kaspe.dcepisodetracker.gui.models.DateModel;

public class DateActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Button btnAdd;
    private DateModel dateModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        dateModel = new DateModel();

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        setBtnAdd();
    }

    public void setBtnAdd() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = String.valueOf(datePicker.getDayOfMonth());
                String month = String.valueOf(datePicker.getMonth() + 1);
                String year = String.valueOf(datePicker.getYear());

                day = (Integer.parseInt(day) < 10) ? ("0" + day) : day;
                month = (Integer.parseInt(month) < 10) ? ("0" + month) : month;

                dateModel.setDate(day + "-" + month + "-" + year);
                finish();
            }
        });
    }


}
