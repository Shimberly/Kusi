package com.webbi.developer.kusi;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Registro2 extends AppCompatActivity {
    Button btnRegistrar;
    EditText txtFechaInicio, txtCuidador;
    RadioGroup radioGroup;
    RadioButton genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtFechaInicio = (EditText) findViewById(R.id.txtFechaInicio);
        txtFechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.txtFechaInicio:
                        showDatePickerDialog();
                        break;
                }
            }
        });
        txtCuidador = (EditText) findViewById(R.id.txtCuidador);
        radioGroup = (RadioGroup) findViewById(R.id.radio);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtFechaInicio.getText().toString().trim().equalsIgnoreCase("")){
                    txtFechaInicio.setError("Campo vacío");
                }else{
                    if (txtCuidador.getText().toString().trim().equalsIgnoreCase("")){
                        txtCuidador.setError("Campo vacío");
                    }else{
                        int selectedId = radioGroup.getCheckedRadioButtonId();

                        genero = (RadioButton) findViewById(selectedId);
                        if (genero!=null){
                            if(isConnectedToInternet())
                            {
                                Intent itemintent = new Intent(Registro2.this, Tutorial1.class);
                                Registro2.this.startActivity(itemintent);
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
                    }
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

    private void showDatePickerDialog() {

        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                month=month+1;
                String formattedMonth= String.valueOf(month);
                String formattedDayOfMonth= String.valueOf(day);
                if(month < 10){

                    formattedMonth = "0" + month;
                }
                if(day < 10){

                    formattedDayOfMonth = "0" + day;
                }
                final String selectedDate = formattedDayOfMonth + "/" + formattedMonth + "/" + year;
                EditText etPlannedDate = (EditText) findViewById(R.id.txtFechaInicio);
                etPlannedDate.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}
