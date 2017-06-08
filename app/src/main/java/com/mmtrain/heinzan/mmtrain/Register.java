package com.mmtrain.heinzan.mmtrain;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by HAZin on 6/8/2017.
 */

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText reg_name;
    EditText reg_email;
    EditText reg_password;
    EditText dob;
    Spinner spinnerTownship;
    Button btnregister;


    int year;
    int month;
    int day;
    boolean show = false;
    Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        reg_name= (EditText) findViewById(R.id.register_user);
        reg_email= (EditText) findViewById(R.id.register_email);
        reg_password= (EditText) findViewById(R.id.register_password);
        dob= (EditText) findViewById(R.id.txt_dob);
        btnregister= (Button) findViewById(R.id.btnregister);


        btnregister.setOnClickListener(this);
        spinnerTownship= (Spinner) findViewById(R.id.spinner_address);

        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.township_array,
                        android.R.layout.simple_spinner_item);


        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerTownship.setAdapter(staticAdapter);

        updateDate();


    }
    

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnregister:
                userRegister();

                break;



            default:
                break;
        }

    }


    private void userRegister() {
        Toast.makeText(getApplicationContext(),"clicked Register",Toast.LENGTH_SHORT).show();
    }

    private void updateDate() {

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();

            }
        };
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Register.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

    }

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dob.setText(sdf.format(myCalendar.getTime()));
    }
}
