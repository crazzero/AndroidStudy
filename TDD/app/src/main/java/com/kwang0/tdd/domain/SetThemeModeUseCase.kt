package com.kwang0.tdd.domain

import com.kwang0.tdd.data.repository.PreferenceRepository
import com.kwang0.tdd.enum.ThemeMode
import javax.inject.Inject

class SetThemeModeUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository,
) {
    fun execute(themeMode: ThemeMode) {
        preferenceRepository.themeMode = themeMode
    }
}
