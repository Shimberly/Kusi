package com.webbi.developer.kusi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Emergencia extends AppCompatActivity {
    Button btnEmergencia;
    Button imgWa, btnLlamada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imgWa= (Button) findViewById(R.id.imgWa);
        imgWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accionWA(view);
            }
        });

        btnLlamada= (Button) findViewById(R.id.imgTf);
        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accionTF(view);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent itemintent = new Intent(Emergencia.this, Inicio.class);
        Emergencia.this.startActivity(itemintent);
        return true;
    }

    @Override
    public void onBackPressed (){
        return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuprincipal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.perfil:
                Intent intent = new Intent(this, Perfil.class);
                startActivity(intent);
                return true;

            case R.id.seguimiento:
                Intent intent2 = new Intent(this, Seguimiento.class);
                startActivity(intent2);
                return true;

            case R.id.salir:
                /*SharedPreferences settings = this.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.clear();
                editor.commit();
                finish();*/
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void accionWA(View v){
        try {
            String text = "¡Hola, le escribo desde la app KUSI porque tengo una emergencia!";// Replace with your message.
                String toNumber = "5930992937424"; // Replace with mobile phone number without +Sign or leading zeros.

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
                startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void accionTF(View v){
        try {
            String phoneNo = "0992937424";
            if(!TextUtils.isEmpty(phoneNo)) {
                String dial = "tel:" + phoneNo;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }else {
                Toast.makeText(Emergencia.this, "Ingresa un número válido", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
