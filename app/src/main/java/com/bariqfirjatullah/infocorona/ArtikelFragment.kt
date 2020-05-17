package com.bariqfirjatullah.infocorona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.bariqfirjatullah.infocorona.bariq.apiRequest
import com.bariqfirjatullah.infocorona.bariq.ArtikelService
import com.bariqfirjatullah.infocorona.bariq.httpClient
import kotlinx.android.synthetic.main.fragment_artikel.*
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
class ArtikelFragment : Fragment() {

    private fun callApiGetArtikel(){
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<ArtikelService>(httpClient)

        val call = apiRequest.getArtikel()
        call.enqueue(object: Callback<List<ArtikelItem>>{
            override fun onFailure(call: Call<List<ArtikelItem>>, t:Throwable){
                dismissLoading(swipeRefreshLayout)
            }
            override fun onResponse(call: Call<List<ArtikelItem>>,response: Response<List<ArtikelItem>>){
                dismissLoading(swipeRefreshLayout)
                when{
                    response.isSuccessful->
                        when {
                            response.body()?.size != 0->
                                tampilArtikel(response.body()!!)

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

    private fun tampilArtikel(artikel: List<ArtikelItem>){
        listArtikel.layoutManager=LinearLayoutManager(context)
        listArtikel.adapter = ArtikelAdapter(context!!,artikel){
            val artikel = it
            tampilToast(context!!,artikel.judul)
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
        return inflater.inflate(R.layout.fragment_artikel, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetArtikel()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
