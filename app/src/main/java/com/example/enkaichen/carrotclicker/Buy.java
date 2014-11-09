package com.example.enkaichen.carrotclicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Enkaichen on 11/8/14.
 */
public class Buy extends Activity {
    Button Choice1;
    Button Choice2;
    Button Choice3;
    Button Choice4;
    Button Choice5;
    Button Choice6;
    Button Choice7;
    Button Choice8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.buy);
        Choice1 = (Button)this.findViewById(R.id.Choice1);
        Choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice1.getText().equals("1 carrot per min")){
                    if(MainActivity.count < 30){
                        MainActivity.success = "Not Enough for the upgrade";
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        MainActivity.success = "congrats of your purchase";
                        MainActivity.Earnings += 1;
                        MainActivity.count = MainActivity.count - 30;
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        Choice2 = (Button)this.findViewById(R.id.Choice2);
        Choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice2.getText().equals("5 carrots per min")){
                    if(MainActivity.count < 4000){
                        MainActivity.success = "Not Enough for the upgrade";
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        MainActivity.success = "congrats of your purchase";
                        MainActivity.Earnings += 5;
                        MainActivity.count = MainActivity.count - 4000;
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        Choice3 = (Button)this.findViewById(R.id.Choice3);
        Choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice3.getText().equals("10 carrots per min")){
                    if(MainActivity.count < 5000){
                        MainActivity.success = "Not Enough for the upgrade";
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        MainActivity.success = "congrats of your purchase";
                        MainActivity.Earnings += 10;
                        MainActivity.count = MainActivity.count - 5000;
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        Choice4 = (Button)this.findViewById(R.id.Choice4);
        Choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice4.getText().equals("20 carrots per min")){
                    if(MainActivity.count < 10000){
                        MainActivity.success = "Not Enough for the upgrade";
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        MainActivity.success = "congrats of your purchase";
                        MainActivity.Earnings += 20;
                        MainActivity.count = MainActivity.count - 10000;
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        Choice5 = (Button)this.findViewById(R.id.Choice5);
        Choice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice5.getText().equals("30 carrots per min")){
                    if(MainActivity.count < 20000){
                        MainActivity.success = "Not Enough for the upgrade";
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        MainActivity.success = "congrats of your purchase";
                        MainActivity.Earnings += 30;
                        MainActivity.count = MainActivity.count - 20000;
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        Choice6 = (Button)this.findViewById(R.id.Choice6);
        Choice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice6.getText().equals("40 carrots per min")){
                    if(MainActivity.count < 30000){
                        MainActivity.success = "Not Enough for the upgrade";
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        MainActivity.success = "congrats of your purchase";
                        MainActivity.Earnings += 40;
                        MainActivity.count = MainActivity.count - 30000;
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        Choice7 = (Button)this.findViewById(R.id.Choice7);
        Choice7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice7.getText().equals("50 carrots per min")){
                    if(MainActivity.count < 40000){
                        MainActivity.success = "Not Enough for the upgrade";
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        MainActivity.success = "congrats of your purchase";
                        MainActivity.Earnings += 50;
                        MainActivity.count = MainActivity.count - 40000;
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        Choice8 = (Button)this.findViewById(R.id.Choice8);
        Choice8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Choice8.getText().equals("100 carrots per min")){
                    if(MainActivity.count < 50000){
                        MainActivity.success = "Not Enough for the upgrade";
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        MainActivity.success = "congrats of your purchase";
                        MainActivity.Earnings += 50;
                        MainActivity.count = MainActivity.count - 50000;
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
