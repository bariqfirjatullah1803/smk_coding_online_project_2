package com.bariqfirjatullah.infocorona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.bariqfirjatullah.infocorona.data.apiRequest
import com.bariqfirjatullah.infocorona.data.ProvinsiService
import com.bariqfirjatullah.infocorona.data.httpClient
import kotlinx.android.synthetic.main.fragment_list.*
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
class ListFragment : Fragment() {

    private fun callApiGetProvinsiIndonesiaData(){
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<ProvinsiService>(httpClient)

        val call = apiRequest.getProvinsi()
        call.enqueue(object: Callback<List<ProvinsiIndonesiaDataItem>>{
            override fun onFailure(call: Call<List<ProvinsiIndonesiaDataItem>>, t:Throwable){
                dismissLoading(swipeRefreshLayout)
            }
            override fun onResponse(call: Call<List<ProvinsiIndonesiaDataItem>>,response: Response<List<ProvinsiIndonesiaDataItem>>){
                dismissLoading(swipeRefreshLayout)
                when{
                    response.isSuccessful->
                        when {
                            response.body()?.size != 0->
                                tampilProvinsiIndonesiaData(response.body()!!)

                            else-> {
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

    private fun tampilProvinsiIndonesiaData(provinsiIndonesiaData: List<ProvinsiIndonesiaDataItem>) {
        listProvinsiIndonesiaData.layoutManager = LinearLayoutManager(context)
        listProvinsiIndonesiaData.adapter = ListAdapter(context!!,provinsiIndonesiaData){

            val provinsiIndonesiaData = it
            tampilToast(context!!,provinsiIndonesiaData.attributes.provinsi)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetProvinsiIndonesiaData()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
