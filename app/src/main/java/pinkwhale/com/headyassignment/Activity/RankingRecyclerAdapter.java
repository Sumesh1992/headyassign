package pinkwhale.com.headyassignment.Activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.List;

import pinkwhale.com.headyassignment.Models.Categories;
import pinkwhale.com.headyassignment.R;

public class RankingRecyclerAdapter extends RecyclerView.Adapter<RankingRecyclerAdapter.RankingViewHolder> {

    private List<Categories.rankings> listRanking;
    private Context context;
    int mCheckedPostion = 0;


    public RankingRecyclerAdapter(Context context, List<Categories.rankings> listOfferProducts) {
        this.listRanking = listOfferProducts;
        this.context = context;
    }

    @Override
    public RankingRecyclerAdapter.RankingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_item_list, parent, false);
        RankingRecyclerAdapter.RankingViewHolder categoriesViewHolder = new RankingRecyclerAdapter.RankingViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(RankingRecyclerAdapter.RankingViewHolder categoriesViewHolder, int position) {
        Categories.rankings rankings = listRanking.get(position);

        if (rankings != null) {
            categoriesViewHolder._rb_ranking.setText(rankings.ranking);
            // new AQuery(context).id(offersViewHolder.ivOfferImage).image("http://2.bp.blogspot.com/-g_wISt88yf8/VhY829TLyVI/AAAAAAAAAaA/kZHbLX8DRyk/s1600/1.jpg");
        }


        setOnClickListeners(categoriesViewHolder, position);

    }

    @Override
    public int getItemCount() {
        return listRanking.size();
    }

    private void setOnClickListeners(final RankingRecyclerAdapter.RankingViewHolder categoriesViewHolder, final int position) {
        categoriesViewHolder._rb_ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RankingRecyclerAdapter.this.notifyDataSetChanged();
//                mCheckedPostion = position;
                MainActivity.bottomSheetFragment.dismiss();
                //((MainActivity) context).getProducts(products);
            }
        });
    }

    public static class RankingViewHolder extends RecyclerView.ViewHolder {
        RadioButton _rb_ranking;

        RankingViewHolder(View view) {
            super(view);
            _rb_ranking = (RadioButton) view.findViewById(R.id.rb_ranking);
        }
    }
}

