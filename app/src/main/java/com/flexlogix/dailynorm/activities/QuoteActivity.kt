package com.flexlogix.dailynorm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flexlogix.dailynorm.R
import com.flexlogix.dailynorm.databinding.ActivityQuoteBinding
import kotlin.random.Random

class QuoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Populate quote to screen
        setQuote()
    }

    // populate random quote onto screen
    private fun setQuote() {
        val quotes = this.resources.getStringArray(R.array.NormQuotes)
        val index = Random.nextInt(0, quotes.size)
        binding.quoteText.text = quotes[index]
    }
}