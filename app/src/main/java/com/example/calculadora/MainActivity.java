package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText num1;
    private TextInputEditText num2;
    private TextView resultado;
    private Button suma, resta, division, multiplicacion, resto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultado = findViewById(R.id.result);
        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        division = findViewById(R.id.division);
        multiplicacion = findViewById(R.id.multiplicacion);
        resto = findViewById(R.id.resto);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto1 = num1.getText().toString();
                String texto2 = num2.getText().toString();

                if (!texto1.isEmpty() && !texto2.isEmpty()) {
                    int n1 = Integer.parseInt(texto1);
                    int n2 = Integer.parseInt(texto2);
                    int sumaResultado = n1 + n2;

                    resultado.setText(String.valueOf(sumaResultado));
                }
            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto1 = num1.getText().toString();
                String texto2 = num2.getText().toString();

                if (!texto1.isEmpty() && !texto2.isEmpty()) {
                    int n1 = Integer.parseInt(texto1);
                    int n2 = Integer.parseInt(texto2);
                    int sumaResultado = n1 - n2;

                    resultado.setText(String.valueOf(sumaResultado));
                }
            }
        });
        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto1 = num1.getText().toString();
                String texto2 = num2.getText().toString();

                if (!texto1.isEmpty() && !texto2.isEmpty()) {
                    int n1 = Integer.parseInt(texto1);
                    int n2 = Integer.parseInt(texto2);
                    int sumaResultado = n1 * n2;

                    resultado.setText(String.valueOf(sumaResultado));
                }
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto1 = num1.getText().toString();
                String texto2 = num2.getText().toString();

                if (!texto1.isEmpty() && !texto2.isEmpty()) {
                    int n1 = Integer.parseInt(texto1);
                    int n2 = Integer.parseInt(texto2);
                    if (n2!=0){
                        int sumaResultado = n1 / n2;
                        resultado.setText(String.valueOf(sumaResultado));
                    }else {
                        String sumaResultado = "no se puede dividir entre cero";
                        resultado.setText(sumaResultado);
                    }
                }
            }
        });
        resto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto1 = num1.getText().toString();
                String texto2 = num2.getText().toString();

                if (!texto1.isEmpty() && !texto2.isEmpty()) {
                    int n1 = Integer.parseInt(texto1);
                    int n2 = Integer.parseInt(texto2);
                    int sumaResultado = n1 % n2;

                    resultado.setText(String.valueOf(sumaResultado));
                }
            }
        });




    }
}