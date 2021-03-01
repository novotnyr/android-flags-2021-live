package com.github.novotnyr.flags

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), FlagClickListener {
    lateinit var flagRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flagRecyclerView = findViewById(R.id.flagRecyclerView)
        flagRecyclerView.layoutManager = LinearLayoutManager(this)
        flagRecyclerView.adapter = FlagListAdapter(this)

        // Prepojit aktivitu (hlavnu) ako posluchaca do adaptera
        // Dopravit posluchaca na klik do adaptera - adapter ho preposle do ViewHoldera
        // ViewHolder zoberie posluchaca a preposle ho do TextView
        // Pripravit a prepojit posluchaca na klik na konkretny textview
    }

    override fun onFlagClick(flag: Flag) {
        //Java:    Intent intent = new Intent(this, FlagActivity.class)
        val intent = Intent(this, FlagActivity::class.java)
        intent.putExtra("flag", flag)

        startActivity(intent)
    }
}