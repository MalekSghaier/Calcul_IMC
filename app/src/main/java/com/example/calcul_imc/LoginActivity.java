package com.example.calcul_imc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info ;
    private Button Login ;

    private int counter = 3 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Info =(TextView) findViewById(R.id.tvInfo);
        Login=(Button) findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Validate(Name.getText().toString(),Password.getText().toString());
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("WELCOME");
        builder.setMessage("Dear User, Welcome to our IMC App!");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Laisser vide ou insérer une action à effectuer lorsque l'utilisateur clique sur OK

            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void Validate (String userName , String Password){
        if ((userName.equals("Malek"))&&(Password.equals("1234"))) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else{
          counter--;
          Info.setText("NO OF THE ATTEMPTS REMAINING : "+String.valueOf(counter));
          if (counter==0){
              Login.setEnabled(false);
          }

        }
    }

}