package com.dongnaoedu.navigation;

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
        /*Bundle args = getArguments();
        String userName = args.getString("user_name");*/
        //Log.d("ning","userName:"+userName);

        HomeFragmentArgs args = HomeFragmentArgs.fromBundle(getArguments());
        String userName = args.getUserName();
        int age = args.getAge();
        Log.d("ning",userName+","+age);

        button.setOnClickListener((v)->{
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_detailFragment_to_homeFragment);
        });
    }
}