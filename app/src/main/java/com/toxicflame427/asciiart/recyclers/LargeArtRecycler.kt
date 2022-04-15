package com.toxicflame427.asciiart.recyclers

import android.annotation.SuppressLint
import android.content.*
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.toxicflame427.asciiart.R
import com.toxicflame427.asciiart.classes.AsciiData

class LargeArtRecycler(val fragment : Fragment) : RecyclerView.Adapter<LargeArtRecycler.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.ascii_card, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.asciiText.text = AsciiData.large[position]
    }

    override fun getItemCount(): Int {
        return AsciiData.large.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var asciiText: TextView = itemView.findViewById(R.id.ascii_text)

        init {
            //Manually set the text size to be smaller as this art will be VERY LARGE
            asciiText.textSize = 10f
            asciiText.setTypeface(null, Typeface.BOLD)

            //Change to darker colors, this make larger art more visible
            asciiText.setTextColor(Color.WHITE)
            itemView.findViewById<LinearLayout>(R.id.ascii_card).setBackgroundColor(Color.BLACK)

            itemView.setOnClickListener {
                val clipboardManager =
                    itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip: ClipData = ClipData.newPlainText(asciiText.text, asciiText.text)
                clipboardManager.setPrimaryClip(clip)

                //Notify that the text had been copied
                Toast.makeText(itemView.context, "Text Copied to clipboard", Toast.LENGTH_SHORT).show()
            }
        }
    }
}