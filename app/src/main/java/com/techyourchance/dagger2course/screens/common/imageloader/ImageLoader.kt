package com.techyourchance.dagger2course.screens.common.imageloader

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.daggertwo.common.dependencyinjection.activity.ActivityScope
import javax.inject.Inject

@ActivityScope
class ImageLoader @Inject constructor(val activity: AppCompatActivity) {
    fun showImage(url: String, image: ImageView) {
        Glide
            .with(activity)
            .load(url)
            .centerCrop()
            .into(image);
    }
}