package com.example.softxpert.petsHomeScreen.adapters.subCategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.categories.Category
import com.example.domain.models.categories.Children
import com.example.softxpert.R
import com.example.softxpert.databinding.ItemListBinding


class SubCategoriesAdapter(private val onItemClickListener: OnSubCatItemClickListener, private var subCat : List<Children>?) :
    RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder>() {

     val data=subCat


   /* @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<String>?) {
        if (data != null) {
            this._data = data
           notifyDataSetChanged()

        }

    }*/




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_list, parent, false
        )
        return ViewHolder(binding, onItemClickListener)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.name= subCat?.get(position)?.slug

    }

    override fun getItemCount(): Int {
        return subCat?.size?:0
    }


    class ViewHolder(
        val binding: ItemListBinding,

        private val onItemClickListener: OnSubCatItemClickListener,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemClickListener.onSubCatItemClicked(adapterPosition)
            }
        }
    }


}