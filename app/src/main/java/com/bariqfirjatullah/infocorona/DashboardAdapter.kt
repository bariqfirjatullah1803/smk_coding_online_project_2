package com.bariqfirjatullah.infocorona

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.dashboard_item.*

class DashboardAdapter(private val context: Context, private val items: List<IndonesiaDataItem>,private val listener:(IndonesiaDataItem)->Unit): RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.dashboard_item, parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position:Int){
        holder.bindItem(items.get(position),listener)
    }

    class ViewHolder(val context: Context, override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: IndonesiaDataItem, listener: (IndonesiaDataItem)->Unit){
            txtName.text = item.name
            txtPositif.text = item.positif
            txtMeninggal.text = item.meninggal
            txtSembuh.text = item.sembuh
        }
    }
}