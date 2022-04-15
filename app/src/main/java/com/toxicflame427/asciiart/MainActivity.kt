package com.toxicflame427.asciiart

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.toxicflame427.asciiart.databinding.ActivityMainBinding
import com.toxicflame427.asciiart.fragments.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var toggleDrawer : ActionBarDrawerToggle

    //Fragments
    private lateinit var lennyFragment : LennyFragment
    private lateinit var emotionalFragment : EmotionalFragment
    private lateinit var animalsFragment : AnimalsFragment
    private lateinit var itemsFragment : ItemsFragment
    private lateinit var miscFragment : MiscFragment
    private lateinit var largeArtFragment : LargeArtFragment
    private lateinit var creditsFragment : CreditsFragment

    private lateinit var fragmentTransaction : FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.drawerLayout)

        initAds()

        //Set up the original fragment to be displayed, and display it
        lennyFragment = LennyFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_frag_layout, lennyFragment)
            .commit()

        setupDrawer()
    }

    private fun initAds(){
        MobileAds.initialize(this)

        val adRequest = AdRequest.Builder().build()
        binding.mainAd.loadAd(adRequest)
    }

    private fun setupDrawer(){
        //Set the drawer to open when icon is clicked
        toggleDrawer = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.drawer_open, R.string.drawer_closed)
        binding.drawerLayout.addDrawerListener(toggleDrawer)
        toggleDrawer.syncState()

        //Attack the drawable to the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //AdD the listener to change the fragment when a menu item is clicked
        binding.drawer.setNavigationItemSelectedListener {
            binding.copyArtText.visibility = View.VISIBLE
            binding.mainAd.visibility = View.VISIBLE

            when(it.itemId){
                R.id.lenny_faces_menu -> {
                    lennyFragment = LennyFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_frag_layout, lennyFragment)
                        .commit()

                    //Close the drawer when done
                    binding.drawerLayout.closeDrawers()
                }
                R.id.emotional_menu -> {
                    emotionalFragment = EmotionalFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_frag_layout, emotionalFragment)
                        .commit()

                    //Close the drawer when done
                    binding.drawerLayout.closeDrawers()
                }
                R.id.animals_menu -> {
                    animalsFragment = AnimalsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_frag_layout, animalsFragment)
                        .commit()

                    //Close the drawer when done
                    binding.drawerLayout.closeDrawers()
                }
                R.id.items_menu -> {
                    itemsFragment = ItemsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_frag_layout, itemsFragment)
                        .commit()

                    //Close the drawer when done
                    binding.drawerLayout.closeDrawers()
                }
                R.id.large_art_menu -> {
                    //Hide the main ad, it takes up too much space on the fragment's view
                    binding.mainAd.visibility = View.GONE

                    largeArtFragment = LargeArtFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_frag_layout, largeArtFragment)
                        .commit()

                    //Close the drawer when done
                    binding.drawerLayout.closeDrawers()
                }
                R.id.misc_menu -> {
                    miscFragment = MiscFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_frag_layout, miscFragment)
                        .commit()

                    //Close the drawer when done
                    binding.drawerLayout.closeDrawers()
                }
                R.id.credits_menu -> {
                    binding.copyArtText.visibility = View.GONE

                    creditsFragment = CreditsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_frag_layout, creditsFragment)
                        .commit()

                    //Close the drawer when done
                    binding.drawerLayout.closeDrawers()
                }
                R.id.report_bug_menu -> {
                    //Ask the user to submit a bug report
                    val alertDialog = AlertDialog.Builder(this)
                        .setCancelable(false)
                        .setTitle(getString(R.string.bug_report_dialog_title))
                        .setMessage(getString(R.string.bug_report_dialog_desc))
                        .setPositiveButton("Yes"){ dialog, _ ->
                            dialog.dismiss()

                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toxicflame427.xyz/pages/bug_report.html"))
                            startActivity(intent)
                        }
                        .setNegativeButton("No thanks"){dialog, _ ->
                            dialog.dismiss()
                        }
                    alertDialog.show()
                }
                R.id.review_menu -> {
                    //Ask the user to submit a review
                    val alertDialog = AlertDialog.Builder(this)
                        .setCancelable(false)
                        .setTitle(getString(R.string.review_app_dialog_title))
                        .setMessage(getString(R.string.review_app_dialog_desc))
                        .setPositiveButton("Yes"){ dialog, _ ->
                            dialog.dismiss()

                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.toxicflame427.asciiart"))
                            startActivity(intent)
                        }
                        .setNegativeButton("No thanks"){dialog, _ ->
                            dialog.dismiss()
                        }
                    alertDialog.show()
                }
            }

            //Always return true to know the click had been handled
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggleDrawer.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
