package com.example.chemapp30;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.TextView;
import com.example.chemapp30.database.AppDatabase;
import com.example.chemapp30.database.Chemical;



public class ChemicalDetailActivity extends AppCompatActivity {
    TextView txtName, txtInfo, txtProperty, txtFirstAid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chemical_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

                txtName = findViewById(R.id.txtName);
                txtInfo = findViewById(R.id.txtInfo);
                txtProperty = findViewById(R.id.txtProperty);
                txtFirstAid = findViewById(R.id.txtFirstAid);

                String code = getIntent().getStringExtra("code");
                Chemical chem = AppDatabase.getInstance(this).chemicalDao().getChemicalByCode(code);

                if (chem != null) {
                    txtName.setText(chem.getName());
                    txtInfo.setText("ข้อมูล: " + chem.getInfo());
                    txtProperty.setText("คุณสมบัติ: " + chem.getProperty());
                    txtFirstAid.setText("ปฐมพยาบาล: " + chem.getFirstAid());
                }
     }
}
