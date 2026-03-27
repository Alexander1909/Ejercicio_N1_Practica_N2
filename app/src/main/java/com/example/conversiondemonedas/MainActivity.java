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

    double[] tasas = {1.0, 3.8, 0.92, 0.78, 83.0, 5.0, 17.0, 7.2, 150.0};