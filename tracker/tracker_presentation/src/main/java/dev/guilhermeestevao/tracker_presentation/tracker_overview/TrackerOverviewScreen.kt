package dev.guilhermeestevao.tracker_presentation.tracker_overview

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import dev.guilhermeestevao.core.util.UiEvent
import dev.guilhermeestevao.core_ui.LocalSpacing
import dev.guilhermeestevao.tracker_presentation.tracker_overview.components.NutrientHeader

@Composable
fun TrackerOverviewScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel()
){
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = spacing.spaceSmall
            )
    ){
        item {
            NutrientHeader(state = state)
        }
    }
}