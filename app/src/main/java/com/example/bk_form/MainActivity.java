package com.example.bk_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText nameEDT, last_nameEDT, emailEDT, passwordEDT, cpfEDT, cnpjEDT, addressEDT;
    private Button btn;
    private Dao dao;
    private Bean bean;
    private Intent intent;
    private Pattern pattern;
    private Matcher matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEDT.getText().toString();
                String last_name = last_nameEDT.getText().toString();
                String email = emailEDT.getText().toString();
                String password = passwordEDT.getText().toString();
                String cpf = cpfEDT.getText().toString();
                String cnpj = cnpjEDT.getText().toString();
                String address = addressEDT.getText().toString();

                if (name.isEmpty() || last_name.isEmpty() || email.isEmpty() || password.isEmpty() || cpf.isEmpty() || cnpj.isEmpty() || address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bad", Toast.LENGTH_SHORT).show();
                } else if (!validateEmail(email)) {
                    emailEDT.setError(getString(R.string.invalid));
                    emailEDT.requestFocus();
                } else if (!validatePassword(password)) {
                    passwordEDT.setError(getString(R.string.invalidTwo));
                    passwordEDT.requestFocus();
                } else {
                    Toast.makeText(MainActivity.this, "Input Validation Success", Toast.LENGTH_SHORT).show();
                    dao = new Dao(MainActivity.this);
                    bean = new Bean(name, last_name, email, password, cpf, cnpj, address);
                    dao.insertData(bean);
                    Toast.makeText(MainActivity.this, "Sucessfully", Toast.LENGTH_SHORT).show();
                    finish();
                    nextActivity();
                }
            }
        });
    }

    public void init() {
        nameEDT = findViewById(R.id.nameEDT);
        last_nameEDT = findViewById(R.id.last_nameEDT);
        emailEDT = findViewById(R.id.emailEDT);
        passwordEDT = findViewById(R.id.passwordEDT);
        cpfEDT = findViewById(R.id.CPFEDT);
        cnpjEDT = findViewById(R.id.CNPJEDT);
        addressEDT = findViewById(R.id.addressEDT);
        btn = findViewById(R.id.goBtn);
    }

    public boolean validateEmail(String email) {
        String emailPattern = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        pattern = Pattern.compile(emailPattern);
        matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        if (password != null && password.length() > 9) {
            return true;
        } else {
            return false;
        }
    }

    public void nextActivity() {
        intent = new Intent(MainActivity.this, ShowActivity.class);
        startActivityForResult(intent, 1);
    }
}