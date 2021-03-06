package com.example.claire.myrecipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import dao.IngredientDAO;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        IngredientDAO ingredientDAO = new IngredientDAO(getApplicationContext());
        ingredientDAO.dropTableIngredientSelected();
        Button buttonSelectIngredients = (Button)findViewById(R.id.premier);
        Button buttonSuggestions = (Button)findViewById(R.id.second);
        Button buttonSearchHistory = (Button)findViewById(R.id.trois);
        Button buttonLastRecipes = (Button)findViewById(R.id.quatre);
        Button buttonFavoriteRecipes = (Button)findViewById(R.id.cinq);

        ImageButton button = (ImageButton) findViewById(R.id.homeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PersonalSpace.class);
                startActivity(intent);
            }
        });

        buttonSelectIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SelectIngredients.class);
                getBaseContext().startActivity(intent);
            }
        });

        buttonSuggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Suggestions.class);
                getBaseContext().startActivity(intent);
            }
        });
        buttonSearchHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SearchHistory.class);
                getBaseContext().startActivity(intent);
            }
        });
        buttonLastRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), UserHistory.class);
                getBaseContext().startActivity(intent);
            }
        });
        buttonFavoriteRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FavoriteRecipes.class);
                getBaseContext().startActivity(intent);
            }
        });
    }
}
