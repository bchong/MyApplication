package com.foodvault.app.myapplication;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by annkeenan on 10/3/15.
 */
public class SQLiteActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite);
        DatabaseHandler db = new DatabaseHandler(this);
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addRecipe(new Recipe(1, "Enchiladas", "URL", "Prep Time", "Ingredients", "Information",
                "Rating", "Comments"));
        // Reading all contacts
        Log.d("Reading: ", "Reading all recipes...");
        List<Recipe> recipes = db.getAllRecipes();
        for (Recipe rp : recipes) {
            String log = "Id: " + rp.getID() + " ,Name: " + rp.getName() + " , Url: "
                    + rp.getUrl() + " , Prep Time: " + rp.getPrepTime() + " ,Ingredients: "
                    + rp.getIngredients() + " ,Information: " + rp.getInformation()
                    + " , Rating: " + rp.getRating() + " , Comments: " + rp.getComments();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
