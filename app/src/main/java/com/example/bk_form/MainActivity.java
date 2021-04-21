package com.example.bk_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEDT, last_nameEDT, emailEDT, passwordEDT, cpfEDT, cnpjEDT, addressEDT;
    private Button btn;
    private Dao dao;
    private Bean bean;
    private Intent intent;

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
                } else {
                    dao = new Dao(MainActivity.this);
                    bean = new Bean(name, last_name, email, password, Integer.parseInt(cpf), Integer.parseInt(cnpj), address);
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

    public void nextActivity() {
        intent = new Intent(this, ShowActivity.class);
        startActivityForResult(intent, 1);
    }
}