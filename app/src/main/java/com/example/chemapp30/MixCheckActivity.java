package com.example.chemapp30;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.EditText;
import android.widget.TextView;

import com.example.chemapp30.database.AppDatabase;
import com.example.chemapp30.database.DangerousMix;

public class MixCheckActivity extends AppCompatActivity {

    EditText edtCode1, edtCode2;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mix_check);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtCode1 = findViewById(R.id.edtCode1);
        edtCode2 = findViewById(R.id.edtCode2);
        txtResult = findViewById(R.id.txtResult);

        findViewById(R.id.btnCheck).setOnClickListener(v -> checkMix());
    }

    private void checkMix() {
        String code1 = edtCode1.getText().toString();
        String code2 = edtCode2.getText().toString();

        DangerousMix mix = AppDatabase.getInstance(this).dangerousMixDao().getMix(code1, code2);
        if (mix != null) {
            txtResult.setText("⚠️ " + mix.getWarning());
        } else {
            txtResult.setText("✔️ ปลอดภัย / ไม่มีข้อมูลว่ามีปฏิกิริยา");
        }
    }
}