package dev.guilhermeestevao.tracker_domain.use_case

import dev.guilhermeestevao.tracker_domain.model.TrackableFood
import dev.guilhermeestevao.tracker_domain.repository.TrackerRepository

class SearchFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>{
        if(query.isBlank()){
            return Result.success(emptyList())
        }
        return repository.searchFood(query.trim(), page, pageSize)
    }

}