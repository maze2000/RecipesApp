package com.example.claire.myrecipes;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import dao.IngredientDAO;
import dao.RecipeDAO;
import dao.SessionDAO;
import dao.UserDAO;
import model.Ingredient;
import model.Recipe;
import model.Session;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        UserDAO userDAO = new UserDAO(getApplicationContext());
       // userDAO.dropTable();
        final Button buttonSignIn = (Button)findViewById(R.id.signIn);
        Button buttonLogIn = (Button)findViewById(R.id.logIn);

        RecipeDAO recipeDAO = new RecipeDAO(getBaseContext());
        recipeDAO.dropTable();
        recipeDAO = new RecipeDAO(getBaseContext());
        IngredientDAO ingredientDAO = new IngredientDAO(getBaseContext());
        ingredientDAO.dropTableIngredientSelected();
        ingredientDAO.dropTableIngredients();
        ingredientDAO.dropTableCategories();

        //ingredientDAO.dropTableCategoriesProhibited();
        ingredientDAO = new IngredientDAO(getBaseContext());
        SessionDAO sessionDAO = new SessionDAO(getBaseContext());
        sessionDAO.dropTable();

        ingredientDAO.addCategory("Proteins"); //1
        ingredientDAO.addCategory("Vegetables"); //2
        ingredientDAO.addCategory("Fats"); //3
        ingredientDAO.addCategory("Fibre"); //4
        ingredientDAO.addCategory("Dairy"); //5
        ingredientDAO.addCategory("Fruits"); //6
        ingredientDAO.addCategory("Spices"); //7
        ingredientDAO.addCategory("Sugar"); //8
        long id_proteins = ingredientDAO.getIdCategory("Proteins");
        long id_vegetables = ingredientDAO.getIdCategory("Vegetables");
        long id_fats = ingredientDAO.getIdCategory("Fats");
        long id_fibre = ingredientDAO.getIdCategory("Fibre");
        long id_dairy = ingredientDAO.getIdCategory("Dairy");
        long id_fruits = ingredientDAO.getIdCategory("Fruits");
        long id_sugar = ingredientDAO.getIdCategory("Sugar");
        long id_spices = ingredientDAO.getIdCategory("Spices");

        Ingredient sugar = new Ingredient("sugar", id_sugar, -1); //1
        ingredientDAO.add(sugar);
        Ingredient eggs = new Ingredient("eggs", id_proteins, -1); //2
        ingredientDAO.add(eggs);
        Ingredient milk = new Ingredient("milk", id_dairy,-1); //3
        ingredientDAO.add(milk);
        Ingredient honey = new Ingredient("honey", id_sugar, -1); //4
        ingredientDAO.add(honey);
        Ingredient chocolate = new Ingredient("chocolate", id_sugar, -1); //5
        ingredientDAO.add(chocolate);
        Ingredient huile = new Ingredient("Oliv oil", id_fats, -1);
        ingredientDAO.add(huile);


        Vector<Ingredient> ingList = new Vector<Ingredient>();
        ingList.add(new Ingredient("sugar", 8));
        ingList.add(new Ingredient("eggs", 1));
        ingList.add(new Ingredient("milk", 5));
        ingList.add(new Ingredient("honey", 8));
        ingList.add(new Ingredient("chocolate", 8));

        Vector<Ingredient> wanted = new Vector<Ingredient>();
        wanted.add(new Ingredient("milk",0));
        Vector<Ingredient> forbidden = new Vector<Ingredient>();
        forbidden.add(new Ingredient("eggs", 0));

        String s = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
        recipeDAO.add(new Recipe(0,0,"Recipe1", ingList, s));
        ingList.remove(0);
        recipeDAO.add(new Recipe(0,0,"Recipe2", ingList, s));
        ingList.remove(0);
        recipeDAO.add(new Recipe(0,0,"Recipe3", ingList, s));
        ingList.remove(0);
        recipeDAO.add(new Recipe(0,0,"Recipe4", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe5", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe6", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe7", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe8", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe9", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe10", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe11", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe12", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe13", ingList, s));
        recipeDAO.add(new Recipe(0,0,"Recipe14", ingList, s));


        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogIn = new Intent(getBaseContext(), LogIn.class);
                getBaseContext().startActivity(intentLogIn);
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignIn = new Intent(getBaseContext(), SignIn.class);
                getBaseContext().startActivity(intentSignIn);
            }
        });
    }
}
