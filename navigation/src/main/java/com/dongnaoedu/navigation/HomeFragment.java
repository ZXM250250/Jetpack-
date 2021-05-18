package com.dongnaoedu.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = getView().findViewById(R.id.button);
        button.setOnClickListener((v)->{
            /*Bundle args = new Bundle();
            args.putString("user_name","jack");*/
            Bundle args = new HomeFragmentArgs.Builder()
                    .setUserName("rose")
                    .setAge(18)
                    .build().toBundle();
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_homeFragment_to_detailFragment,args);
        });
    }
}