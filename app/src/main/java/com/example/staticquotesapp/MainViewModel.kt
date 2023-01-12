package com.example.staticquotesapp

import android.content.Context
import androidx.lifecycle.ViewModel

class MainViewModel(val contex: Context) : ViewModel() {
    private val quoteList: Array<QuoteModel> = emptyArray()
    private val index = 0

    init {
        quoteList = loadQuoteFromAssests()
    }

    private fun loadQuoteFromAssests(): Array<QuoteModel> {
        val inputSystem = contex.assets.open("quotes.json")
        val size: Int = inputSystem.available()
        val buffer = ByteArray(size)
        inputSystem.read(buffer)
        inputSystem.close()
    }
}
