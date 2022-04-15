package com.toxicflame427.asciiart.recyclers

import android.content.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.toxicflame427.asciiart.R
import com.toxicflame427.asciiart.classes.AsciiData

class LennyRecycler : RecyclerView.Adapter<LennyRecycler.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.ascii_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.asciiText.text = AsciiData.lenny[position]
    }

    override fun getItemCount(): Int {
        return AsciiData.lenny.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var asciiText: TextView = itemView.findViewById(R.id.ascii_text)

        init {
            itemView.setOnClickListener {
                val clipboardManager =
                    itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip: ClipData = ClipData.newPlainText(asciiText.text, asciiText.text)
                clipboardManager.setPrimaryClip(clip)

                //Notify that the text had been copied
                Toast.makeText(itemView.context, "Text Copied to clipboard", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
