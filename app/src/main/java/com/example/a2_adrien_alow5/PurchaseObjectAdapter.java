package com.example.a2_adrien_alow5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a2_adrien_alow5.databinding.CustomRowLayoutBinding;

import java.util.List;

public class PurchaseObjectAdapter extends ArrayAdapter {
    private List<Purchase> purchaseList;


    public PurchaseObjectAdapter(@NonNull Context context, List<Purchase> purchaseList) {
        super(context, 0);
        this.purchaseList = purchaseList;
    }
    @Override
    public int getCount(){return purchaseList.size();}

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row_layout, parent, false);
        }
        Purchase currPurchase = purchaseList.get(position);
        CustomRowLayoutBinding binding = CustomRowLayoutBinding.bind(convertView);

        binding.tvStoreName.setText(currPurchase.getStoreName());
        binding.tvPrice.setText(String.valueOf(currPurchase.getPurchaseAmount()));

        boolean payed = currPurchase.isAlreadyPayed();

        if (payed){
            binding.tvIsPayed.setText("Payed");
        }else{
            binding.tvIsPayed.setText("Not Payed");
        }

        return convertView;
    }
}

