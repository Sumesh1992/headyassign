package pinkwhale.com.headyassignment.Retrofit;

import pinkwhale.com.headyassignment.Models.Categories;
import retrofit2.Call;
import retrofit2.http.GET;


public interface APIService {


    @GET("json")
    Call<Categories> GetData();


}
