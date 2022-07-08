package com.example.a2_adrien_alow5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.a2_adrien_alow5.databinding.ActivityScreen2Binding;

import java.io.Serializable;
import java.util.ArrayList;

public class Screen2Activity extends AppCompatActivity implements CustomLayoutDialogueBox.CustomLayoutDialogBoxListener{

    private ActivityScreen2Binding binding;
    ArrayList<Purchase> purchaseListFromPrevScreen;
    int accessPoint;
    PurchaseObjectAdapter purchaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScreen2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int positionClicked;
        // receive the intent
        Intent intent = getIntent();
        if (intent != null){
            purchaseListFromPrevScreen =
                    (ArrayList<Purchase>) intent.getSerializableExtra("EXTRA_PURCHASE_LIST");

            purchaseAdapter = new PurchaseObjectAdapter(this, purchaseListFromPrevScreen);
            binding.lvPurchases.setAdapter(purchaseAdapter);

            binding.lvPurchases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d("ABC", "Purchase has been clicked on");
                    accessPoint = position;

                    CustomLayoutDialogueBox myCustomBox = new CustomLayoutDialogueBox();
                    myCustomBox.show(getSupportFragmentManager(), "custom layout");
                }
            });
        }
    }

    @Override
    public void onDialogueLoginBtnPressed(String name, String price, boolean payed) {
        if (name.length() > 0 && price.length() > 0 && Double.parseDouble(price) >= 0) {
            (purchaseListFromPrevScreen.get(accessPoint)).setStoreName(name);
            (purchaseListFromPrevScreen.get(accessPoint)).setPurchaseAmount(Double.parseDouble(price));
            (purchaseListFromPrevScreen.get(accessPoint)).setAlreadyPayed(payed);
            purchaseAdapter.notifyDataSetChanged();

            Toast myToast = Toast.makeText(getApplicationContext(), "Update Success", Toast.LENGTH_SHORT);
            myToast.show();
        }else{
            Toast myFToast = Toast.makeText(getApplicationContext(), "Update Failed", Toast.LENGTH_SHORT);
            myFToast.show();
        }
    }
}
