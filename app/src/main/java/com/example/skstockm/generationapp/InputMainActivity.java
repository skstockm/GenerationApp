package com.example.skstockm.generationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.button;

public class InputMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_main);
    }

    public void onSendMessage(View view){
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        Spinner gradYear = (Spinner) findViewById(R.id.gradYearSpinner);
        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
        String degreeLevel = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        EditText major = (EditText) findViewById(R.id.major);
        EditText school = (EditText) findViewById(R.id.school);
        EditText favAct = (EditText) findViewById(R.id.favoriteActivities);

        String messageText = firstName.getText().toString() + " " +
                lastName.getText().toString() + " graduated from " + school.getText().toString() + " in "
                + gradYear.getSelectedItem() + " with a " + degreeLevel + " in " + major.getText().toString()
                + ". " + "His/Her interests include " + favAct.getText().toString() + ".";
        Intent intent = new Intent(this, OutputActivity.class);
        intent.putExtra(OutputActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }

}
