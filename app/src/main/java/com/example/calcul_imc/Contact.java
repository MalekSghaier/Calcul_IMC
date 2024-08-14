package com.example.calcul_imc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Référencement des boutons
        ImageButton appelButton = findViewById(R.id.Appel);
        ImageButton messageButton = findViewById(R.id.message);
        ImageButton geoButton = findViewById(R.id.Géo);


        // Ajout des écouteurs d'événements sur les boutons
        appelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lancer un appel
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:56503371"));
                startActivity(intent);
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lancer un SMS
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:56503371"));
                startActivity(intent);
            }
        });

        geoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rediriger vers le site web
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.med.tn/medecin/nutritionniste/sousse/mme-raoudha-amri-187157.html"));
                startActivity(intent);
            }
        });
    }
}
