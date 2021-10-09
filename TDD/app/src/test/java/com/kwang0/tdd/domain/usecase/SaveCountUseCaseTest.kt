package com.kwang0.tdd.domain.usecase

import com.kwang0.tdd.data.repository.PreferenceRepository
import com.kwang0.tdd.domain.SaveCountUseCase
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.times

class SaveCountUseCaseTest {

    private val preferenceRepository = Mockito.mock(PreferenceRepository::class.java)
    private val saveCountUseCase = SaveCountUseCase(preferenceRepository)

    @Test
    fun `save any count`() {
        val a = 1

        saveCountUseCase.execute(a)

        Mockito.verify(preferenceRepository, times(1)).count = a
    }
}
