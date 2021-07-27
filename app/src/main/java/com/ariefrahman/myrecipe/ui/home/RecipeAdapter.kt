package com.ariefrahman.myrecipe.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ariefrahman.core.domain.model.Recipe
import com.ariefrahman.myrecipe.databinding.RecipeItemBinding
import com.bumptech.glide.Glide

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    val list = ArrayList<Recipe>()

    fun setList(list: List<Recipe>?){
        if (list == null) return
        this.list.clear()
        this.list.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeAdapter.RecipeViewHolder {
        val binding = RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class RecipeViewHolder(private val binding: RecipeItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(recipe: Recipe){
            binding.let {
                it.tvName.text = recipe.title
                it.tvDifficulty.text = recipe.dificulty
                it.tvPortion.text = recipe.portion
                it.tvTime.text = recipe.times
                Glide.with(it.root)
                    .load(recipe.thumb)
                    .into(it.ivResep)
            }

        }
    }
}