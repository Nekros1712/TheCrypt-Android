package com.example.thecrypt

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CryptsViewHolder(
    itemView: View,
    val coinName : TextView = itemView.findViewById(R.id.coin_name),
    val coinPrice : TextView = itemView.findViewById(R.id.coin_price),
    val coinGrowth : TextView = itemView.findViewById(R.id.coin_growth)
    ) : RecyclerView.ViewHolder(itemView) {}