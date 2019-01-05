package pinkwhale.com.headyassignment.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pinkwhale.com.headyassignment.Adapters.CategoryListRecyclerAdapter;
import pinkwhale.com.headyassignment.Adapters.ProductsRecyclerAdapter;
import pinkwhale.com.headyassignment.Adapters.VariantsRecyclerAdapter;
import pinkwhale.com.headyassignment.Interectors.MainActivityInterector;
import pinkwhale.com.headyassignment.Models.Categories;
import pinkwhale.com.headyassignment.Models.Products;
import pinkwhale.com.headyassignment.Models.ProductsRanking;
import pinkwhale.com.headyassignment.Models.Variants;
import pinkwhale.com.headyassignment.R;
import pinkwhale.com.headyassignment.Retrofit.APIService;
import pinkwhale.com.headyassignment.Retrofit.ApiUtils;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIService mAPIService;
    Context context;
    Unbinder unbinder;
    @BindView(R.id.rv_categories)
    RecyclerView _rv_categories;

    @BindView(R.id.rv_products)
    RecyclerView _rv_products;

    @BindView(R.id.rv_varients)
    RecyclerView rv_varients;

    @BindView(R.id.progressBar)
    ProgressBar _progressBar;

    @BindView(R.id.fab)
    FloatingActionButton _fab;
   public static BottomSheetattachchatfile bottomSheetFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = MainActivity.this;
        unbinder = ButterKnife.bind(this);
        mAPIService = ApiUtils.getAPIService();

        ServiceCall();


    }

    private void ServiceCall() {
        _progressBar.setVisibility(View.VISIBLE);
        Call<Categories> call = mAPIService.GetData();
        MainActivityInterector.ApiCall(context, call);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void GetDataResponse(final Response<Categories> response) {

        _progressBar.setVisibility(View.GONE);
        CategoryListRecyclerAdapter recyclerAdapter = new CategoryListRecyclerAdapter(this, response.body().Category);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        _rv_categories.setLayoutManager(linearLayoutManager);
        _rv_categories.setAdapter(recyclerAdapter);


        _fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetFragment = new BottomSheetattachchatfile(response.body().Rankings);
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());

            }
        });

    }

    public void getProducts(ArrayList<Products> products) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ProductsRecyclerAdapter productsRecyclerAdapter = new ProductsRecyclerAdapter(context, products);
        productsRecyclerAdapter.notifyDataSetChanged();
        _rv_products.setLayoutManager(linearLayoutManager);
        _rv_products.setAdapter(productsRecyclerAdapter);
    }

    public void getVariants(ArrayList<Variants> variants) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        VariantsRecyclerAdapter variantsRecyclerAdapter = new VariantsRecyclerAdapter(context, variants);
        variantsRecyclerAdapter.notifyDataSetChanged();
        rv_varients.setLayoutManager(linearLayoutManager);
        rv_varients.setAdapter(variantsRecyclerAdapter);
    }



}
