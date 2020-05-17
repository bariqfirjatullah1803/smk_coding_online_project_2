package com.bariqfirjatullah.infocorona

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.about_item.*

class AboutAdapter(private val context: Context, private val items: List<BiodataItem>, private val listener:(BiodataItem)->Unit): RecyclerView.Adapter<AboutAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.about_item,parent,false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder:ViewHolder, position: Int){
        holder.bindItem(items.get(position),listener)
    }

    class ViewHolder(val context: Context, override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: BiodataItem, listener: (BiodataItem)->Unit){
            txtNama.text = item.nama
            txtJk.text = item.jk
            txtEmail.text = item.email
            txtUmur.text = item.umur
            txtTelepon.text = item.telp
            txtAlamat.text = item.alamat
        }
    }
}