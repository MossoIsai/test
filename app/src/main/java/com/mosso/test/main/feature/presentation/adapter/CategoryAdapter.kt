package com.mosso.test.main.feature.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mosso.test.R

class CategoryAdapter(private val categoriesList: List<String>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.name_category)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_category, viewGroup, false)

        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoriesList.size

    override fun onBindViewHolder(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.textView.text = categoriesList[position]
    }
}
