package dev.wizrad.helloandroid.views

import dev.wizrad.helloandroid.R
import dev.wizrad.helloandroid.services.RiotServices
import dev.wizrad.helloandroid.services.SummonerService
import dev.wizrad.helloandroid.services.utilities.UrlComponents

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

public class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val leagueService = RiotServices.create(SummonerService::class.java)
        leagueService
            .fetchSummonersByName("na", UrlComponents("derkis", "fartbutt"))
            .subscribe(
                { summoners -> Log.d("test", "$summoners") },
                { error     -> Log.e("test", "$error") }
            )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
