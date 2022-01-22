package com.example.omegareport.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.omegareport.R;

public class PoloReport extends AppCompatActivity {

    private TextView mTeamName;
    private TextView mTime;
    private String teamName = "Omega Squad";
    private String time = "00:00";
    private ImageView mBombay;
    private ImageView mParis;
    private ImageView mSaoPaulo;
    private ImageView mPekin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polo_report);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mTeamName = findViewById(R.id.report_textView_team_name);
        mTime = findViewById(R.id.report_textView_timer);

        mBombay = findViewById(R.id.poloReport_imageView_bombay);
        mParis = findViewById(R.id.poloReport_imageView_paris);
        mSaoPaulo = findViewById(R.id.poloReport_imageView_saoPaulo);
        mPekin = findViewById(R.id.poloReport_imageView_pekin);

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

        if(!(getIntent().getExtras().getBoolean("bombay"))){mBombay.setImageResource(R.drawable.nuc_false);}
        if(!(getIntent().getExtras().getBoolean("paris"))){mParis.setImageResource(R.drawable.nuc_false);}
        if(!(getIntent().getExtras().getBoolean("saoPaulo"))){mSaoPaulo.setImageResource(R.drawable.nuc_false);}
        if(!(getIntent().getExtras().getBoolean("pekin"))){mPekin.setImageResource(R.drawable.nuc_false);}

    }
}