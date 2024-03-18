package com.ifs21014.dinopedia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat

class DetailActivity : AppCompatActivity() {
    private var destination: Destination? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        destination = intent.getParcelableExtra(MainActivity.INTENT_PARCELABLE)

        val imgDestination = findViewById<ImageView>(R.id.img_item_image)
        val nameDestination = findViewById<TextView>(R.id.tv_item_name)
        val descDestination = findViewById<TextView>(R.id.tv_item_desc)
        val locDestination = findViewById<TextView>(R.id.tv_item_loc)

        imgDestination.setImageResource(destination?.imgDestination!!)
        nameDestination.text = destination?.nameDestination
        descDestination.text = destination?.descDestination
        locDestination.text = destination?.locDestination
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                shareContent()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareContent() {
        val shareText = "Lihat: ${destination?.nameDestination}\n\nDescription: ${destination?.descDestination}"
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