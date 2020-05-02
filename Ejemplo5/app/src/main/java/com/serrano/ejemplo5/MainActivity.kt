package com.serrano.ejemplo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var mSearchPokemonEditText : EditText
    lateinit var mSendButton : Button
    lateinit var mDisplayPokemonTextView : TextView
    val DISPLAY_POKEMON_KEY = "DisplayNamePokemon"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()

        if(savedInstanceState != null){
            var searchPokemon: String? = savedInstanceState.getString(DISPLAY_POKEMON_KEY)
            mDisplayPokemonTextView.text = searchPokemon
        }

        mSendButton.setOnClickListener{
           var searchPokemon: String = mSearchPokemonEditText.text.toString()
            mDisplayPokemonTextView.text = searchPokemon
        }
    }


    fun bindView(){
        mSearchPokemonEditText = findViewById(R.id.et_pokemon_name)
        mSendButton = findViewById(R.id.bn_action_send)
        mDisplayPokemonTextView = findViewById(R.id.tv_display_pokemon)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(DISPLAY_POKEMON_KEY, mDisplayPokemonTextView.text.toString())
        Log.d(this::class.qualifiedName, "Guardando estado")
    }
}
