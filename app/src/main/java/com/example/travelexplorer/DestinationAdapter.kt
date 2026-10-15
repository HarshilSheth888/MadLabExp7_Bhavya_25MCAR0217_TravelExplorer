
package com.example.travelexplorer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class DestinationAdapter(
    private val context: Context,
    private val destinations: List<Destination>
) : BaseAdapter() {

    override fun getCount(): Int = destinations.size

    override fun getItem(position: Int): Destination =
        destinations[position]

    override fun getItemId(position: Int): Long =
        position.toLong()

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_destination, parent, false)

        val destination = getItem(position)

        view.findViewById<ImageView>(R.id.destinationImage)
            .setImageResource(destination.imageResId)

        view.findViewById<TextView>(R.id.destinationNumber).text =
            "%02d / %s".format(
                position + 1,
                destination.country.uppercase()
            )

        view.findViewById<TextView>(R.id.destinationName).text =
            destination.name

        view.findViewById<TextView>(R.id.destinationDescription).text =
            destination.description

        return view
    }
}