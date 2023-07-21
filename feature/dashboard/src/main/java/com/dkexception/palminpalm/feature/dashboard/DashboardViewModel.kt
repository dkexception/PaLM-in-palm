package com.dkexception.palminpalm.feature.dashboard

import androidx.lifecycle.ViewModel
import com.dkexception.palminpalm.core.common.nav.DashboardNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val dashboardNavigator: DashboardNavigator
) : ViewModel() {

    fun onEvent(event: DashboardEvent) = Unit
}
