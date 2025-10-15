package com.example.daggertwo.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.daggertwo.R
import com.example.daggertwo.screens.common.activities.BaseActivity

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