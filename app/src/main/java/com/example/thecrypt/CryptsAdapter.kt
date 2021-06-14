package com.example.thecrypt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback

class CryptsAdapter(
    private val context: Context,
    private val totalData: List<Coins>?
    ) : RecyclerView.Adapter<CryptsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptsViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.coin_item, parent, false)
        return CryptsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptsViewHolder, position: Int) {
        val name = totalData!![position].name
        val price = totalData[position].market_data.current_price.usd.toString()
        holder.coinName.text = name.substring(startIndex = 0, endIndex = if(name.length > 8) 8 else name.length)
        holder.coinPrice.text = price.substring(startIndex = 0, endIndex = if(price.length > 8) 8 else price.length)
    }

    override fun getItemCount(): Int {
        return totalData!!.size
    }
}