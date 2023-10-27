package com.example.tms_an_15_homework_lesson_20

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

sealed interface Note {
    @Parcelize
    data class ItemNote(
        val date: String?,
        val title: String,
        val text: String,
    ) : Parcelable, Note

    @Parcelize
    data class ImportantNote(
        val date: String?,
        val title: String,
        val text: String,
        @DrawableRes val imageId: Int
    ) :   Parcelable, Note

}