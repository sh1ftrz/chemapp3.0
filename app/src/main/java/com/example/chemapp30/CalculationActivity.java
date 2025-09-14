package com.example.chemapp30;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalculationActivity extends AppCompatActivity {

    EditText edtInput1, edtInput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtInput1 = findViewById(R.id.edtInput1);
        edtInput2 = findViewById(R.id.edtInput2);

        findViewById(R.id.btnMol).setOnClickListener(v -> calculateMol());
        findViewById(R.id.btnWW).setOnClickListener(v -> calculateWW());
        findViewById(R.id.btnWV).setOnClickListener(v -> calculateWV());
        findViewById(R.id.btnVV).setOnClickListener(v -> calculateVV());
    }

    private void calculateMol() {
        double mass = Double.parseDouble(edtInput1.getText().toString());
        double molar = Double.parseDouble(edtInput2.getText().toString());
        double mol = mass / molar;
        Toast.makeText(this, "โมล = " + mol, Toast.LENGTH_SHORT).show();
    }

    private void calculateWW() {
        double solute = Double.parseDouble(edtInput1.getText().toString());
        double solution = Double.parseDouble(edtInput2.getText().toString());
        double ww = solute / solution * 100;
        Toast.makeText(this, "w/w % = " + ww, Toast.LENGTH_SHORT).show();
    }

    private void calculateWV() {
        double solute = Double.parseDouble(edtInput1.getText().toString());
        double volume = Double.parseDouble(edtInput2.getText().toString());
        double wv = solute / volume * 100;
        Toast.makeText(this, "w/v % = " + wv, Toast.LENGTH_SHORT).show();
    }

    private void calculateVV() {
        double volSolute = Double.parseDouble(edtInput1.getText().toString());
        double volSolution = Double.parseDouble(edtInput2.getText().toString());
        double vv = volSolute / volSolution * 100;
        Toast.makeText(this, "v/v % = " + vv, Toast.LENGTH_SHORT).show();
    }
}