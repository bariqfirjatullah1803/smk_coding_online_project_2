package com.bariqfirjatullah.infocorona

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.*

class ListAdapter(private val context: Context, private val items: List<ProvinsiIndonesiaDataItem>, private val listener:(ProvinsiIndonesiaDataItem)->Unit): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder:ViewHolder, position: Int){
        holder.bindItem(items.get(position),listener)
    }

    class ViewHolder(val context: Context, override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: ProvinsiIndonesiaDataItem, listener: (ProvinsiIndonesiaDataItem)->Unit){
            txtProvinsi.text = item.attributes.provinsi
            txtMeninggal.text = item.attributes.kasusMeni.toString()
            txtPositif.text = item.attributes.kasusPosi.toString()
            txtSembuh.text = item.attributes.kasusSemb.toString()

        }
    }
}