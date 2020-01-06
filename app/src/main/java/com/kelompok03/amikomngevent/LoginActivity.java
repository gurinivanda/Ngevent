package com.kelompok03.amikomngevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton appCompatButtonLogin;
    AppCompatTextView textViewLinkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initListeners();
    }

    private void initListeners() {
        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);
        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);

        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
        Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
        switch (v.getId()) {
            case R.id.appCompatButtonLogin:
                startActivity(intentHome);
                break;
            case R.id.textViewLinkRegister:
                // Navigate to RegisterActivity
                startActivity(intentRegister);
                break;
        }
    }
}
