package pinkwhale.com.headyassignment.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pinkwhale.com.headyassignment.Models.Categories;
import pinkwhale.com.headyassignment.R;

@SuppressLint("ValidFragment")
public class BottomSheetattachchatfile extends BottomSheetDialogFragment {
    @SuppressLint("ValidFragment")
    List<Categories.rankings> Ranking;

    public BottomSheetattachchatfile(ArrayList<Categories.rankings> rankings) {
        Ranking = rankings;
        // Required empty public constructor
    }

    @BindView(R.id.rv_ranking)
    RecyclerView _rv_ranking;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sort, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RankingRecyclerAdapter RecyclerAdapter = new RankingRecyclerAdapter(getContext(), Ranking);
        RecyclerAdapter.notifyDataSetChanged();
        _rv_ranking.setLayoutManager(linearLayoutManager);
        _rv_ranking.setAdapter(RecyclerAdapter);

        return view;

    }


}