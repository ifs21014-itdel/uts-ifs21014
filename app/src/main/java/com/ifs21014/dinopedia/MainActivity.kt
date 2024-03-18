package com.ifs21014.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val destinationNames = resources.getStringArray(R.array.destination_names)
        val destinationDescriptions = resources.getStringArray(R.array.destination_descriptions)
        val destinationImages = resources.getStringArray(R.array.destination_images)
        val destinationLocation = resources.getStringArray(R.array.destination_location)

        val destinationList = mutableListOf<Destination>()
        supportActionBar?.setTitle("Dino Pedia")

        for (i in destinationNames.indices) {
            destinationList.add(
                Destination(
                    resources.getIdentifier(destinationImages[i], "drawable", packageName),
                    destinationNames[i],
                    destinationDescriptions[i],
                    destinationLocation[i]
                )
            )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_destination)
        recyclerView.layoutManager = GridLayoutManager(this, 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position % 3 == 0) 2 else 1
                }
            }
        }
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = DestAdapter(this, destinationList) { destination ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, destination)
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
