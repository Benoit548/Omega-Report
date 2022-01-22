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
import android.widget.Toast;

import com.example.omegareport.R;

import java.util.Locale;

public class ChoiceActivity extends AppCompatActivity{

    private Button mAliButton;
    private Button mPoloButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAliButton = findViewById(R.id.choice_button_ali);
        mPoloButton = findViewById(R.id.choice_button_polo);

        mAliButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(ChoiceActivity.this, MainActivity.class);
                startActivity(myIntent);

            }
        });

        mPoloButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(ChoiceActivity.this, PoloToFill.class);
                startActivity(myIntent);

            }
        });

    }
}