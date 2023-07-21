package com.dkexception.palminpalm.core.common.di

import com.dkexception.palminpalm.core.common.nav.DashboardNavigator
import com.dkexception.palminpalm.core.common.nav.navigators.MoreNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigatorsModule {

    @Provides
    @Singleton
    fun provideDashboardNavigator(): DashboardNavigator = DashboardNavigator()

    @Provides
    @Singleton
    fun provideMoreNavigator(
        navigator: DashboardNavigator
    ): MoreNavigator = navigator
}
