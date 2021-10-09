package com.kwang0.tdd.domain

import com.kwang0.tdd.data.repository.PreferenceRepository
import javax.inject.Inject

class SaveCountUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository,
) {
    fun execute(count: Int) {
        preferenceRepository.count = count
    }
}
