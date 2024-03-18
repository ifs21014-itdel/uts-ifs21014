package com.ifs21014.dinopedia

import android.os.Bundle
import android.widget.TextView
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set title for ActionBar
        supportActionBar?.setTitle("About")
        // Enable back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setContentView(R.layout.activity_about)

        val name = "Dedi Panggabean"
        val email = "dediandree22@gmail.com"

        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvEmail = findViewById<TextView>(R.id.tv_email)

        tvName.text = name
        tvEmail.text = email
    }

    // Override onOptionsItemSelected to handle back button functionality
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
