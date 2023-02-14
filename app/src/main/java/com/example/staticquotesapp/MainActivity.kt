package com.example.staticquotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.staticquotesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(application)).get(MainViewModel::class.java)
        setQuote(mainViewModel.getQuote())
    }

    fun setQuote(quote:QuoteModel){
        binding.quotetext.text =  quote.text
        binding.quoteAuthor.text =  quote.author
    }

    fun onShare(view: View){
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,mainViewModel.getQuote().text)
        startActivity(intent)
    }
    fun onPrevious(view: View){
        setQuote(mainViewModel.previousQuote())
    }
    fun onNext(view: View){
        setQuote(mainViewModel.nextQuote())
    }
}