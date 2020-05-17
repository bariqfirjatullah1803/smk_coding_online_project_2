package com.bariqfirjatullah.infocorona

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val JUMLAH_MENU = 5

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> { return DashboardFragment() }
            1 -> { return ListFragment() }
            2 -> { return GlobalFragment() }
            3 -> { return ArtikelFragment() }
            4 -> { return AboutFragment() }
            else -> {
                return DashboardFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}