package com.webbi.developer.kusi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Emocion extends AppCompatActivity {
    Button btnFeliz, btnCalmado, btnFrustrado, btnTriste, btnEnojado;
    LinearLayout fondo;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emocion);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fondo = (LinearLayout) findViewById(R.id.fondoCambiar);
        imagen = (ImageView) findViewById(R.id.imagenCambiar);

        btnFeliz = (Button) findViewById(R.id.btnFeliz);
        btnFeliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondo.setBackgroundColor(Color.RED);
                imagen.setImageResource(R.drawable.felipedoctor);
            }
        });

        btnCalmado = (Button) findViewById(R.id.btnCalmado);
        btnCalmado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondo.setBackgroundColor(Color.parseColor("#ffffff"));
                imagen.setImageResource(R.drawable.felipemanoalzada);
            }
        });

        btnFrustrado = (Button) findViewById(R.id.btnFrustrado);
        btnFrustrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondo.setBackgroundColor(Color.YELLOW);
                imagen.setImageResource(R.drawable.felipeojoscerrados);
            }
        });

        btnTriste = (Button) findViewById(R.id.btnTriste);
        btnTriste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondo.setBackgroundColor(Color.BLUE);
                imagen.setImageResource(R.drawable.felipetelefono);
            }
        });

        btnEnojado = (Button) findViewById(R.id.btnEnojado);
        btnEnojado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fondo.setBackgroundColor(Color.GREEN);
                imagen.setImageResource(R.drawable.felipemanoalzada);
            }
        });


    }


    @Override
    public boolean onSupportNavigateUp() {
        Intent itemintent = new Intent(Emocion.this, Inicio.class);
        Emocion.this.startActivity(itemintent);
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
}
