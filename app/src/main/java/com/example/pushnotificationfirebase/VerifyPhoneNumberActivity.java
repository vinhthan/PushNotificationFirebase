package com.example.pushnotificationfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VerifyPhoneNumberActivity extends AppCompatActivity {
    private EditText edtPhone;
    private Button btnVerifyPhone;
    private TextView tvSendOtpAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_number);

        setTitleToolbar();

        edtPhone = findViewById(R.id.edtOtp);
        btnVerifyPhone = findViewById(R.id.btn_send_otp);
        tvSendOtpAgain = findViewById(R.id.tv_send_otp_again);
        btnVerifyPhone.setOnClickListener(v -> {
            String strPhone = edtPhone.getText().toString().trim();
            verifyPhoneNumber(strPhone);
        });

        tvSendOtpAgain.setOnClickListener(v -> {
            sendOtpAgain();
        });
    }

    private void setTitleToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Verify Phone Activity");
        }
    }

    private void verifyPhoneNumber(String strPhone) {

    }

    private void sendOtpAgain() {

    }

}