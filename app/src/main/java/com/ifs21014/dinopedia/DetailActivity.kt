// DetailActivity.kt
package com.ifs21014.dinopedia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private var destination: Family? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        destination = intent.getParcelableExtra(MainActivity.INTENT_PARCELABLE)

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

        imgfamily.setImageResource(destination?.imgDestination!!)
        namefamily.text = destination?.nameDestination
        descfamily.text = destination?.descDestination
        locDestination.text = destination?.locDestination
        habitat.text = destination?.habitat
        fam.text = destination?.familyDestination
        makanan.text = destination?.makanan
        size.text = destination?.ukuran
        panjang.text = destination?.panjang
        weak.text = destination?.weak


        val btnDino = findViewById<Button>(R.id.buttonSemua);
        btnDino.setOnClickListener {
            val intent = Intent(this, DinoActivity::class.java)
            intent.putExtra(DinoActivity.INTENT_FAMILY, destination?.familyDestination)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
