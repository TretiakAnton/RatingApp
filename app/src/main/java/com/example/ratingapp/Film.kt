package com.example.ratingapp

class Film(
    private var RatingId: Int,
    private var nameId: Int,
    private var imageResourceId: Int
) {

    fun hasImage(): Boolean {
        return imageResourceId != NO_IMAGE_PROVIDED
    }

    fun getName(): Int {
        return nameId
    }

    fun getRating(): Int {
        return RatingId;
    }

    fun getImageResourceId(): Int {
        return imageResourceId;
    }

    companion object {
        private const val NO_IMAGE_PROVIDED = -1
    }
}