package com.example.claire.myrecipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import dao.IngredientDAO;

public class Proteins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proteins);

        ImageButton button = (ImageButton) findViewById(R.id.homeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PersonalSpace.class);
                startActivity(intent);
            }
        });

        Button buttonEggs = (Button)findViewById(R.id.premier);
        Button buttonDone = (Button)findViewById(R.id.second);

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ResultsRecipesIngredients.class);
                getBaseContext().startActivity(intent);
            }
        });

        buttonEggs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngredientDAO ingredientDAO = new IngredientDAO(getBaseContext());
                ingredientDAO.setSelected(2, getBaseContext());
            }
        });


    }
}
