package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;


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


        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('+');
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('-');
            }
        });

        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('*');
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('/');
            }
        });

        resto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular('%');
            }
        });
    }
    private void calcular(char operacion) {
        String texto1 = num1.getText().toString().trim();
        String texto2 = num2.getText().toString().trim();

        // 1. Validar que no estén vacíos
        if (texto1.isEmpty() || texto2.isEmpty()) {
            resultado.setText("Por favor, ingresa ambos números");
            return;
        }

        try {
            // 2. Convertir a double para soportar decimales y números grandes
            double n1 = Double.parseDouble(texto1);
            double n2 = Double.parseDouble(texto2);
            double res = 0;

            // 3. Evaluar la operación
            switch (operacion) {
                case '+': res = n1 + n2; break;
                case '-': res = n1 - n2; break;
                case '*': res = n1 * n2; break;
                case '/':
                    if (n2 != 0) {
                        res = n1 / n2;
                    } else {
                        resultado.setText("No se puede dividir entre cero");
                        return;
                    }
                    break;
                case '%':
                    if (n2 != 0) {
                        res = n1 % n2;
                    } else {
                        resultado.setText("No se puede calcular el resto con cero");
                        return;
                    }
                    break;
            }

            // 4. Mostrar el resultado formateado
            resultado.setText(String.valueOf(res));

        } catch (NumberFormatException e) {
            // Protección por si el usuario logra meter un texto no válido
            resultado.setText("Número inválido o demasiado grande");
        }
    }
}