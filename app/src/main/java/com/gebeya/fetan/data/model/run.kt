package com.gebeya.fetan.data.model

import androidx.room.*

@Entity(tableName = "runs")
data class Run(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val distance: Double,
    @ColumnInfo val time: Int,
    @ColumnInfo(name = "created_at") val createdAt: String
)

@Dao
interface RunDao {
    @Insert
    fun addRun(run: Run)

    @Query("SELECT * FROM runs")
    fun getAll(): List<Run>
}