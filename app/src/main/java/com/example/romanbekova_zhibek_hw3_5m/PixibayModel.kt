package com.example.romanbekova_zhibek_hw3_5m

data class PixibayModel(
    var hits: ArrayList<ImageModel>
)

data class ImageModel(
    var largeImageUrl: String,
    var likes: Int
)