package com.example.omegareport.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.TextView;

import com.example.omegareport.R;

public class ReportScreen extends AppCompatActivity {

    private TextView mTeamName;
    private TextView mTime;
    private String teamName = "Omega Squad";
    private String time = "00:00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_screen);

        mTeamName = findViewById(R.id.report_textView_team_name);
        mTime = findViewById(R.id.report_textView_timer);

        final Intent myIntent = getIntent();
        if(null!=myIntent) {
            final Bundle extras2 = myIntent.getExtras();
            if (extras2 != null) {
                teamName = extras2.getString(SyncStateContract.Constants.ACCOUNT_NAME);
                time = extras2.getString(SyncStateContract.Constants.DATA);
            }
        }
        mTeamName.setText("Omega Squad");
        if(!(teamName.equals(""))){ mTeamName.setText(teamName);}
        mTime.setText(time);

    }
}