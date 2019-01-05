package pinkwhale.com.headyassignment.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Categories {


    @SerializedName("categories")
    public ArrayList<categories> Category = new ArrayList<>();


    @SerializedName("rankings")
    public ArrayList<rankings> Rankings = new ArrayList<>();

    public class categories {

        @SerializedName("id")
        public int id;

        @SerializedName("name")
        public String name;

        @SerializedName("products")
        public ArrayList<Products> products = new ArrayList<>();

    }


    public class rankings {

        @SerializedName("ranking")
        public String ranking;

        @SerializedName("products")
        public ArrayList<ProductsRanking> productsranking = new ArrayList<>();

    }
}
