package com.ifs21014.dinopedia
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat

class DinoDetail : AppCompatActivity() {
    private var dinosaur: Dinosaur? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dino_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dinosaur = intent.getParcelableExtra(MainActivity.INTENT_PARCELABLE)

        val imgDino = findViewById<ImageView>(R.id.img_dino)
        val nameDino = findViewById<TextView>(R.id.dino_name)
        val descDino = findViewById<TextView>(R.id.dino_desc)
        val famDino = findViewById<TextView>(R.id.dino_fam)
        val charDino = findViewById<TextView>(R.id.dino_char)
        val groupDino = findViewById<TextView>(R.id.dino_group)
        val habitatDino = findViewById<TextView>(R.id.dino_habitat)
        val foodDino = findViewById<TextView>(R.id.dino_food)
        val sizeDino = findViewById<TextView>(R.id.dino_size)
        val weakDino = findViewById<TextView>(R.id.dino_weak)

        imgDino.setImageResource(dinosaur?.img!!)
        nameDino.text = dinosaur?.name
        descDino.text = dinosaur?.deskripsi
        famDino.text = dinosaur?.family
        charDino.text= dinosaur?.karakteristik
        groupDino.text= dinosaur?.group
        habitatDino.text=dinosaur?.habitat
        foodDino.text=dinosaur?.makanan
        sizeDino.text=dinosaur?.ukuran
        weakDino.text = dinosaur?.kelemahan

        val btnall = findViewById<Button>(R.id.buttonBack)
        btnall.setOnClickListener {
            val intent = Intent(this@DinoDetail, DinoActivity::class.java)
            startActivity(intent)
            finish() // Menutup aktivitas saat ini agar kembali ke MainActivity
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.dedi -> {
                shareContent()
                true
            }
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareContent() {
        val shareText = "Lihat: ${dinosaur?.name}\n\nDescription: ${dinosaur?.family}"
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setType("text/plain")
            .setText(shareText)
            .intent

        if (shareIntent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
