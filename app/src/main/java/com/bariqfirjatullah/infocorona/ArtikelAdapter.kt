package com.bariqfirjatullah.infocorona

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.artikel_item.*

class ArtikelAdapter(private val context: Context, private val items: List<ArtikelItem>, private val listener:(ArtikelItem)->Unit): RecyclerView.Adapter<ArtikelAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.artikel_item,parent,false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder:ViewHolder, position: Int){
        holder.bindItem(items.get(position),listener)
    }

    class ViewHolder(val context: Context, override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: ArtikelItem, listener: (ArtikelItem)->Unit){
            txtJudul.text = item.judul
            txtContent.text = item.content
        }
    }
}