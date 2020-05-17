package com.bariqfirjatullah.infocorona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.bariqfirjatullah.infocorona.bariq.apiRequest
import com.bariqfirjatullah.infocorona.bariq.BiodataService
import com.bariqfirjatullah.infocorona.bariq.httpClient
import kotlinx.android.synthetic.main.fragment_about.*
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
class AboutFragment : Fragment() {

    private fun callApiGetBiodata(){
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<BiodataService>(httpClient)

        val call = apiRequest.getBiodata()
        call.enqueue(object: Callback<List<BiodataItem>>{
            override fun onFailure(call: Call<List<BiodataItem>>, t:Throwable){
                dismissLoading(swipeRefreshLayout)
            }
            override fun onResponse(call: Call<List<BiodataItem>>,response: Response<List<BiodataItem>>){
                dismissLoading(swipeRefreshLayout)
                when{
                    response.isSuccessful->
                        when {
                            response.body()?.size != 0->
                                tampilBiodata(response.body()!!)

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

    private fun tampilBiodata(Biodata: List<BiodataItem>){
        listBiodata.layoutManager=LinearLayoutManager(context)
        listBiodata.adapter = AboutAdapter(context!!,Biodata){
            val Biodata = it
            tampilToast(context!!,Biodata.nama)
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
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetBiodata()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
