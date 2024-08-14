package com.example.calcul_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    float newHeight;
    float newWeight;
    float newIMC;
    EditText heightInput;
    EditText weightInput;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = findViewById(R.id.calcul);
        heightInput = findViewById(R.id.height);
        weightInput = findViewById(R.id.weight);
        resultText = findViewById(R.id.result);
        Button contact=findViewById(R.id.Contact);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (heightInput.getText().length() > 0 && weightInput.getText().length() > 0) {
                    newHeight = Float.parseFloat(heightInput.getText().toString());
                    newWeight = Float.parseFloat(weightInput.getText().toString());
                    newIMC = CalculateIMC(newWeight, newHeight);

                    DecimalFormat df = new DecimalFormat("#.##"); // Utilisation de DecimalFormat pour formater à deux chiffres après la virgule
                    String formattedIMC = df.format(newIMC);

                    if (newIMC < 18.5) {
                        resultText.setText("Votre IMC est : " + formattedIMC + " Vous êtes maigre");
                    } else if (newIMC < 25) {
                        resultText.setText("Votre IMC est : " + formattedIMC + " Vous êtes Équilibré");
                    } else if (newIMC < 30) {
                        resultText.setText("Votre IMC est : " + formattedIMC + " Vous êtes Gros(se)");
                    } else {
                        resultText.setText("Votre IMC est : " + formattedIMC + " Vous êtes Obèse");
                    }
                }
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Contact.class);
                startActivity(intent);
            }
        });
    }

    float CalculateIMC(float weight, float height) {
        height = (height / 100);
        return weight / (height * height);
    }
}