package com.dongnaoedu.navigation3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = getView().findViewById(R.id.button2);

        Bundle args = getArguments();
        if(args != null){
            String name = args.getString("name");
            if(name != null){
                Log.d("ning",name);
            }
            String params = args.getString("params");
            if(params != null){
                Log.d("ning",params);
            }
        }

        button.setOnClickListener((v)->{
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_detailFragment_to_homeFragment);
        });
    }
}