package com.example.currencyconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText usdInput, currencyOutput;
    Button toCurrencyButton, toUsdButton, returnButton;

    double exchangeRate = 1.0;
    String currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        usdInput = findViewById(R.id.usdInput);
        currencyOutput = findViewById(R.id.currencyOutput);
        toCurrencyButton = findViewById(R.id.toCurrencyButton);
        toUsdButton = findViewById(R.id.toUsdButton);
        returnButton = findViewById(R.id.returnButton);

        // Get currency from intent
        currency = getIntent().getStringExtra("currency");

        // Set exchange rate
        switch (currency) {
            case "YEN":
                exchangeRate = 109.94;
                break;
            case "CAD":
                exchangeRate = 1.26;
                break;
            case "EUR":
                exchangeRate = 0.85;
                break;
        }

        toCurrencyButton.setOnClickListener(v -> {
            String usdStr = usdInput.getText().toString();
            if (!usdStr.isEmpty()) {
                double usd = Double.parseDouble(usdStr);
                double converted = usd * exchangeRate;
                currencyOutput.setText(String.valueOf(converted));
            }
        });

        toUsdButton.setOnClickListener(v -> {
            String currStr = currencyOutput.getText().toString();
            if (!currStr.isEmpty()) {
                double curr = Double.parseDouble(currStr);
                double converted = curr / exchangeRate;
                usdInput.setText(String.valueOf(converted));
            }
        });

        returnButton.setOnClickListener(v -> finish());
    }
}
