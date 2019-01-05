package pinkwhale.com.headyassignment.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pinkwhale.com.headyassignment.Activity.MainActivity;
import pinkwhale.com.headyassignment.Models.Categories;
import pinkwhale.com.headyassignment.Models.Products;
import pinkwhale.com.headyassignment.R;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ProductsViewHolder> {

    private List<Products> listProducts;
    private Context context;
    int mCheckedPostion = 0;


    public ProductsRecyclerAdapter(Context context, List<Products> listOfProducts) {
        this.listProducts = listOfProducts;
        this.context = context;
    }

    @Override
    public ProductsRecyclerAdapter.ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item_product_list, parent, false);
        ProductsRecyclerAdapter.ProductsViewHolder categoriesViewHolder = new ProductsRecyclerAdapter.ProductsViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductsRecyclerAdapter.ProductsViewHolder categoriesViewHolder, int position) {
        Products products = listProducts.get(position);

        if (products != null) {
            categoriesViewHolder.tvCategoryName.setText(products.name);
        }

        if (mCheckedPostion == position) {
            categoriesViewHolder.tvCategoryName.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            ((MainActivity) context).getVariants(products.variants);
        }else{
            categoriesViewHolder.tvCategoryName.setTextColor(context.getResources().getColor(R.color.black));
        }

        setOnClickListeners(categoriesViewHolder,position);



    }

    private void setOnClickListeners(ProductsViewHolder categoriesViewHolder, final int position) {
        categoriesViewHolder.cvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductsRecyclerAdapter.this.notifyDataSetChanged();
                mCheckedPostion = position;

                //((MainActivity) context).getProducts(products);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }



    public static class ProductsViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoryName;
        CardView cvCategory;

        ProductsViewHolder(View view) {
            super(view);
            tvCategoryName = (TextView) view.findViewById(R.id.tv_category_name);
            cvCategory = (CardView) view.findViewById(R.id.cv_category);
            /*ivOfferImage = (ImageView) view.findViewById(R.id.iv_offer_image);*/
            //tvProductName.setPaintFlags(tvProductName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}

