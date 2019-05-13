package com.example.layouttable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.app.AlertDialog;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editName =  (EditText)findViewById(R.id.editName);
        final EditText editEmail =  (EditText)findViewById(R.id.editEmail);

        final CheckBox Reading =  (CheckBox) findViewById(R.id.Reading);
        final CheckBox Traveling =  (CheckBox) findViewById(R.id.Traveling);
        final CheckBox Coding =  (CheckBox) findViewById(R.id.Coding);

        final RadioButton Male =  (RadioButton) findViewById(R.id.Male);
        final RadioButton Female =  (RadioButton) findViewById(R.id.Female);
        Male.setChecked(true);

        final Spinner spinLang =  (Spinner) findViewById(R.id.spinLang);
        final Switch switchExpert =  (Switch) findViewById(R.id.switchExpert);

        Button button = (Button) findViewById(R.id.OK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg  =  "My Full Name: " + editName.getText().toString() + System.getProperty("line.separator") +
                        "Email: " + editEmail.getText().toString() + System.getProperty("line.separator") + "Sex: " ;

                if(Male.isChecked()) {
                    msg +=  Male.getText().toString()  + System.getProperty("line.separator") + "Hobbies: " ;
                }
                if(Female.isChecked()) {
                    msg +=  Female.getText().toString()+ System.getProperty("line.separator") + "Hobbies: " ;
                }

                if(Reading.isChecked()) {
                    msg +=  Reading.getText().toString()  + ",";
                }
                if(Traveling.isChecked()) {
                    msg +=  Traveling.getText().toString() +  ",";
                }
                if(Coding.isChecked()) {
                    msg  +=  Coding.getText().toString() +  ",";
                }

                msg += System.getProperty("line.separator") + "My language: " + spinLang.getSelectedItem().toString() + System.getProperty("line.separator");

                if(switchExpert.isChecked()) msg += "Frame: Yes";
                else msg += "Frame: No";

                display(v,msg);
            }
        });

        Button close = (Button) findViewById(R.id.Cancel);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    private  void display(View v, String msg) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("My First App");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
