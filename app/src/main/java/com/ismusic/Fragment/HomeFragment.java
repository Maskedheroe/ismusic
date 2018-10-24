package com.ismusic.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ismusic.Activity.MainActivity;
import com.ismusic.Adapter.GedanAdapter;
import com.ismusic.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View view;
    private RecyclerView gedanListView;

    private List<Integer> list =new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,null,false);
        gedanListView=view.findViewById(R.id.list_gedan);
        addList();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        gedanListView.setLayoutManager(layoutManager);
        GedanAdapter adapter = new GedanAdapter(list);
        gedanListView.setAdapter(adapter);
        return view;
    }

    private void addList(){
        for (int i=0;i<20;i++){
            list.add(i);
        }
    }
}
