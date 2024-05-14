package com.example.soulscript

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.soulscript.Adapter.QuotesListAdapter
import com.example.soulscript.Moden_class.Qoutes_moden
import com.example.soulscript.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {


    val quotes = arrayOf(
        "A smile is happiness you'll find right under your nose...",
        "Because of your smile, you make life more beautiful...",
        "A smile is the best makeup any girl can wear...",
        "I am not getting better but at" + "Least I haven’t killed myself...",
        "“I’m constantly in awe of the work ethic of the human heart It keeps beating though it’s broken...”",
        "“But love has a way of revealing itself in the most explicit manner...",
        "Peril, loneliness, an uncertain future, are not oppressive...",
        "Music was my refuge. I could crawl into the space between...",
        "All I ever wanted was to reach out and touch another human being...",
        "I would rather sit on a pumpkin and have it all to myself, than be...",
        "I wish I could show you when you are lonely or in darkness...",
        "To live is the rarest thing in the world. Most people exist, that is all...",
        "That it will never come again is what makes life so sweet...",
        "Be kind, for everyone you meet is fighting a hard battle...",
        "Love is patient, love is kind. It does not envy, it does not boast...",
        "Have enough courage to trust love one more time and always one more time...",
        "A happy person is not a person in a certain set of circumstances...",
        "Anger is always more harmful than the insult that caused it...",
        "A fool gives full vent to his anger, but a wise man keeps himself under control...",
        "We can shoot rockets into space but we can’t cure anger or discontent...",
        "Read, read, read. Read everything – trash, classics, good and bad...",
        "A good writer possesses not only his own spirit but also...",
        " Anger makes you smaller, while forgiveness forces you to grow beyond what you were...",
    )

    lateinit var binding: ActivityMainBinding
    val quotesList = ArrayList<Qoutes_moden>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in quotes.indices) {
            val quote = Qoutes_moden(quotes[i])
            quotesList.add(quote)
        }

        val quotesListAdapter =
            QuotesListAdapter(this, quotesList) // Note the corrected adapter name
        val layoutManager = GridLayoutManager(this, 1)
        binding.risi1.adapter = quotesListAdapter
        binding.risi1.layoutManager = layoutManager


        var imgMenu = findViewById<ImageView>(R.id.imgMenu)
        var drawerlayout = findViewById<DrawerLayout>(R.id.drawerlayout)
        var navigationDrawer = findViewById<NavigationView>(R.id.navigationDrawer)
        imgMenu.setOnClickListener {

            drawerlayout.openDrawer(Gravity.START)

            navigationDrawer.setNavigationItemSelectedListener {
                when (it.itemId) {

                    R.id.mHome -> {
                        drawerlayout.closeDrawer(Gravity.START)
                        true
                    }

                    R.id.mSettings -> {
                        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.mCall -> {
                        Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.mGroup -> {
                        Toast.makeText(this, "Group", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
        }

    }


}

