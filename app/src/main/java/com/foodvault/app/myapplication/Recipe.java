package com.foodvault.app.myapplication;

/**
 * Created by annkeenan on 10/2/15.
 */
public class Recipe {
    //private variables
    int _id;
    String _name;
    String _url;
    String _prepTime;
    String _ingredients;
    String _information;
    String _rating;
    String _comments;

    // Empty constructor
    public Recipe(){

    }
    // constructor
    public Recipe(int id, String name, String _url, String _prepTime, String _ingredients,
                  String _information, String _rating, String _comments){
        this._id = id;
        this._name = name;
        this._url = _url;
        this._prepTime = _prepTime;
        this._ingredients = _ingredients;
        this._information = _information;
        this._rating = _rating;
        this._comments = _comments;
    }
    // constructor
    public Recipe(String name, String _url, String _prepTime, String _ingredients,
                  String _information, String _rating, String _comments){
        this._name = name;
        this._url = _url;
        this._prepTime = _prepTime;
        this._ingredients = _ingredients;
        this._information = _information;
        this._comments = _comments;
        this._rating = _rating;
    }

    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting url
    public String getUrl(){
        return this._url;
    }

    // setting url
    public void setUrl(String url){
        this._url = url;
    }

    // getting prep time
    public String getPrepTime(){
        return this._prepTime;
    }

    // setting prep time
    public void setPrepTime(String prepTime){
        this._prepTime = prepTime;
    }
    // getting information
    public String getIngredients(){
        return this._ingredients;
    }

    // setting information
    public void setIngredients(String ingredients){
        this._ingredients = ingredients;
    }

    // getting information
    public String getInformation(){
        return this._information;
    }

    // setting information
    public void setInformation(String information){
        this._information = information;
    }

    // getting rating
    public String getRating(){
        return this._rating;
    }

    // setting rating
    public void setRating(String rating){
        this._rating = rating;
    }

    // getting comments
    public String getComments(){
        return this._comments;
    }

    // setting comments
    public void setComments(String comments){
        this._comments = comments;
    }
}