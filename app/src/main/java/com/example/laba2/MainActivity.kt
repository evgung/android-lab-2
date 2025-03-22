package com.example.laba2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.laba2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val cards = arrayOf(
        Card(
            R.drawable.coliseum,
            R.string.coliseumName,
            R.string.coliseumWhere,
            R.string.coliseumDescription
        ),
        Card(
            R.drawable.eiffel_tower,
            R.string.eiffelName,
            R.string.eiffelWhere,
            R.string.eiffelDescription
        ),
        Card(
            R.drawable.kremlin,
            R.string.kremlinName,
            R.string.kremlinWhere,
            R.string.kremlinDescription
        ),
        Card(
            R.drawable.statue_of_liberty,
            R.string.libertyName,
            R.string.libertyWhere,
            R.string.libertyDescription
        ),
        Card(
            R.drawable.taj_mahal,
            R.string.tajMahalName,
            R.string.tajMahalWhere,
            R.string.tajMahalDescription
        ),
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("CURRENT_INDEX")
        }
        setCard(currentIndex)

        binding.btnBack.setOnClickListener {
            setCard(currentIndex - 1)
        }
        binding.btnNext.setOnClickListener {
            setCard(currentIndex + 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CURRENT_INDEX", currentIndex)
    }

    private fun setCard(index: Int) {
        val card = cards[index]
        currentIndex = index

        with(binding) {
            btnBack.isEnabled = (currentIndex > 0)
            btnNext.isEnabled = (currentIndex < cards.size - 1)

            ivImage.setImageResource(card.imageId)
            tvName.text = getString(card.nameId)
            tvWhere.text = getString(card.whereId)
            tvDescription.text = getString(card.descriptionId)
        }
    }
}