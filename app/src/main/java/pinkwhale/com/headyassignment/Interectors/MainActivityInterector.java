package pinkwhale.com.headyassignment.Interectors;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import pinkwhale.com.headyassignment.Activity.MainActivity;
import pinkwhale.com.headyassignment.Models.Categories;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityInterector {
    public static void ApiCall(final Context context, Call<Categories> call) {
        call.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                try {
                    Log.e("getDoctor", new Gson().toJson(response));

                    ((MainActivity) context).GetDataResponse(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                call.cancel();
                t.printStackTrace();
                Toast.makeText(context, "Connection timeout", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
