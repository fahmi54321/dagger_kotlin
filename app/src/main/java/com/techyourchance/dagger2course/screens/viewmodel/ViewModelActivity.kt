package com.techyourchance.dagger2course.screens.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggertwo.R
import com.example.daggertwo.screens.common.ScreensNavigator
import com.example.daggertwo.screens.common.activities.BaseActivity
import com.example.daggertwo.screens.common.toolbar.MyToolbar
import javax.inject.Inject

class ViewModelActivity : BaseActivity() {

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    private lateinit var toolbar: MyToolbar

    @Inject
    lateinit var myViewModelFactory: MyViewModel.MyViewModelFactory

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            screensNavigator.navigateBack()
        }

        viewModel = ViewModelProvider(this, myViewModelFactory).get(MyViewModel::class.java)

        viewModel.question.observe(this, Observer {question->
            Toast.makeText(this,"fetched ${question.size}",Toast.LENGTH_SHORT).show()
        })
    }

    companion object{
        fun start(context: Context){
            val intent = Intent(context, ViewModelActivity::class.java)
            context.startActivity(intent)
        }
    }
}