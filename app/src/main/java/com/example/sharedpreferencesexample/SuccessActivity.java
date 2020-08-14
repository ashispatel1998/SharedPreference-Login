package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    Button btnLogout;
    TextView user_detail;

    private SharedPreferenceConfig preferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        preferenceConfig=new SharedPreferenceConfig(getApplicationContext());


        user_detail=findViewById(R.id.user_detail);

        user_detail.setText(getResources().getString(R.string.user_name));

        btnLogout=findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void logout() {
        preferenceConfig.writeLoginStatus(false);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}