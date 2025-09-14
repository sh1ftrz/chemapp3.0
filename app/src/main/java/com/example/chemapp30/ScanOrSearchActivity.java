package com.example.chemapp30;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chemapp30.database.AppDatabase;
import com.example.chemapp30.database.Chemical;

public class ScanOrSearchActivity extends AppCompatActivity {

    EditText edtCode;
    Button btnSearch, btnScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scan_or_search);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

                setContentView(R.layout.activity_scan_or_search);

                edtCode = findViewById(R.id.edtCode);
                btnSearch = findViewById(R.id.btnSearch);
                btnScan = findViewById(R.id.btnScan);

                btnSearch.setOnClickListener(v -> searchChemical());
                btnScan.setOnClickListener(v -> scanChemical());
            }

            private void searchChemical() {
                String code = edtCode.getText().toString();
                Chemical chem = AppDatabase.getInstance(this).chemicalDao().getChemicalByCode(code);
                if (chem != null) {
                    Intent intent = new Intent(this, ChemicalDetailActivity.class);
                    intent.putExtra("code", code);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "ไม่พบสาร", Toast.LENGTH_SHORT).show();
                }
            }

            private void scanChemical() {
                // ZXing integration (หลังจากได้รหัส → searchChemical())
    }
}


