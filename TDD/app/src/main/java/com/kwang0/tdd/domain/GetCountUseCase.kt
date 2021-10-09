package com.kwang0.tdd.domain

import com.kwang0.tdd.data.repository.PreferenceRepository
import javax.inject.Inject

class GetCountUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository,
) {
    fun execute(): Int {
        return preferenceRepository.count
    }
}