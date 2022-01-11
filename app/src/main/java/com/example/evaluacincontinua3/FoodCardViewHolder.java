package com.example.evaluacincontinua3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class FoodCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView ComidaImage;
    public TextView ComidaTitle;
    public TextView ComidaPrice;

    public FoodCardViewHolder(@NonNull View itemView){
        super(itemView);
        ComidaImage=itemView.findViewById(R.id.comida_image);
        ComidaTitle=itemView.findViewById(R.id.comida_title);
        ComidaPrice=itemView.findViewById(R.id.comida_price);
    }
}
