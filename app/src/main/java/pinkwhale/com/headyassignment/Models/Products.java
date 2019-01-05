package pinkwhale.com.headyassignment.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Products {


    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;


    @SerializedName("date_added")
    public String date_added;

    @SerializedName("variants")
    public ArrayList<Variants> variants = new ArrayList<>();
}
