package com.example.tsdmh_7s5_prac4_lall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegresoInfoActivity extends AppCompatActivity {
    TextView p3lblresul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regreso_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        p3lblresul = findViewById(R.id.p3lblresul);
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("nombre");
        p3lblresul.setText(nombre);
    }

    public void accionclick(View v){
        if (v.getId() == R.id.btnregresa){
            Intent tonteria = new Intent();
            tonteria.putExtra("info","somos muy buenos");
            setResult(RESULT_OK,tonteria);
            finish();
        } else if (v.getId() == R.id.btncancela) {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}