package com.tc.nutriyou.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.tc.nutriyou.R;
import com.tc.nutriyou.config.ConfigFirebase;
import com.tc.nutriyou.model.Cliente;

public class RegisterUser extends AppCompatActivity
{

    private EditText nome;
    private EditText email;
    private EditText senha;
    private Button btCadastrar;
    private Cliente cliente;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        nome = findViewById(R.id.text_name);
        email = findViewById(R.id.text_email);
        senha = findViewById(R.id.text_senha);
        btCadastrar = findViewById(R.id.bt_cadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cliente = new Cliente();
                cliente.setDadosCadastro(nome.getText().toString(), email.getText().toString(), senha.getText().toString());
                cadastrarCliente();
            }
        });
    }
        private void cadastrarCliente()
        {
            String[] data = cliente.getDadosCadastro();
System.out.println(data);
            firebaseAuth = ConfigFirebase.getFirebaseAuth();
            firebaseAuth.createUserWithEmailAndPassword(data[1], data[2])
                    .addOnCompleteListener(RegisterUser.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(RegisterUser.this, "Usuario cadastrado com sucesso", 5);
                            }
                        else{
                            Toast.makeText(RegisterUser.this, "Erro ao tentar cadastrar usuario", 5);
                        }
                    }
                });
        }
}
