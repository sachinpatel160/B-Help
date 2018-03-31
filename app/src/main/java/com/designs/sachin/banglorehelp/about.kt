package com.designs.sachin.banglorehelp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class about : AppCompatActivity() {

    internal lateinit var feedback: Button
    internal lateinit var sachindec: TextView
    var istextclickable: Boolean = false
    val to = "sachinpatel160@gmail.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        feedback = findViewById(R.id.feedbackbtn) as Button
        sachindec = findViewById(R.id.sachin_desc) as TextView

        sachindec.setOnClickListener(View.OnClickListener {
            if (istextclickable) {
                //This will shrink textview to 5 lines if it is expanded.
                sachindec.maxLines = 5
                istextclickable = false;
            } else {
                //This will expand the textview if it is of 5 lines
                sachindec.setMaxLines(Integer.MAX_VALUE);
                istextclickable = true;
            }
        })

        feedback.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setData(Uri.parse("mailto:"))
            val addressees = arrayOf(to)
            intent.putExtra(Intent.EXTRA_EMAIL, addressees)
            intent.putExtra(Intent.EXTRA_SUBJECT, "I want to say this feedback/suggetion")
            intent.putExtra(Intent.EXTRA_TEXT, "Dear admin")
            intent.setType("message/rfc822")
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(intent, "Send this Email using:"))
            }
        })
    }
    fun sjpmailclicked(view : View){
        val intent = Intent(Intent.ACTION_SEND)
        intent.setData(Uri.parse("mailto:"))
        val addressees = arrayOf(to)
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.putExtra(Intent.EXTRA_SUBJECT, "I would like to talk about ...")
        intent.putExtra(Intent.EXTRA_TEXT, "Dear sachin,")
        intent.setType("message/rfc822")
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Send this Email using:"));
        }
    }
}

