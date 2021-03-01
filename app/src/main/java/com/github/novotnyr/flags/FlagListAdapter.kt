package com.github.novotnyr.flags

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable
import java.sql.SQLOutput

data class Flag(val country: String, val image: Int) : Serializable

// 1. ViewHolder: objekt, ktory "drzi" view
// 2. adapter

class FlagViewHolder(itemView: View, val clickListener: FlagClickListener) : RecyclerView.ViewHolder(itemView) {
    val countryTextView: TextView = itemView.findViewById(R.id.textView)
    val flagImageView: ImageView = itemView.findViewById(R.id.imageView)

    fun setFlag(flag: Flag) {
        // z objektu vlajky vytiahnem nazov krajiny a nastavim text v countryText
        countryTextView.text = flag.country
        countryTextView.setOnClickListener {
            clickListener.onFlagClick(flag)
        }
        // z objektu vlajky vytiahnem aj ilustraciu
        flagImageView.setImageResource(flag.image)
    }
}

class FlagListAdapter(val clickListener: FlagClickListener) : RecyclerView.Adapter<FlagViewHolder>() {
    val flags = listOf(
        Flag("Austria", R.drawable.austria),
        Flag("Croatia", R.drawable.croatia),
        Flag("Czech Republic", R.drawable.czech),
        Flag("Germany", R.drawable.germany),
        Flag("Hungary", R.drawable.hungary),
        Flag("Poland", R.drawable.poland),
        Flag("Romania", R.drawable.romania),
        Flag("Serbia", R.drawable.serbia),
        Flag("Slovakia", R.drawable.slovakia),
        Flag("Slovenia", R.drawable.slovenia),
        Flag("Ukraine", R.drawable.ukraine),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagViewHolder {
        /*
          1. [x] potrebujem vyrobit layout ("XML") vyzoru pre konkretnu polozku
          2. [x] potrebujeme parsovat XML na layout: inflating
          3. [x] prepojit layout polozky s viewholderom
          4. [x] Vyrobit instanciu ViewHoldera
         */
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.flag_list_item, parent, false)
        return FlagViewHolder(layout, clickListener)
    }

    override fun onBindViewHolder(holder: FlagViewHolder, position: Int) {
        val flag = flags.get(position)
        // prepojenie, resp. previazanie (bind) vlajky s viewholderom
        holder.setFlag(flag)
    }

    override fun getItemCount(): Int {
        return flags.size
    }


}