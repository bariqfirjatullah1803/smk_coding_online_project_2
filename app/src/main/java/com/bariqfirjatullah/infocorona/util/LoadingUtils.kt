package com.bariqfirjatullah.infocorona.util

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bariqfirjatullah.infocorona.R

fun showLoading(context: Context,swipeRefreshLayout: SwipeRefreshLayout){
    swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(context, R.color.colorPrimary))

    swipeRefreshLayout.isEnabled = true
    swipeRefreshLayout.isRefreshing = true
}

fun dismissLoading(swipeRefreshLayout: SwipeRefreshLayout){
    swipeRefreshLayout.isRefreshing = false
    swipeRefreshLayout.isEnabled = false
}
class LoadingUtils {
}