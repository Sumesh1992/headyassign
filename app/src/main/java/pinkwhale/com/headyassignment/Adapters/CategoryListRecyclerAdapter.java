package pinkwhale.com.headyassignment.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pinkwhale.com.headyassignment.Activity.MainActivity;
import pinkwhale.com.headyassignment.Models.Categories;
import pinkwhale.com.headyassignment.Models.Products;
import pinkwhale.com.headyassignment.R;

public class CategoryListRecyclerAdapter extends RecyclerView.Adapter<CategoryListRecyclerAdapter.CategoriesViewHolder> {

    private List<Categories.categories> listCategories;
    private Context context;
    int mCheckedPostion = 0;


    public CategoryListRecyclerAdapter(Context context, List<Categories.categories> listOfferProducts) {
        this.listCategories = listOfferProducts;
        this.context = context;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item_product_list, parent, false);
            /*ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(Utils.getInstance(context).dpToPx(160), ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(layoutParams);*/
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder categoriesViewHolder, int position) {
        Categories.categories categories = listCategories.get(position);

        if (categories != null) {
            categoriesViewHolder.tvCategoryName.setText(categories.name);
            // new AQuery(context).id(offersViewHolder.ivOfferImage).image("http://2.bp.blogspot.com/-g_wISt88yf8/VhY829TLyVI/AAAAAAAAAaA/kZHbLX8DRyk/s1600/1.jpg");
        }

        if (mCheckedPostion == position) {
            categoriesViewHolder.tvCategoryName.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            ((MainActivity) context).getProducts(categories.products);
        }else{
            categoriesViewHolder.tvCategoryName.setTextColor(context.getResources().getColor(R.color.black));
        }

        setOnClickListeners(categoriesViewHolder,position);

    }

    @Override
    public int getItemCount() {
        return listCategories.size();
    }

    private void setOnClickListeners(final CategoriesViewHolder categoriesViewHolder, final int position) {
        categoriesViewHolder.cvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryListRecyclerAdapter.this.notifyDataSetChanged();
                mCheckedPostion = position;

                //((MainActivity) context).getProducts(products);
            }
        });
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoryName;
        CardView cvCategory;

        CategoriesViewHolder(View view) {
            super(view);
            tvCategoryName = (TextView) view.findViewById(R.id.tv_category_name);
            cvCategory = (CardView) view.findViewById(R.id.cv_category);
            /*ivOfferImage = (ImageView) view.findViewById(R.id.iv_offer_image);*/
            //tvProductName.setPaintFlags(tvProductName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
