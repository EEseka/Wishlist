package com.example.wishlist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addWish(wishEntity: Wish)

    @Query("SELECT * FROM `wish_table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Query("SELECT * FROM `wish_table` WHERE id = :id")
    abstract fun getWishById(id: Long): Flow<Wish>

    // The ones returning flows don't need to be suspendable as they are already called from a coroutine scope
}