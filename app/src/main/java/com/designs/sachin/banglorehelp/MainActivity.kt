package com.designs.sachin.banglorehelp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import com.designs.sachin.banglorehelp.R.id.progressBar
import android.graphics.Bitmap
import android.widget.ProgressBar


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var mywebview: WebView? = null
    lateinit var progressbar : ProgressBar
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        progressbar = findViewById(R.id.progressBar)
        mywebview = findViewById<WebView>(R.id.mainContent)
        mywebview!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                progressbar.visibility = View.VISIBLE
                view?.loadUrl(url)
                return true
            }
            override fun onPageFinished(view: WebView?, url: String?) {

                super.onPageFinished(view, url)
                progressbar.visibility = View.GONE
            }
        }
        val webSettings = mywebview!!.settings
        webSettings.javaScriptEnabled = true
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        WebView.setWebContentsDebuggingEnabled(false)
        mywebview!!.loadUrl("https://www.google.com")

        btnprev.setOnClickListener {
            if (mywebview!!.canGoBack()){
                mywebview!!.goBack()
            }
            else
                btnprev.isClickable = false
        }
        btnnext.setOnClickListener {
            if (mywebview!!.canGoForward()){
                mywebview!!.goForward()
            }
            else
                btnnext.isClickable = false
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_about ->{
                val intent = Intent(this,about::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
//            Travel
            R.id.traininside -> {
                mywebview!!.loadUrl("https://theplanetd.com/train-travel-india-navigating-indian-railways/")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.trainoutside -> {
                mywebview!!.loadUrl("https://www.tripsavvy.com/indian-railways-train-tips-1539642")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.cab -> {
                mywebview!!.loadUrl("https://m.uber.com/looking")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.bus -> {
                mywebview!!.loadUrl("http://mybmtc.com/mobile/")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.areasinbangalore -> {
                mywebview!!.loadUrl("http://www.propertykhazana.com/localities/bangalore")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
//            Food and Health
            R.id.healthyfoodlist -> {
                mywebview!!.loadUrl("https://www.bbcgoodfood.com/howto/guide/balanced-diet-vegetarian")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.summerfoodlist -> {
                mywebview!!.loadUrl("https://www.thekitchn.com/50-summer-vegetable-dishes-to-make-in-20-minutes-232847")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.exercise -> {
                mywebview!!.loadUrl("https://www.mensfitness.com/training/workout-routines/3-empty-stomach-workouts-aggressively-start-your-morning")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.yoga -> {
                mywebview!!.loadUrl("https://www.mensfitness.com/training/workout-routines/best-weight-loss-yoga-workout-men")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.meditation -> {
                mywebview!!.loadUrl("https://www.youtube.com/watch?v=WYP_W49o1vQ")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.books -> {
                mywebview!!.loadUrl("")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
//            work
            R.id.officepolitics -> {
                mywebview!!.loadUrl("https://www.wikihow.com/Avoid-Back-Office-Politics")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.interview -> {
                mywebview!!.loadUrl("http://www.careerizma.com/blog/10-common-interview-questions-answers-freshers/")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.gdandaptitude -> {
                mywebview!!.loadUrl("http://placement.freshersworld.com/")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.designpatterns -> {
                mywebview!!.loadUrl("https://dev.to/lovis/gang-of-four-patterns-in-kotlin")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.javaandkotlin -> {
                mywebview!!.loadUrl("http://developine.com/top-kotlin-interview-questions-answers/")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.interviewquestion -> {
                mywebview!!.loadUrl("https://www.edureka.co/blog/interview-questions/top-5-android-interview-questions-for-freshers/")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.commonandroidiq -> {
                mywebview!!.loadUrl("https://blendinfotech.com/android-interview-questions-and-answers-for-Fresher")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.gossipsandetiquests -> {
                mywebview!!.loadUrl("https://www.thebalance.com/top-job-interview-etiquette-tips-2061360")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.english -> {
                mywebview!!.loadUrl("http://www.dummies.com/education/language-arts/grammar/incomplete-comparisons-english-grammar/")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.kannada -> {
                mywebview!!.loadUrl("http://basickannada.blogspot.in/2011/04/useful-words-in-different-languages.html")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
//            living
            R.id.timetablebase -> {
                mywebview!!.loadUrl("https://www.goodreads.com/quotes/tag/corporate")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.addressandcontactnumber -> {
                mywebview!!.loadUrl("")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.notices -> {
                mywebview!!.loadUrl("")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.extratimetosuffer -> {
                mywebview!!.loadUrl("")
                drawer_layout.closeDrawer(GravityCompat.START)
                return true
            }
        }


        return true
        drawer_layout.closeDrawer(GravityCompat.START)
    }
}
