package com.example.practical5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practical5.R;
import com.example.practical5.entity.Recipe;

import java.util.List;

public class RecipeAdpater extends RecyclerView.Adapter<RecipeAdpater.ViewHolder> {

    List<Recipe> recipeList;

    public RecipeAdpater(List recipeList){
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.productImage.setImageURI(recipe.getProductImage());
        holder.menuName.setText(recipe.getMenuName());
        holder.menuPrice.setText(recipe.getMenuPrice());
    }

    @Override
    public int getItemCount() {
        return this.recipeList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        protected ImageView productImage;

        protected TextView menuName, menuPrice;



        public ViewHolder(View itemView){
            super(itemView);
            productImage = itemView.findViewById(R.id.productImg);
            menuName = itemView.findViewById(R.id.menu_name_text);
            menuPrice = itemView.findViewById(R.id.menu_price_text);

        }

    }

}
