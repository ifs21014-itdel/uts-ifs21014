package com.ifs21014.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object{
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val destinationNames = resources.getStringArray(R.array.family_names)
        val destinationDescriptions = resources.getStringArray(R.array.destination_descriptions)
        val destinationImages = resources.getStringArray(R.array.family_images)
        val destinationLocation = resources.getStringArray(R.array.characteristic)
        val destinationFamilies = resources.getStringArray(R.array.families)
        val habitat = resources.getStringArray(R.array.habitat)
        val makanan = resources.getStringArray(R.array.food)
        val ukuran = resources.getStringArray(R.array.length)
        val panjang = resources.getStringArray(R.array.height)
        val kelemahan = resources.getStringArray(R.array.weakness)

        val destinationList = mutableListOf<Family>()
        supportActionBar?.title = "Dino Pedia"

        for (i in destinationNames.indices) {
            destinationList.add(
                Family(
                    resources.getIdentifier(destinationImages[i], "drawable", packageName),
                    destinationNames[i],
                    destinationDescriptions[i],
                    destinationLocation[i],
                    destinationFamilies[i],
                    habitat[i],
                    makanan[i],
                    ukuran[i],
                    panjang[i],
                    kelemahan[i]


                )
            )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_destination)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = FamAdapter(this, destinationList){
            val intent = Intent (this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
