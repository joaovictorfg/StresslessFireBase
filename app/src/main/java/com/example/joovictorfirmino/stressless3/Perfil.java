package com.example.joovictorfirmino.stressless3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Perfil extends AppCompatActivity {

    private TextView textEmail, textID;
    private Button btnSair;
    private FirebaseAuth fireBaseAuth;
    private FirebaseUser fireBaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        inicaComponentes();
        eventoClick();
    }

    private void eventoClick() {
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Conexao.logOut();
                finish();
            }
        });
    }

    private void inicaComponentes() {
        textEmail = (TextView) findViewById(R.id.textEmail);
        textID = (TextView) findViewById(R.id.textID);
        btnSair = (Button) findViewById(R.id.btnSair);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fireBaseAuth = Conexao.getFirebaseAuth();
        fireBaseUser = Conexao.getFirebaseUser();
        verificaUser();
    }

    private void verificaUser() {
        if (fireBaseUser == null){
            finish();
        }else {
            textEmail.setText("Email:" + fireBaseUser.getEmail());
            textID.setText("ID:" + fireBaseUser.getUid());
        }
    }
}