package com.cardrecyclersample

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_item.view.*

class MainFragment: Fragment(){

    var item: ArrayList<Item>?=null
    private lateinit var recyclerView:RecyclerView
    private lateinit var viewManager:RecyclerView.LayoutManager
    private  lateinit var viewAdapter:MainAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // inflate fragment
        val root = inflater.inflate(R.layout.frag_main, container, false)

        //creates a vertical Layout Manager
        viewManager = LinearLayoutManager(activity)

        //create adapter and load items into it
        viewAdapter = MainAdapter(initItem(),activity!!.applicationContext)

        //load item layout and set attributes
        recyclerView = root.findViewById<RecyclerView>(R.id.item_list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        return root
    }

    /**
     * Load data
     */
    private fun initItem():List<Item>{
        return listOf(
            Item("name1","desc1"),
            Item("name2","desc2"),
            Item("name3","desc3"),
            Item("name4","desc4"),
            Item("name6","desc6"),
            Item("name7","desc7"),
            Item("name8","desc8"),
            Item("name9","desc9"),
            Item("name10","desc10"),
            Item("name11","desc11"),
            Item("name12","desc12"),
            Item("name13","desc13"),
            Item("name14","desc14"),
            Item("name15","desc15"),
            Item("name16","desc16"),
            Item("name17","desc17")

        )
    }

    private class MainAdapter(items: List<Item>, val context:Context): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

        var items: List<Item> = items
            set(items) {
                field = items
                notifyDataSetChanged()
            }

        // inflate the item view
        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
            return MainAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_item,parent,false))
        }

        //get the number of items
        override fun getItemCount(): Int {
            return items.size
        }

        //bind each item to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder?.tvName?.text = items.get(position).name
            holder?.tvDescript.text = items.get(position).description
        }


        // holds each item
        class ViewHolder (view:View):RecyclerView.ViewHolder(view){
            val tvName = view.tv_title
            val tvDescript = view.tv_description
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}