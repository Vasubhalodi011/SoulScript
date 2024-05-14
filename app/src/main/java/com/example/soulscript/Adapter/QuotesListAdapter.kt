package com.example.soulscript.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soulscript.Moden_class.Qoutes_moden
import com.example.soulscript.R

class QuotesListAdapter(val context: Context, val quotesList: ArrayList<Qoutes_moden>) :
    RecyclerView.Adapter<QuotesListAdapter.QuotesHolder>() {

    class QuotesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var quotesText: TextView = itemView.findViewById(R.id.Quotestext)
        var quotes_copy: ImageView = itemView.findViewById(R.id.quotes_copy)
        var quotes_share: ImageView = itemView.findViewById(R.id.quotes_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.qoutes_list, parent, false)
        return QuotesHolder(view)
    }

    override fun onBindViewHolder(holder: QuotesHolder, position: Int) {
        holder.quotesText.text = quotesList[position].quotes
        holder.quotes_copy.setImageResource(R.drawable.copy)
        holder.quotes_share.setImageResource(R.drawable.share)

        holder.quotes_share.setOnClickListener {
            val quoteText = quotesList[position].quotes

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, quoteText)
            holder.itemView.context.startActivity(Intent.createChooser(shareIntent, "Share using"))
        }
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }
}
