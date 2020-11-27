package com.francisco.calcuradora;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MiCalcuradora extends AppCompatActivity {
    //declaracion de variables
    private EditText et1, et2;
    private RadioButton sumar, restar, producto, dividir;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        //Casteo de Variables con metodo para capturar vistas(findViewById)
        et1 = (EditText)findViewById(R.id.txt_numero1);
        et2 = (EditText)findViewById(R.id.txt_numero2);
        tv1 = (TextView)findViewById(R.id.txt_resultado);
        sumar = (RadioButton)findViewById(R.id.sumar);
        restar = (RadioButton)findViewById(R.id.resta);
        producto = (RadioButton)findViewById(R.id.producto);
        dividir = (RadioButton)findViewById(R.id.division);
    }
    //Metodo para Boton Calcular
    public void Calcular(View view){
        //Variables obtenidas de las cajas de texto
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        //Conversion de Variables obtenidas
        Double valor1_double = Double.parseDouble(valor1_String);
        Double valor2_double = Double.parseDouble(valor2_String);

        //estructura condicional segun operacion
        if (sumar.isChecked() == true){ // Operación Suma
            Double suma = valor1_double + valor2_double;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        } else if (restar.isChecked() == true){ //Operación Resta
            Double resta = valor1_double - valor2_double;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        } else if (producto.isChecked() == true){ //Operacion Multiplicación
            Double multiplicar = valor1_double * valor2_double;
            String resultado = String.valueOf(multiplicar);
            tv1.setText(resultado);
        } else if (dividir.isChecked() == true){ //Operacion División
            //condicion no divisible por 0
            if (valor2_double != 0) {
                Double division = valor1_double / valor2_double;
                String resultado = String.valueOf(division);
                tv1.setText(resultado);
            }else{
                //Toast para mostrar mensaje en la app
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
            }

        }
    }
}