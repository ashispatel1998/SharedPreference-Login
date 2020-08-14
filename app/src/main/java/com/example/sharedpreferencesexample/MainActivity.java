package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button btnLogin;
    private SharedPreferenceConfig preferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginuser();
            }
        });

        try{
            if(preferenceConfig.readLoginStatus()){
                startActivity(new Intent(this,SuccessActivity.class));
                finish();
            }
        }catch (Exception e){
           //Toast.makeText(getApplicationContext(),e.getMessage()+" 1",Toast.LENGTH_LONG).show();
        }


    }



    public void loginuser() {

        try{
            String user_email= email.getText().toString().trim();
            String user_password= password.getText().toString().trim();

            if(user_email.equals(getResources().getString(R.string.user_name)) && user_password.equals(getResources()
                    .getString(R.string.user_password))){

                startActivity(new Intent(this,SuccessActivity.class));
                preferenceConfig.writeLoginStatus(true);
                finish();

            }else{
                Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                email.setText("");
                password.setText("");
            }
        }catch (Exception e){
            //Toast.makeText(getApplicationContext(),e+" 2",Toast.LENGTH_LONG).show();
        }



    }
}