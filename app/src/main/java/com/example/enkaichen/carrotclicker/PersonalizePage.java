package com.example.enkaichen.carrotclicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Enkaichen on 11/12/14.
 */
public class PersonalizePage extends Activity {
    Button Back;
    EditText name;
    EditText age;
    EditText animal;
    EditText holiday;
    EditText monthUser;
    EditText yearUser;
    Button submit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.personalizepage);
        name = (EditText) this.findViewById(R.id.editText);
        //MainActivity.UserName = name.getText().toString();

        age = (EditText) this.findViewById(R.id.editText2);

        //MainActivity.age = age.getText().toString();

        monthUser = (EditText) this.findViewById(R.id.MonthEditText);


        yearUser = (EditText) this.findViewById(R.id.YearEditText);


        animal = (EditText) this.findViewById(R.id.editText4);
        //MainActivity.animal = animal.getText().toString();

        holiday = (EditText) this.findViewById(R.id.editText3);
       //MainActivity.holiday = holiday.getText().toString();

        Back = (Button) this.findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Back.getText().equals("Back")) {
                    if(name.getText().toString().trim().length() == 0){
                        MainActivity.UserName = "";
                    }
                    else {
                        MainActivity.UserName = name.getText().toString();
                    }
                    if(age.getText().toString().trim().length() == 0|| MainActivity.day == Integer.parseInt(age.getText().toString())){
                        MainActivity.day = 0;
                    }
                    else {
                        MainActivity.day = Integer.parseInt(age.getText().toString());
                    }
                    if(monthUser.getText().toString().trim().length() == 0|| MainActivity.month == Integer.parseInt(monthUser.getText().toString())){
                        MainActivity.month = 0;
                    }
                    else {
                        MainActivity.month = Integer.parseInt(monthUser.getText().toString());
                    }
                    if(yearUser.getText().toString().trim().length() == 0|| MainActivity.year == Integer.parseInt(yearUser.getText().toString())){
                        MainActivity.year = 0;
                    }
                    else {
                        MainActivity.year = Integer.parseInt(yearUser.getText().toString());
                    }
                    if(animal.getText().toString().trim().length() == 0){
                        MainActivity.animal = "";
                    }
                    else {
                        MainActivity.animal = animal.getText().toString();
                    }
                    if(holiday.getText().toString().trim().length() == 0){
                        MainActivity.holiday = "";
                    }
                    else {
                        MainActivity.holiday = holiday.getText().toString();
                    }
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        submit = (Button) this.findViewById(R.id.SubmitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (submit.getText().equals("Submit")) {
                    if(name.getText().toString().trim().length() == 0){
                        MainActivity.UserName = "";
                    }
                    else {
                        MainActivity.UserName = name.getText().toString();
                    }
                    if(age.getText().toString().trim().length() == 0|| MainActivity.day == Integer.parseInt(age.getText().toString())){
                        MainActivity.day = 0;
                    }
                    else {
                        MainActivity.day = Integer.parseInt(age.getText().toString());
                    }
                    if(monthUser.getText().toString().trim().length() == 0|| MainActivity.month == Integer.parseInt(monthUser.getText().toString())){
                        MainActivity.month = 0;
                    }
                    else {
                        MainActivity.month = Integer.parseInt(monthUser.getText().toString());
                    }
                    if(yearUser.getText().toString().trim().length() == 0|| MainActivity.year == Integer.parseInt(yearUser.getText().toString())){
                        MainActivity.year = 0;
                    }
                    else {
                        MainActivity.year = Integer.parseInt(yearUser.getText().toString());
                    }
                    if(animal.getText().toString().trim().length() == 0){
                        MainActivity.animal = "";
                    }
                    else {
                        MainActivity.animal = animal.getText().toString();
                    }
                    if(holiday.getText().toString().trim().length() == 0){
                        MainActivity.holiday = "";
                    }
                    else {
                        MainActivity.holiday = holiday.getText().toString();
                    }
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
