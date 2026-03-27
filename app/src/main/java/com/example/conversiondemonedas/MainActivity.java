package com.example.conversiondemonedas;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etCantidad;
    Spinner spOrigen, spDestino;
    Button btnConvertir;
    TextView tvResultado;
    String[] monedas = {"USD", "PEN", "EUR", "GBP", "INR", "BRL", "MXN", "CNY", "JPY"};

    // Tasas respecto al dólar (valores aproximados)
    double[] tasas = {1.0, 3.8, 0.92, 0.78, 83.0, 5.0, 17.0, 7.2, 150.0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCantidad = findViewById(R.id.etCantidad);
        spOrigen = findViewById(R.id.spMonedaOrigen);
        spDestino = findViewById(R.id.spMonedaDestino);
        btnConvertir = findViewById(R.id.btnConvertir);
        tvResultado = findViewById(R.id.tvResultado);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, monedas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spOrigen.setAdapter(adapter);
        spDestino.setAdapter(adapter);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertir();
            }
        });
    }

    private void convertir() {
        try {
            double cantidad = Double.parseDouble(etCantidad.getText().toString());
            int origenIndex = spOrigen.getSelectedItemPosition();
            int destinoIndex = spDestino.getSelectedItemPosition();

            // Convertir a USD primero, luego a la moneda destino
            double cantidadEnUSD = cantidad / tasas[origenIndex];
            double resultado = cantidadEnUSD * tasas[destinoIndex];

            tvResultado.setText(String.format("Resultado: %.2f %s", resultado, monedas[destinoIndex]));
        } catch (NumberFormatException e) {
            tvResultado.setText("Ingrese una cantidad válida");
        }
    }
}
