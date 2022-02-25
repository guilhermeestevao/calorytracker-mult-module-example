package dev.guilhermeestevao.tracker_domain.use_case

import dev.guilhermeestevao.tracker_domain.model.TrackedFood
import dev.guilhermeestevao.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(
        trackedFood: TrackedFood
    ) {
        repository.deleteTrackedFood(trackedFood)
    }

}