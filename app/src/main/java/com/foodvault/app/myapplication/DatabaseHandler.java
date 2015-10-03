package com.foodvault.app.myapplication;

        import java.util.ArrayList;
        import java.util.List;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by annkeenan on 10/2/15.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    //Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "recipesManager";
    // Recipes Table Name
    private static final String TABLE_RECIPES = "recipes";
    // Recipes Table Columns Names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_URL = "url";
    private static final String KEY_PREPTIME = "preptime";
    private static final String KEY_INGREDIENTS = "ingredients";
    private static final String KEY_INFORMATION = "information";
    private static final String KEY_RATING = "rating";
    private static final String KEY_COMMENTS = "comments";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_RECIPES_TABLE = "CREATE TABLE " + TABLE_RECIPES + "(" + KEY_ID +
                " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_URL + " TEXT,"
                + KEY_PREPTIME + " TEXT," + KEY_INGREDIENTS + " TEXT," + KEY_INFORMATION
                + " TEXT," + KEY_RATING + " TEXT," + KEY_COMMENTS + " TEXT" + ");";
        db.execSQL(CREATE_RECIPES_TABLE);
    }

    // Upgrading Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);

        // Create tables again
        onCreate(db);
    }
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    // Adding New Recipe
    void addRecipe(Recipe recipe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(KEY_ID, recipe.getID());
        values.put(KEY_NAME, recipe.getName());
        values.put(KEY_URL, recipe.getUrl());
        values.put(KEY_PREPTIME, recipe.getPrepTime());
        values.put(KEY_INGREDIENTS, recipe.getIngredients());
        values.put(KEY_INFORMATION, recipe.getInformation());
        values.put(KEY_RATING, recipe.getRating());
        values.put(KEY_COMMENTS, recipe.getComments());
        // Inserting Row
        db.insert(TABLE_RECIPES, null, values);
        db.close();
    }

    // Getting Single Recipe
    Recipe getRecipe(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_RECIPES, new String[] { KEY_ID, KEY_NAME, KEY_URL,
                        KEY_PREPTIME, KEY_INGREDIENTS, KEY_INFORMATION, KEY_RATING, KEY_COMMENTS},
                KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null,
                null);
        if(cursor != null)
            cursor.moveToFirst();
        Recipe recipe = new Recipe(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7));
        // Retun Recipe
        return recipe;
    }

    // Getting All Recipes
    public List<Recipe> getAllRecipes(){
        List<Recipe> recipeList = new ArrayList<Recipe>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RECIPES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Recipe recipe = new Recipe();
                recipe.setID(Integer.parseInt(cursor.getString(0)));
                recipe.setName(cursor.getString(1));
                recipe.setUrl(cursor.getString(2));
                recipe.setPrepTime(cursor.getString(3));
                recipe.setIngredients(cursor.getString(4));
                recipe.setInformation(cursor.getString(5));
                recipe.setRating(cursor.getString(6));
                recipe.setComments(cursor.getString(7));
                // Adding contact to list
                recipeList.add(recipe);
            } while (cursor.moveToNext());
        }
        // return contact list
        return recipeList;
    }

    // Updating single contact
    public int updateRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, recipe.getName());
        values.put(KEY_URL, recipe.getUrl());
        values.put(KEY_PREPTIME, recipe.getPrepTime());
        values.put(KEY_INGREDIENTS, recipe.getIngredients());
        values.put(KEY_INFORMATION, recipe.getInformation());
        values.put(KEY_RATING, recipe.getRating());
        values.put(KEY_COMMENTS,recipe.getComments());
        // updating row
        return db.update(TABLE_RECIPES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(recipe.getID()) });
    }

    // Deleting single contact
    public void deleteRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RECIPES, KEY_ID + " = ?",
                new String[] { String.valueOf(recipe.getID()) });
        db.close();
    }


    // Getting contacts Count
    public int getRecipesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_RECIPES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        // return count
        return cursor.getCount();
    }
}