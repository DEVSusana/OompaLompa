package com.oompa.loompa.data.db

import androidx.room.TypeConverter
import com.oompa.loompa.data.model.Favorite

class Converters {
    @TypeConverter
    fun fromFavorite(favorite: Favorite):String{
        return favorite.color + ", "+ favorite.food + ", "+ favorite.randomString + ", "+ favorite.song
    }
    @TypeConverter
    fun toFavorite(color: String):Favorite{
        return Favorite(color, "", "", "")
    }

}