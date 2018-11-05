package com.cardrecyclersample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fbActionButton.setOnClickListener {
            Snackbar.make(main_layout,"In Progress",Snackbar.LENGTH_LONG).show()
        }

        // load fragment
        val fragment = supportFragmentManager.findFragmentById(R.id.contentFrame)
            as MainFragment? ?: MainFragment.newInstance().also {
                replaceFragmentActivity(it,R.id.contentFrame)
            }
    }
}
