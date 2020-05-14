package com.bariqfirjatullah.infocorona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.bariqfirjatullah.infocorona.data.apiRequest
import com.bariqfirjatullah.infocorona.data.CoronaService
import com.bariqfirjatullah.infocorona.data.httpClient
import kotlinx.android.synthetic.main.fragment_dashboard.*
import com.bariqfirjatullah.infocorona.util.dismissLoading
import com.bariqfirjatullah.infocorona.util.showLoading
import com.bariqfirjatullah.infocorona.util.tampilToast
import kotlinx.android.synthetic.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiIndonesiaData()
    }


    private fun callApiIndonesiaData() {
        showLoading(context!!,swipeRefreshLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<CoronaService>(httpClient)

        val call = apiRequest.getIndonesia()
        call.enqueue(object : Callback<List<IndonesiaDataItem>>{
            override fun onFailure(call: Call<List<IndonesiaDataItem>>,t: Throwable){
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(call: Call<List<IndonesiaDataItem>>, response: Response<List<IndonesiaDataItem>>){
                dismissLoading(swipeRefreshLayout)

                when{
                    response.isSuccessful->

                        when{
                            response.body()?.size !=0->
                                tampilIndonesiaData(response.body()!!)
                             else->{
                                 tampilToast(context!!,"Berhasil")
                             }
                        }
                    else->{
                        tampilToast(context!!,"Gagal")
                    }
                }
            }
        })

    }

    private fun tampilIndonesiaData(indonesiaData: List<IndonesiaDataItem>){
        listIndonesiaData.layoutManager = LinearLayoutManager(context)
        listIndonesiaData.adapter = DashboardAdapter(context!!,indonesiaData){
            val indonesiaData = it
            tampilToast(context!!, indonesiaData.name)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}
