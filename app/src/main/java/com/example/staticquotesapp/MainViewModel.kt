package com.example.staticquotesapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val contex: Context) : ViewModel() {
    private var quoteList: Array<QuoteModel> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuoteFromAssests()
    }

    private fun loadQuoteFromAssests(): Array<QuoteModel> {
        val inputSystem = contex.assets.open("quotes.json")
        val size: Int = inputSystem.available()
        val buffer = ByteArray(size)
        inputSystem.read(buffer)
        inputSystem.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<QuoteModel>::class.java)
    }

    fun getQuote() = quoteList[index]

    fun nextQuote() = quoteList[++index]

    fun previousQuote() = quoteList[--index]

}
