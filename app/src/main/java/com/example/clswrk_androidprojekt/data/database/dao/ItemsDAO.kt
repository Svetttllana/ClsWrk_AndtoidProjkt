package com.example.clswrk_androidprojekt.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.clswrk_androidprojekt.data.database.ItemsEntity
import com.example.clswrk_androidprojekt.model.ItemsModel


@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)


    @Query("SELECT * From ItemsEntity")
    fun getItemsEntities(): List<ItemsEntity>

    @Query("SELECT (SELECT COUNT(*) FROM ItemsEntity) != 0")
    fun doesItemsEntityExist():Boolean



    @Query("DELETE FROM Itemsentity WHERE description =:description")
    fun deliteItemEntityByDescription(description:String)


}