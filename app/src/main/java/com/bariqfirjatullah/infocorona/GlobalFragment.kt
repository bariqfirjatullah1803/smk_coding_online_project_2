package com.bariqfirjatullah.infocorona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.bariqfirjatullah.infocorona.data.apiRequest
import com.bariqfirjatullah.infocorona.data.GlobalService
import com.bariqfirjatullah.infocorona.data.httpClient
import kotlinx.android.synthetic.main.fragment_global.*
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
class GlobalFragment : Fragment() {

    private fun callApiGetGlobalData(){
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<GlobalService>(httpClient)

        val call = apiRequest.getGlobal()
        call.enqueue(object: Callback<List<GlobalDataItem>>{
            override fun onFailure(call: Call<List<GlobalDataItem>>, t:Throwable){
                dismissLoading(swipeRefreshLayout)
            }
            override fun onResponse(call: Call<List<GlobalDataItem>>,response: Response<List<GlobalDataItem>>){
                dismissLoading(swipeRefreshLayout)
                when{
                    response.isSuccessful->
                        when {
                            response.body()?.size != 0->
                                tampilGlobalData(response.body()!!)

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

    private fun tampilGlobalData(GlobalData: List<GlobalDataItem>) {
        listGlobalData.layoutManager = LinearLayoutManager(context)
        listGlobalData.adapter = GlobalAdapter(context!!,GlobalData){

            val GlobalData = it
            tampilToast(context!!,GlobalData.attributes.countryRegion)
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
        return inflater.inflate(R.layout.fragment_global, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetGlobalData()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
