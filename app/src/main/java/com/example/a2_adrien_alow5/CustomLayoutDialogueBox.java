package com.example.a2_adrien_alow5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.a2_adrien_alow5.databinding.CustomDialogLayoutBinding;

public class CustomLayoutDialogueBox extends DialogFragment {
    private CustomDialogLayoutBinding binding;
    private CustomLayoutDialogBoxListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = CustomDialogLayoutBinding.inflate(LayoutInflater.from(getContext()));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(binding.getRoot());

        builder.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nameFromUI = binding.etDStoreName.getText().toString();
                String priceFromUI = binding.etDprice.getText().toString();
                boolean payedFromUI = binding.isDPayed.isChecked();

                listener.onDialogueLoginBtnPressed(nameFromUI, priceFromUI, payedFromUI);

            }
        });

        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }

    public interface CustomLayoutDialogBoxListener{
        public void onDialogueLoginBtnPressed(String name, String price, boolean payed);
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        try{
            listener = (CustomLayoutDialogBoxListener) context;
        } catch(ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement NoticeDialogListener");
        }
    }
}

