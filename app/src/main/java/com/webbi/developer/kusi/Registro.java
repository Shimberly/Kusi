package com.webbi.developer.kusi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends AppCompatActivity {
    Button btnContinuar;
    EditText txtNombre, txtUsuario, txtPass, txtFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        EditText etPlannedDate = (EditText) findViewById(R.id.txtNacimiento);
        etPlannedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.txtNacimiento:
                        showDatePickerDialog();
                        break;
                }
            }
        });

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtPass = (EditText) findViewById(R.id.txtPass);
        txtFecha = (EditText) findViewById(R.id.txtNacimiento);

        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtNombre.getText().toString().trim().equalsIgnoreCase("")){
                    txtNombre.setError("Campo vacío");
                }else{
                    if (txtUsuario.getText().toString().trim().equalsIgnoreCase("")){
                        txtUsuario.setError("Campo vacío");
                    }else{
                        if (txtPass.getText().toString().trim().equalsIgnoreCase("")){
                            txtPass.setError("Campo vacío");
                        }else{
                            if (txtFecha.getText().toString().trim().equalsIgnoreCase("")){
                                txtFecha.setError("Campo vacío");
                            }else{
                                Intent itemintent = new Intent(Registro.this, Registro2.class);
                                Registro.this.startActivity(itemintent);
                            }
                        }
                    }

                }

            }
        });



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
                EditText etPlannedDate = (EditText) findViewById(R.id.txtNacimiento);
                etPlannedDate.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
