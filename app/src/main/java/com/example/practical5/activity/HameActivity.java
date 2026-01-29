package com.example.practical5.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practical5.R;
import com.example.practical5.adapter.RecipeAdpater;
import com.example.practical5.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class HameActivity extends AppCompatActivity {

    ImageView productImage;

    private static final int PICK_IMAGE = 100;

    Uri selectedImage;

    RecyclerView menuRecyclerView;

    EditText menuName, menuPrice;

    Button addMenuBtn;

    List<Recipe> list = new ArrayList<>();

    RecipeAdpater recipeAdpater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);


        productImage = findViewById(R.id.image_icon);

        this.menuRecyclerView = findViewById(R.id.recycler_view);

        this.menuName = findViewById(R.id.menu_name);
        this.menuPrice = findViewById(R.id.menu_price);
        this.addMenuBtn = findViewById(R.id.submit_button);

        recipeAdpater = new RecipeAdpater(list);

        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuRecyclerView.setAdapter(recipeAdpater);

        addMenuBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(menuName.getText().toString().isEmpty() || menuPrice.getText().toString().isEmpty() || productImage == null){
                    Toast.makeText(HameActivity.this, "Fill All Filds", Toast.LENGTH_SHORT).show();
                    return;
                }
                list.add( new Recipe(menuName.getText().toString(), menuPrice.getText().toString(), selectedImage));

                recipeAdpater.notifyItemInserted(list.size()-1);
            }
        });


        productImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, HameActivity.PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null){
            selectedImage = data.getData();
            Log.i("Pick Image", "Image selected "+String.valueOf(data.getData()) );
            productImage.setImageURI(selectedImage);
        }

    }
}
