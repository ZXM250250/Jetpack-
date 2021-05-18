package com.dongnaoedu.navigation3;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class HomeFragment extends Fragment {


    private int notificationId;

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
            sendNotification();
        });
    }

    private void sendNotification() {
        //通知渠道
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(getActivity().getPackageName(),"MyChannel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("My NotificationChannel");
            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(getActivity(),getActivity().getPackageName())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Deep Link")
                .setContentText("点击我试试...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(getPendingItent())
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getActivity());
        notificationManagerCompat.notify(notificationId++,notification);
    }

    private PendingIntent getPendingItent() {
        Bundle args = new Bundle();
        args.putString("name","jack");
        return Navigation.findNavController(getActivity(),R.id.button)
                .createDeepLink()
                .setGraph(R.navigation.my_nav_graph)
                .setDestination(R.id.detailFragment)
                .setArguments(args)
                .createPendingIntent();
    }
}