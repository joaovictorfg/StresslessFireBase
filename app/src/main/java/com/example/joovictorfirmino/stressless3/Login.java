package com.example.joovictorfirmino.stressless3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText editEmail, editSenha;
    private Button btnLogar;
    private TextView textCadastro, textNovo;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciaComponentes();
        eventoClik();
    }

    private void eventoClik() {
        textCadastro.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(i);
            }
        });
    }

    private void iniciaComponentes() {
        editSenha = (EditText) findViewById(R.id.editSenha);
        editEmail = (EditText) findViewById(R.id.editEmail);
        btnLogar = (Button) findViewById(R.id.btnLogar);
        textCadastro = (TextView)findViewById(R.id.textCadastro);
        textNovo = (TextView)findViewById(R.id.textNovo);


    }
}
