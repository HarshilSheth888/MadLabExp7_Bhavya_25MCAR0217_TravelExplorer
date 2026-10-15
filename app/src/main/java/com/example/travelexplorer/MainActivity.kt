
package com.example.travelexplorer

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val destinations = listOf(
        Destination(
            "Cinque Terre",
            "Italy",
            "Colourful coastal villages overlooking the Mediterranean Sea.",
            R.drawable.cinque_terre
        ),
        Destination(
            "Kyoto",
            "Japan",
            "Traditional streets, quiet temples and Japanese culture.",
            R.drawable.kyoto
        ),
        Destination(
            "Lauterbrunnen",
            "Switzerland",
            "A peaceful alpine valley surrounded by waterfalls and mountains.",
            R.drawable.lauterbrunnen
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.destinationList)
        listView.adapter = DestinationAdapter(this, destinations)

        listView.setOnItemClickListener { _, _, position, _ ->
            val destination = destinations[position]

            val intent = Intent(
                this,
                DestinationDetailActivity::class.java
            ).apply {
                putExtra("destination_name", destination.name)
                putExtra("destination_country", destination.country)
                putExtra("destination_description", destination.description)
                putExtra("destination_image", destination.imageResId)
            }

            startActivity(intent)
        }
    }
}