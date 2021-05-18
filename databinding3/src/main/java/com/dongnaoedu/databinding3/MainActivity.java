package com.dongnaoedu.databinding3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.dongnaoedu.databinding3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        //activityMainBinding.setNetworkImage("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.gtimg.com%2Fent%2Fpics%2Fhv1%2F207%2F150%2F1605%2F104403582.jpg&refer=http%3A%2F%2Fimg1.gtimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1618055817&t=82b21a7c70f4af742601ecded168d371");
        activityMainBinding.setLocalImage(R.drawable.angelinajolie);
    }
}