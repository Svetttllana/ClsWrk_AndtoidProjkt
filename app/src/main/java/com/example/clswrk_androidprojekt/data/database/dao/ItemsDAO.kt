package com.example.clswrk_androidprojekt.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.clswrk_androidprojekt.data.database.FavoritesEntity
import com.example.clswrk_androidprojekt.data.database.ItemsEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * FROM ItemsEntity")
    fun getItemsEntities(): Flow<List<ItemsEntity>>

    @Query("SELECT (SELECT COUNT(*) FROM ItemsEntity) != 0")
    fun doesItemsEntityExist():Flow<Boolean>


    @Query("DELETE FROM Itemsentity WHERE description =:description")
    fun deliteItemEntityByDescription(description:String)


    @Query("SELECT * FROM ItemsEntity WHERE description =:searchText ")
    fun findItementityByDescription(searchText:String):ItemsEntity



    @Insert(onConflict = IGNORE) // игнорирует когда конфликт происходит(ignore items if same)
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)
    @Query("SELECT * FROM FavoritesEntity")
    fun getFavoriteEntities():List<FavoritesEntity>

}