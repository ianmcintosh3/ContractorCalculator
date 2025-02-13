package com.example.contractorcalculator;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Calculate();
    }
    private void Calculate(){
        Button cButton = findViewById(R.id.buttonCalculate);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText laBor = findViewById(R.id.editTextLabor);
                EditText matS = findViewById(R.id.editTextMaterial);
                TextView subT = findViewById(R.id.textViewSubTotal);
                TextView taxtext = findViewById(R.id.textViewTax);
                TextView totaltext = findViewById(R.id.textViewTotal);
                Resources res = getResources();
                // Convert input directly to double (assuming valid input)
                double laborCost = Double.parseDouble(laBor.getText().toString());
                double materialCost = Double.parseDouble(matS.getText().toString());
                double subtotal = laborCost + materialCost;
                final double TAX_RATE = 0.05;
                double tax = subtotal * TAX_RATE;
                double total = subtotal + tax;

                // Display results
                subT.setText(String.format("Subtotal: $%.2f", subtotal));
                taxtext.setText(String.format("Tax: $%.2f", tax));
                totaltext.setText(String.format("Total: $%.2f", total));
            }
        });

            }
    }