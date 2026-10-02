package com.example.tsdmh_7s5_prac4_lall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {
    EditText txtnombre;

    ActivityResultLauncher<Intent> lanzador = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult resultado) {
            if (resultado.getResultCode() == Activity.RESULT_OK){
                Intent tonterias = resultado.getData();
                String info = tonterias.getStringExtra("info");
                Toast.makeText(PrincipalActivity.this, "Informacion:" + info, Toast.LENGTH_SHORT).show();

            } else if (resultado.getResultCode() == Activity.RESULT_CANCELED) {
                Toast.makeText(PrincipalActivity.this, "Se cancelo", Toast.LENGTH_SHORT).show();
                
            }

        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtnombre = findViewById(R.id.txtnombre);
    }
    public void Btn1click(View v){
        Intent informacion = new Intent(this, RecibeActivity.class);
        informacion.putExtra("nombre",txtnombre.getText().toString());
        startActivity(informacion);


    }

    public void btn2activo(View v){
        Intent informacion = new Intent(this, RegresoInfoActivity.class);
        informacion.putExtra("nombre",txtnombre.getText().toString());
        lanzador.launch(informacion);
    }
}