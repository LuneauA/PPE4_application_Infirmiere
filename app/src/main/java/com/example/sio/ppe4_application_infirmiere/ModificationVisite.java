package com.example.sio.ppe4_application_infirmiere;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SIO on 23/02/2018.
 */
public class ModificationVisite extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        setContentView(R.layout.activity_modification_visite);
        Bundle bundle = getIntent().getExtras();
        String  param1 = bundle.getString("param1");
        Toast.makeText(getApplicationContext(), param1, Toast.LENGTH_LONG)
        .show();

final Visite visite = (new Modele()).trouveVisite(param1);
        TextView textView = (TextView) findViewById(R.id.t_id);
        textView.setText(visite.getId());
        textView = (TextView) findViewById(R.id.id_patient);
        textView.setText(visite.getPatient());
        textView = (TextView) findViewById(R.id.id_infirmiere);
        textView.setText(visite.getInfirmiere());

        textView = (TextView) findViewById(R.id.datePrevue);
        textView.setText( new SimpleDateFormat("dd/MM/yyyy").format(visite
        .getDate_prevue()));

        EditText editText = (EditText) findViewById(R.id.ecommentaire);
        editText.setText(visite.getCompte_rendu_infirmiere());

        Button buttonCancel = (Button) findViewById(R.id.bcanc);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
                finish();
                }
                });
       // Button geoloc = (Button) findViewById(R.id.geoloc);
      //  geoloc.setOnClickListener(new View.OnClickListener() {
/*public void onClick(View v) {
        Intent myIntent = new Intent(getApplicationContext(), Geolocalisation.class);
        startActivity(myIntent);
        }
        });*/
        Button buttonOk = (Button) findViewById(R.id.bok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
        visite.setCompte_rendu_infirmiere(((EditText) findViewById(R.id.ecommentaire))
        .getText().toString());
        (new Modele()).saveVisite(visite);
        finish();
        }
        });


        }
        }
