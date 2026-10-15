
package com.example.travelexplorer

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DestinationDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination_detail)

        val name = intent.getStringExtra("destination_name") ?: "Destination"
        val country = intent.getStringExtra("destination_country") ?: ""
        val description = intent.getStringExtra("destination_description") ?: ""
        val imageRes = intent.getIntExtra(
            "destination_image",
            0
        )

        findViewById<TextView>(R.id.detailName).text = name
        findViewById<TextView>(R.id.detailCountry).text =
            country.uppercase()
        findViewById<TextView>(R.id.detailDescription).text = description

        if (imageRes != 0) {
            findViewById<ImageView>(R.id.detailImage)
                .setImageResource(imageRes)
        }

        findViewById<TextView>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}