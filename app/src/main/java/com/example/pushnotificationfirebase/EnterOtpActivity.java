package com.example.pushnotificationfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EnterOtpActivity extends AppCompatActivity {

    private EditText edtOtp;
    private Button btnSendOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);

        setTitleToolbar();

        edtOtp = findViewById(R.id.edtOtp);
        btnSendOtp = findViewById(R.id.btn_send_otp);
        btnSendOtp.setOnClickListener(v -> {
            String strOtp = edtOtp.getText().toString().trim();
            sendOtp(strOtp);
        });
    }

    private void sendOtp(String strOtp) {


    }

    private void setTitleToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Enter Opt Activity");
        }
    }
}