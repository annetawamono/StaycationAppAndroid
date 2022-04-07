package com.example.staycationappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {

    private Button btnDates;
    private TextView idSelectedDates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDates = findViewById(R.id.btnDates);
        idSelectedDates = findViewById(R.id.idSelectedDates);

        // Material date picker
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.dateRangePicker();

        builder.setTitleText("Select your Check in and Check out date");

        MaterialDatePicker materialDatePicker = builder.build();

        btnDates.setOnClickListener(view -> {
            materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                idSelectedDates.setText(materialDatePicker.getHeaderText());
            }
        });

    }
}