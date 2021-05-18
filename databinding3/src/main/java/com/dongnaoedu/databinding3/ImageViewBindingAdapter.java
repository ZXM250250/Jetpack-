package com.dongnaoedu.databinding3;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class ImageViewBindingAdapter {

    //加载网络图片
    @BindingAdapter("image")
    public static void setImage(ImageView imageView, String url){
        if(!TextUtils.isEmpty(url)){
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }else{
            imageView.setBackgroundColor(Color.GRAY);
        }
    }

    //加载本地图片
    @BindingAdapter("image")
    public static void setImage(ImageView imageView, int resId){
        imageView.setImageResource(resId);
    }

    //参数可选，网络图片为空时，加载本地图片
    @BindingAdapter(value = {"image", "defaultImageResource"}, requireAll = false)
    public static void setImage(ImageView imageView, String url, int resId){
        if(!TextUtils.isEmpty(url)){
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }else{
            imageView.setImageResource(resId);
        }
    }

}
