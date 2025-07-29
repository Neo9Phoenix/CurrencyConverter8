package com.example.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup currencyGroup;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencyGroup = findViewById(R.id.currencyGroup);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            int selectedId = currencyGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                // No selection, do nothing or show a message (optional)
                return;
            }

            RadioButton selectedCurrency = findViewById(selectedId);
            String currency = selectedCurrency.getText().toString();

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("currency", currency);
            startActivity(intent);
        });
    }
}
