package com.ariefrahman.myrecipe.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ariefrahman.core.domain.model.Category
import com.ariefrahman.myrecipe.R
import com.ariefrahman.myrecipe.databinding.ChipItemBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable as ChipDrawable

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val list = ArrayList<Category>()

    fun setList(list: List<Category>?){
        if(list == null) return
        this.list.clear()
        this.list.addAll(list)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.CategoryViewHolder {
        val binding = ChipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    class CategoryViewHolder(private val binding: ChipItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category){
            val chip = Chip(binding.root.context)
            val chipDrawable = ChipDrawable.createFromAttributes(binding.root.context, null, 0,
                R.style.Widget_MaterialComponents_Chip_Choice)

            chip.setChipDrawable(chipDrawable)
            chip.setPadding(4,4,4,4)
            chip.text = category.category

            binding.chipGroup.isSingleSelection = true
            binding.chipGroup.isSelectionRequired = true
            binding.chipGroup.addView(chip)

        }
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        holder.bind(this.list[position])
    }

    override fun getItemCount(): Int = list.size
}