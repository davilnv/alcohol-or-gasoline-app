package br.com.texsistemas.alcoholorgasoline;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditAlcohol, textInputEditGasoline;
    private TextView textViewResult;
    private String priceAlcohol, priceGasoline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEditAlcohol = findViewById(R.id.textInputEditAlcohol);
        textInputEditGasoline = findViewById(R.id.textInputEditGasoline);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void calculatePrice(View view) {

        if (validateFields()) {
            try {
                Double priceAlcohol = Double.parseDouble(this.priceAlcohol);
                Double priceGasoline = Double.parseDouble(this.priceGasoline);

                if ((priceAlcohol / priceGasoline) >= 0.7) {
                    textViewResult.setText(R.string.result_better_gasoline);
                } else {
                    textViewResult.setText(R.string.result_better_alcohol);
                }
            } catch (Exception e) {
                textViewResult.setText(R.string.error_validate_fields_invalid);
            }
        } else {
            textViewResult.setText(R.string.error_validate_fields_empty);
        }
    }

    private boolean validateFields() {
        priceAlcohol = textInputEditAlcohol.getText() != null
                ? (
                !textInputEditAlcohol.getText().toString().isEmpty()
                        ? textInputEditAlcohol.getText().toString()
                        : null
        )
                : null;
        priceGasoline = textInputEditGasoline.getText() != null
                ? (
                !textInputEditGasoline.getText().toString().isEmpty()
                        ? textInputEditGasoline.getText().toString()
                        : null
        )
                : null;

        return priceAlcohol != null && priceGasoline != null;
    }
}