package com.bhongj.rc_weeks2

import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class TalkListAdapter(private val dataList: MutableList<TalkListItem>) :
    RecyclerView.Adapter<TalkListAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.rcy_txt_name)
        var message: TextView = view.findViewById(R.id.rcy_txt_message)
        var img: ImageView = view.findViewById(R.id.rcy_img)

        init {
            // Define click listener for the ViewHolder's View.
        }

        fun bind(item: TalkListItem) {
            name.text = item.name
            message.text = item.name
            img.setImageResource(item.imgRsc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.bind(item)

        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, TalkPageActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("message", item.message)
            intent.putExtra("imgRsc", item.imgRsc)
            ContextCompat.startActivity(v.context, intent, null)
        }
    }

    override fun getItemCount() = dataList.size

}