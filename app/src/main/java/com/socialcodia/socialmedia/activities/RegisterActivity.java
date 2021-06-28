package com.socialcodia.socialmedia.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.socialcodia.socialmedia.R;
import com.socialcodia.socialmedia.api.ApiClient;
import com.socialcodia.socialmedia.pojos.ResponseDefault;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private TextView tvLogin;
    private EditText inputName,inputEmail,inputPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Init
        tvLogin = findViewById(R.id.tvLogin);
        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        btnRegister = findViewById(R.id.btnRegister);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToLogin();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });
    }

    private void validateData()
    {
        String name = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        if(name.isEmpty())
        {
            inputName.setError("Enter Name");
            inputName.requestFocus();
            return;
        }
        if (name.length()<3)
        {
            inputName.setError("Name too Short");
            inputName.requestFocus();
            return;
        }
        if (name.length()>30)
        {
            inputName.setError("Name too Long");
            inputName.requestFocus();
            return;
        }
        if (email.isEmpty())
        {
            inputEmail.setError("Enter Email");
            inputEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            inputEmail.setError("Enter Valid Email");
            inputEmail.requestFocus();
            return;
        }
        if (password.isEmpty())
        {
            inputPassword.setError("Enter Password");
            inputPassword.requestFocus();
            return;
        }
        if (password.length()<8)
        {
            inputPassword.setError("Password too Short");
            inputPassword.requestFocus();
            return;
        }
        if (password.length()>30)
        {
            inputPassword.setError("Password too Long");
            inputPassword.requestFocus();
        }
        else
        {
            doRegister(name,email,password);
        }
    }

    private void doRegister(String name, String email, String password)
    {
        btnRegister.setEnabled(false);
        Call<ResponseDefault> call = ApiClient.getInstance().getApi().register(name,email,password);
        call.enqueue(new Callback<ResponseDefault>() {
            @Override
            public void onResponse(Call<ResponseDefault> call, Response<ResponseDefault> response) {
                btnRegister.setEnabled(true);
                if(response.isSuccessful())
                {
                    ResponseDefault resp = response.body();
                    if(resp.isError())
                    {
                        Toast.makeText(RegisterActivity.this, String.valueOf(resp.getMessage()), Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, String.valueOf(resp.getMessage()), Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseDefault> call, Throwable t) {
                t.printStackTrace();
                btnRegister.setEnabled(true);
            }
        });
    }

    private void sendToLogin()
    {
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}