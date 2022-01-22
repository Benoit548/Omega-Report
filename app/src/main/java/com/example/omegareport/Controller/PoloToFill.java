package com.example.omegareport.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omegareport.Model.TeamName;
import com.example.omegareport.R;

import java.util.Locale;

public class PoloToFill extends AppCompatActivity {

    private Button mSubmitButton;
    private TextView mCongratsText;
    private EditText mName;
    private EditText mTime;
    private TeamName mTeamName;
    private CheckBox mCheckEnglish;
    private CheckBox mBombay;
    private CheckBox mParis;
    private CheckBox mSaoPaulo;
    private CheckBox mPekin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polo_to_fill);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mCongratsText =findViewById(R.id.polo_TextView_congrats);
        mSubmitButton =findViewById(R.id.polo_button_submit);
        mName = findViewById(R.id.polo_editText_TeamName);
        mTime = findViewById(R.id.polo_EditText_time);
        mCheckEnglish = findViewById(R.id.polo_checkBox_english);

        mBombay = findViewById(R.id.poloFill_checkBox_Bombay);
        mParis = findViewById(R.id.poloFill_checkBox_Paris);
        mSaoPaulo = findViewById(R.id.poloFill_checkBox_SaoPaulo);
        mPekin = findViewById(R.id.poloFill_checkBox_Pekin);

        mBombay.setChecked(true);
        mParis.setChecked(true);
        mSaoPaulo.setChecked(true);
        mPekin.setChecked(true);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(mTime.getText())){
                    Toast.makeText(PoloToFill.this,R.string.error_no_time,Toast.LENGTH_LONG).show();
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

                Intent myIntent = new Intent(PoloToFill.this, PoloReport.class);
                final Bundle extras = new Bundle();
                extras.putString(SyncStateContract.Constants.ACCOUNT_NAME,mName.getText().toString());
                extras.putString(SyncStateContract.Constants.DATA,mTime.getText().toString());
                myIntent.putExtras(extras);
                myIntent.putExtra("bombay", mBombay.isChecked());
                myIntent.putExtra("paris", mParis.isChecked());
                myIntent.putExtra("saoPaulo", mSaoPaulo.isChecked());
                myIntent.putExtra("pekin", mPekin.isChecked());
                startActivity(myIntent);
            }
        });
    }
}