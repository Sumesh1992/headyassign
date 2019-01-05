package pinkwhale.com.headyassignment.Models;

import com.google.gson.annotations.SerializedName;

public class ProductsRanking {

    @SerializedName("id")
    public int id;

    @SerializedName("view_count")
    public int view_count;

    @SerializedName("order_count")
    public int order_count;

    @SerializedName("shares")
    public int shares;

}
