package com.example.portifoliogithub.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.portifoliogithub.data.model.Repo
import com.example.portifoliogithub.databinding.ItemRepoBinding

class RepoListAdapter : ListAdapter<Repo, RepoListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ViewHolder(
        private val binding : ItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind (item : Repo) {
            binding.txRepoName.text = item.name
            binding.txRepoDescription.text = item.description
            binding.txRepoLanguage.text = item.language
            binding.chipStarsCount.text = item.stargazersCount.toString()

            Glide.with(binding.root.context).load(item.owner.avatarURL).into(binding.imageRepo)
        }
    }


}

class DiffCallback : DiffUtil.ItemCallback<Repo>(){
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo) = oldItem.id == newItem.id
}