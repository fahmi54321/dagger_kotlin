package com.example.daggertwo.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.daggertwo.Constants
import com.example.daggertwo.MyApplication
import com.example.daggertwo.R
import com.example.daggertwo.networking.StackoverflowApi
import com.example.daggertwo.questions.FetchQuestionDetailsUseCase
import com.example.daggertwo.screens.common.ScreensNavigator
import com.example.daggertwo.screens.common.activities.BaseActivity
import com.example.daggertwo.screens.common.dialogs.DialogsNavigator
import com.example.daggertwo.screens.common.dialogs.ServerErrorDialogFragment
import com.example.daggertwo.screens.common.toolbar.MyToolbar
import com.example.daggertwo.screens.questionslist.QuestionsListFragment
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_frame)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_content, QuestionDetailsFragment())
                .commit()
        }
    }

    companion object {
        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"
        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }
}