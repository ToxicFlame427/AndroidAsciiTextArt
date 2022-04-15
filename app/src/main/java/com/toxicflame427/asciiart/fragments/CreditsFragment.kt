package com.toxicflame427.asciiart.fragments

import android.content.Context
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.toxicflame427.asciiart.R

class CreditsFragment : Fragment() {
    private lateinit var fragmentView : View
    private lateinit var activityContext : Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_credits, container, false)
        return fragmentView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textFacesLink = fragmentView.findViewById<TextView>(R.id.textfaces_link)
        textFacesLink.movementMethod = LinkMovementMethod.getInstance()

        val lennyFacesLink = fragmentView.findViewById<TextView>(R.id.lennyfaces_link)
        lennyFacesLink.movementMethod = LinkMovementMethod.getInstance()

        val twitchQuotesLink = fragmentView.findViewById<TextView>(R.id.twitch_quotes_link)
        twitchQuotesLink.movementMethod = LinkMovementMethod.getInstance()

        val askyLink = fragmentView.findViewById<TextView>(R.id.asky_link);
        askyLink.movementMethod = LinkMovementMethod.getInstance()
    }
}