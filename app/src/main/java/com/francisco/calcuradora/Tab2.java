package com.francisco.calcuradora;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Tab2 extends Fragment {

    private EditText et_valor1, et_valor2;
    private RadioButton rb_sum, rb_rest, rb_mul, rb_div;
    private TextView tv_result;
    Button btncalcular;
    View vista;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        vista=inflater.inflate(R.layout.activity_tab2, container, false);
        btncalcular=(Button) vista.findViewById(R.id.button);
        et_valor1 = (EditText) vista.findViewById(R.id.txt_numero1);
        et_valor2 = (EditText) vista.findViewById(R.id.txt_numero2);
        rb_sum = (RadioButton) vista.findViewById(R.id.sumar);
        rb_rest = (RadioButton) vista.findViewById(R.id.resta);
        rb_mul = (RadioButton) vista.findViewById(R.id.producto);
        rb_div = (RadioButton) vista.findViewById(R.id.division);
        tv_result = (TextView) vista.findViewById(R.id.txt_resultado);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String valor1_string = et_valor1.getText().toString();
                String valor2_string = et_valor2.getText().toString();

                int valor1_int = Integer.parseInt(valor1_string);
                int valor2_int = Integer.parseInt(valor2_string);

                if (rb_sum.isChecked() == true) {
                    int suma = valor1_int + valor2_int;
                    String resultado = String.valueOf(suma);
                    tv_result.setText(resultado);
                }else if (rb_rest.isChecked() == true) {
                    int resta = valor1_int - valor2_int;
                    String resultado = String.valueOf(resta);
                    tv_result.setText(resultado);
                }else if (rb_mul.isChecked() == true) {
                    int multiplicacion = valor1_int * valor2_int;
                    String resultado = String.valueOf(multiplicacion);
                    tv_result.setText(resultado);
                }else if(rb_div.isChecked() == true){

                    if(valor2_int != 0){
                        int division = valor1_int / valor2_int;
                        String resultado = String.valueOf(division);
                        tv_result.setText(resultado);
                    } else {
                        Toast.makeText(getContext(), "no se puede dividir entre cero", Toast.LENGTH_LONG).show();
                    }


                }


            }
        });



        return vista;



    }
}
