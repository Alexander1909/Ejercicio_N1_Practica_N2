package com.example.conversormoneda;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etCantidad;
    Spinner spOrigen, spDestino;
    Button btnConvertir;
    TextView tvResultado;