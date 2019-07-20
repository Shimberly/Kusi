package com.webbi.developer.kusi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    DatabaseReference ndatabaseReference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRootChild = ndatabaseReference.child("texto");
    Button Login;
    EditText txtUser, txtClave;
    TextView btnRegistrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        txtUser = (EditText) findViewById(R.id.txtUser);
        txtClave = (EditText) findViewById(R.id.txtClave);

        btnRegistrate = (TextView) findViewById(R.id.btnRegistrate);
        btnRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemintent = new Intent(Login.this, Registro.class);
                Login.this.startActivity(itemintent);
            }
        });

        Login = (Button) findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //txtClave.setText("sadasd");
                if (!txtUser.getText().toString().trim().equalsIgnoreCase("")){
                    if(txtClave.getText().toString().trim().equalsIgnoreCase("")){
                        txtClave.setError("Campo vacío");
                    }else{
                        if(isConnectedToInternet())
                        {
                            Intent itemintent = new Intent(Login.this, Inicio.class);
                            Login.this.startActivity(itemintent);
                            // Run AsyncTask
                            //servicio = (ServicioWeb) new ServicioWeb().execute();
                        }
                        else
                        {
                            Log.d("Error", "Error Conexion");
                            Bundle args = new Bundle();
                            args.putString("titulo", "Advertencia");
                            args.putString("texto", "No hay conexión de Internet");
                            ProblemaConexion f=new ProblemaConexion();
                            f.setArguments(args);
                            f.show(getSupportFragmentManager(), "ProblemaConexión");
                        }

                    }
                }else{
                    txtUser.setError("Campo vacío");

                }

            }
        });


    }

    public boolean isConnectedToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
    }
    @Override
    public void onBackPressed (){
        return;
    }

}
