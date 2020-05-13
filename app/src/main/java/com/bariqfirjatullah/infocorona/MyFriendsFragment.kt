package com.bariqfirjatullah.infocorona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_my_friends.*

/**
 * A simple [Fragment] subclass.
 */
class MyFriendsFragment : Fragment() {

    lateinit var listTeman : ArrayList<MyFriend>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_friends, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun simulasiDataTeman(){
        listTeman = ArrayList()
        listTeman.add(MyFriend("Fakhry","Laki - Laki", "fakhry@smkcoding.id", "0821231231", "Malang"))
        listTeman.add(MyFriend("Ahmad","Laki - Laki", "fakhry@smkcoding.id", "0821231231", "Malang"))
    }

    private fun tampilTeman(){
        rv_listMyFriends.layoutManager = LinearLayoutManager(activity)
        rv_listMyFriends.adapter = MyFriendAdapter(activity!!, listTeman)
    }

    private fun initView(){
        simulasiDataTeman()
        tampilTeman()
    }

}
