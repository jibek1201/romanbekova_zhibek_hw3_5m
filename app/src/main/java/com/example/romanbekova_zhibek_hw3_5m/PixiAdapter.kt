package com.example.romanbekova_zhibek_hw3_5m

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.romanbekova_zhibek_hw3_5m.databinding.ItemImageBinding

class PixiViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(image: ImageModel) {
        with(binding){
            likeTv.text = image.likes.toString()
            pixaImg.load(image.largeImageUrl)
        }
    }
}

class PixiAdapter(var list: ArrayList<ImageModel>) : RecyclerView.Adapter<PixiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixiViewHolder {
        return PixiViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PixiViewHolder, position: Int) {
        holder.onBind(list[position])
    }

}