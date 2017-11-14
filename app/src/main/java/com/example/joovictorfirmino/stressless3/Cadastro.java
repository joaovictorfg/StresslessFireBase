package com.example.joovictorfirmino.stressless3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    private EditText editNome, editEmail1, editSenha1;
    private Button btnRegistrar, btnVoltar;
    private FirebaseAuth fireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        iniciaComponentes();
        eventoClick();
    }

    private void eventoClick() {
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String nome = editNome.getText().toString().trim();
                String email = editEmail1.getText().toString().trim();
                String senha = editSenha1.getText().toString().trim();

                criaUser(email,senha);

            }
        });
    }

    private void criaUser(String email, String senha) {
        fireBaseAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    alert("Usuário Cadastrado com sucesso!");
                    Intent i = new Intent(Cadastro.this, Perfil.class);
                    startActivity(i);
                    finish();
                } else {
                    alert("Erro de cadastro!");
                }
            }
        });
    }

    private void alert(String msg){
        Toast.makeText(Cadastro.this, msg, Toast.LENGTH_SHORT).show();
    }

    private void iniciaComponentes() {
        //editNome = (EditText) findViewById(R.id.editNome);
        editSenha1 = (EditText) findViewById(R.id.editSenha1);
        editEmail1 = (EditText) findViewById(R.id.editEmail1);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        fireBaseAuth = Conexao.getFirebaseAuth();
    }
}
