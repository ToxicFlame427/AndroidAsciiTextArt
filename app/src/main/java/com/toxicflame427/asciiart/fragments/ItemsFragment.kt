package com.toxicflame427.asciiart.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.toxicflame427.asciiart.R
import com.toxicflame427.asciiart.recyclers.ItemsRecycler

class ItemsFragment : Fragment() {
    private lateinit var fragmentView : View
    private lateinit var activityContext : Context

    private var adapterLennyFace : RecyclerView.Adapter<ItemsRecycler.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_items, container, false)
        return fragmentView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = fragmentView.findViewById<RecyclerView>(R.id.ascii_list_items)

        recyclerView.layoutManager = GridLayoutManager(activityContext, 2)

        adapterLennyFace = ItemsRecycler()
        recyclerView.adapter = adapterLennyFace
    }
}