package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spSelectionForCounting;
    private EditText userEnterTextHere;
    private TextView CharCount;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.userEnterTextHere = findViewById(R.id.userEnterTextHere);
        this.CharCount = findViewById(R.id.CharCount);
        this.spSelectionForCounting = (Spinner) findViewById(R.id.spSelectionForCounting);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSelectionForCounting.setAdapter(adapter);

        res = getResources();
    }
        public void CharCount(View view) {
            String userProvidedText = userEnterTextHere.getText().toString();
            if(userProvidedText.equals("")) {
                Context context = getApplicationContext();
                String text = "Write Something Dude!";
                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                String spinnerOpt = spSelectionForCounting.getSelectedItem().toString();
                if(spinnerOpt.equals("Chars")) {
                    CharCount.setText(res.getString(R.string.chars) + WordCounter.Chars(userProvidedText));
                } else if(spinnerOpt.equals("Words")) {
                    //calc
                    CharCount.setText(res.getString(R.string.words) + WordCounter.Words(userProvidedText));
                }
                //
            }

        }
    }