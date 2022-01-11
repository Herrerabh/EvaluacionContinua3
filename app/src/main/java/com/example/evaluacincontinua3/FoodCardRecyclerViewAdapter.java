package com.example.evaluacincontinua3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacincontinua3.network.ImageRequester;
import com.example.evaluacincontinua3.network.FoodEntry;

import java.util.List;

public class FoodCardRecyclerViewAdapter extends RecyclerView.Adapter<FoodCardViewHolder> {

    private List<FoodEntry> comidaList;
    private ImageRequester imageRequester;

    FoodCardRecyclerViewAdapter(List<FoodEntry> productList){
        this.comidaList= productList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public FoodCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View layoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_card,parent,false);
        return new FoodCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodCardViewHolder holder, int position){
        if(comidaList!= null & position<comidaList.size()){
            FoodEntry product= comidaList.get(position);
            holder.ComidaTitle.setText(product.title);
            holder.ComidaPrice.setText(product.price);
            imageRequester.setImageFromUrl(holder.ComidaImage, product.url);
        }
    }

    @Override
    public int getItemCount(){
        return comidaList.size();
    }
}