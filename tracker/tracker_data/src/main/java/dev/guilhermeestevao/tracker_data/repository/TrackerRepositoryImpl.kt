package dev.guilhermeestevao.tracker_data.repository

import dev.guilhermeestevao.tracker_data.local.dao.TrackerDao
import dev.guilhermeestevao.tracker_data.mapper.toTrackableFood
import dev.guilhermeestevao.tracker_data.mapper.toTrackedFood
import dev.guilhermeestevao.tracker_data.mapper.toTrackedFoodEntiy
import dev.guilhermeestevao.tracker_data.remote.OpenFoodApi
import dev.guilhermeestevao.tracker_domain.model.TrackableFood
import dev.guilhermeestevao.tracker_domain.model.TrackedFood
import dev.guilhermeestevao.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.Exception
import java.time.LocalDate

class TrackerRepositoryImpl(
    private val dao: TrackerDao,
    private val api: OpenFoodApi
): TrackerRepository {
    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try{
            val dto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(dto.products.mapNotNull { it.toTrackableFood() })
        }catch (e: Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun insertTrackedFood(food: TrackedFood) {
        dao.insertTrackedFood(food.toTrackedFoodEntiy())
    }

    override suspend fun deleteTrackedFood(food: TrackedFood) {
        dao.deleteTrackedFood(food.toTrackedFoodEntiy())
    }

    override fun getFoodsForDate(date: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodForDate(
            day = date.dayOfMonth,
            month = date.monthValue,
            year = date.year
        ).map { entities ->
            entities.map { it.toTrackedFood() }
        }
    }
}