package com.example.chemapp30;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.EditText;
import android.widget.Toast;

import com.example.chemapp30.database.AppDatabase;
import com.example.chemapp30.database.DangerousMix;


public class AddChemicalActivity extends AppCompatActivity {

    EditText edtCode1, edtCode2, edtWarning;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_chemical);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtCode1 = findViewById(R.id.edtCode1);
        edtCode2 = findViewById(R.id.edtCode2);
        edtWarning = findViewById(R.id.edtWarning);

        findViewById(R.id.btnSaveMix).setOnClickListener(v -> saveMix());
    }

    private void saveMix() {
        DangerousMix mix = new DangerousMix();
        mix.setCode1(edtCode1.getText().toString());
        mix.setCode2(edtCode2.getText().toString());
        mix.setWarning(edtWarning.getText().toString());

        AppDatabase.getInstance(this).dangerousMixDao().insert(mix);
        Toast.makeText(this, "เพิ่มคู่สารอันตรายเรียบร้อย", Toast.LENGTH_SHORT).show();
        finish();
    }
}