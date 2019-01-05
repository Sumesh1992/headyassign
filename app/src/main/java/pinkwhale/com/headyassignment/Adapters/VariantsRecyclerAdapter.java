package pinkwhale.com.headyassignment.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pinkwhale.com.headyassignment.Models.Variants;
import pinkwhale.com.headyassignment.R;

public class VariantsRecyclerAdapter extends RecyclerView.Adapter<VariantsRecyclerAdapter.VariantsViewHolder> {

    private List<Variants> listVariants;
    private Context context;


    public VariantsRecyclerAdapter(Context context, List<Variants> listOfVariants) {
        this.listVariants = listOfVariants;
        this.context = context;
    }

    @Override
    public VariantsRecyclerAdapter.VariantsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item_varients_list, parent, false);
        VariantsRecyclerAdapter.VariantsViewHolder categoriesViewHolder = new VariantsRecyclerAdapter.VariantsViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(VariantsRecyclerAdapter.VariantsViewHolder variantsViewHolder, int position) {
        Variants variants = listVariants.get(position);

        if (variants != null) {
            variantsViewHolder.tvVariantPrice.setText(variants.price);
            variantsViewHolder.tvVariantColor.setText(variants.color);
            variantsViewHolder.tvVariantSize.setText(variants.size);
        }


    }

    @Override
    public int getItemCount() {
        return listVariants.size();
    }


    public static class VariantsViewHolder extends RecyclerView.ViewHolder {
        TextView tvVariantColor;
        TextView tvVariantPrice;
        TextView tvVariantSize;
        CardView cvVarient;

        VariantsViewHolder(View view) {
            super(view);
            tvVariantColor = (TextView) view.findViewById(R.id.tv_varient_color);
            tvVariantPrice = (TextView) view.findViewById(R.id.tv_varient_price);
            tvVariantSize = (TextView) view.findViewById(R.id.tv_varient_size);
            cvVarient = (CardView) view.findViewById(R.id.cv_varient);
        }
    }
}


