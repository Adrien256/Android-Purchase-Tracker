package com.example.a2_adrien_alow5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.example.a2_adrien_alow5.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Switch sw1;
    ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnShowPurchases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Screen2Activity.class);

                intent.putExtra("EXTRA_PURCHASE_LIST", purchaseList);

                startActivity(intent);
            }
        });
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data from form
                String name = "";
                String priceFromUI;
                double price = 0;
                boolean init1 = false, init2 = false;
                if (binding.etStoreName.getText().toString().length() > 0) {
                    name = binding.etStoreName.getText().toString();
                    init1 = true;
                }
                if (binding.etPrice.getText().toString().length() > 0) {
                    priceFromUI = binding.etPrice.getText().toString();
                    price = Double.parseDouble(priceFromUI);
                    init2 = true;
                }
                sw1 = (Switch)findViewById(R.id.isPayed);
                boolean isPayed = sw1.isChecked();

                // add data to list
                if (init1 && init2) {
                    Purchase purchaseAddToArray = new Purchase(name, price, isPayed);
                    purchaseList.add(purchaseAddToArray);
                    Toast myToast = Toast.makeText(getApplicationContext(), "Entry added", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });
        binding.btnLoadDummyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseList.add(new Purchase("Walmart", 15.01, true));
                purchaseList.add(new Purchase("Shoe Store", 75.81, true));
                purchaseList.add(new Purchase("Loblaws", 55.21, false));
                purchaseList.add(new Purchase("Canadian tire", 28.97, false));
                purchaseList.add(new Purchase("Best Buy", 65.12, true));

                Toast myToast = Toast.makeText(getApplicationContext(), "Dummy data added", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
    }
}