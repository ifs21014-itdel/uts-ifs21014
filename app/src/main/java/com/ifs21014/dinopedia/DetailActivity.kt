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

class DetailActivity : AppCompatActivity() {
    private var family: Family? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        family = intent.getParcelableExtra(MainActivity.INTENT_PARCELABLE)

        val imgfamily = findViewById<ImageView>(R.id.img_family)
        val namefamily = findViewById<TextView>(R.id.family_name)
        val descfamily = findViewById<TextView>(R.id.family_desc)
        val locDestination = findViewById<TextView>(R.id.family_char)
        val habitat = findViewById<TextView>(R.id.family_habitat)
        val fam = findViewById<TextView>(R.id.family_fam)
        val makanan = findViewById<TextView>(R.id.family_food)
        val size = findViewById<TextView>(R.id.family_size)
        val panjang = findViewById<TextView>(R.id.family_group)
        val weak = findViewById<TextView>(R.id.family_weak)

        imgfamily.setImageResource(family?.imgDestination!!)
        namefamily.text = family?.nameDestination
        descfamily.text = family?.descDestination
        locDestination.text = family?.locDestination
        habitat.text = family?.habitat
        fam.text = family?.familyDestination
        makanan.text = family?.makanan
        size.text = family?.ukuran
        panjang.text = family?.panjang
        weak.text = family?.weak


        val btnDino = findViewById<Button>(R.id.buttonSemua);
        btnDino.setOnClickListener {
            val intent = Intent(this, DinoActivity::class.java)
            intent.putExtra(DinoActivity.INTENT_FAMILY, family?.familyDestination)
            startActivity(intent)
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
        val shareText = "Lihat: ${family?.nameDestination}\n\nDescription: ${family?.familyDestination}"
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
