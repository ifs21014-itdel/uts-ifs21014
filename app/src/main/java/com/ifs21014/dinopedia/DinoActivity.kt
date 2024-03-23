package com.ifs21014.dinopedia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DinoActivity : AppCompatActivity() {
    companion object {
        const val INTENT_FAMILY = "INTENT_FAMILY"
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dino)

        val dinosaurNames = resources.getStringArray(R.array.dinosaur_names)
        val dinosaurDescriptions = resources.getStringArray(R.array.dinosaur_description)
        val dinosaurImages = resources.getStringArray(R.array.dino_photo)
        val dinosaurFamilies = resources.getStringArray(R.array.dinosaur_families)
        val dinosaurChar = resources.getStringArray(R.array.dinosaur_characteristics)
        val dinoGrups = resources.getStringArray(R.array.dinosaur_groups)
        val dinoHabitats = resources.getStringArray(R.array.dinosaur_habitats)
        val dinoFoods = resources.getStringArray(R.array.dinosaur_food)
        val dinoSize = resources.getStringArray(R.array.dinosaur_dimensions)
        val dinoWeaks = resources.getStringArray(R.array.dinosaur_weaknesses)

        val intentFamily = intent.getStringExtra(INTENT_FAMILY)

        val dinosaurList = mutableListOf<Dinosaur>()
        supportActionBar?.setTitle("Dino Pedia")

        for (i in dinosaurNames.indices) {
            if (intentFamily == null || dinosaurFamilies[i] == intentFamily) {
                dinosaurList.add(
                    Dinosaur(
                        dinosaurNames[i],
                        resources.getIdentifier(dinosaurImages[i], "drawable", packageName),
                        dinosaurFamilies[i],
                        dinosaurDescriptions[i],
                        dinosaurChar[i],
                        dinoGrups[i],
                        dinoHabitats[i],
                        dinoFoods[i],
                        dinoSize[i],
                        dinoWeaks[i]
                    )
                )
            }
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_dinosaur)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = DinoAdapter(this, dinosaurList) {
            val intent = Intent(this, DinoDetail::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}
