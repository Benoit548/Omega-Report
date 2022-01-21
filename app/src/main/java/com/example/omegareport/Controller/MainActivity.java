package com.example.omegareport.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omegareport.Model.TeamName;
import com.example.omegareport.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    private Button mSubmitButton;
    private TextView mCongratsText;
    private EditText mName;
    private EditText mTime;
    private TeamName mTeamName;
    private CheckBox mCheckEnglish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCongratsText =findViewById(R.id.main_TextView_congrats);
        mSubmitButton =findViewById(R.id.main_button_submit);
        mName = findViewById(R.id.main_editText_TeamName);
        mTime = findViewById(R.id.main_EditText_time);
        mCheckEnglish = findViewById(R.id.main_checkBox_english);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(mTime.getText())){
                    Toast.makeText(MainActivity.this,R.string.error_no_time,Toast.LENGTH_LONG).show();
                    return;
                }
                if(mCheckEnglish.isChecked()){
                    String languageToLoad  = "en"; // your language
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                }

                else{
                    String languageToLoad  = "fr"; // your language
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                }

                Intent myIntent = new Intent(MainActivity.this, ReportScreen.class);
                final Bundle extras = new Bundle();
                extras.putString(SyncStateContract.Constants.ACCOUNT_NAME,mName.getText().toString());
                extras.putString(SyncStateContract.Constants.DATA,mTime.getText().toString());
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });

    }



}