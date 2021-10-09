package com.kwang0.tdd.domain.usecase

import com.kwang0.tdd.data.repository.PreferenceRepository
import com.kwang0.tdd.domain.GetCountUseCase
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class GetCountUseCaseTest {

    private val preferenceRepository = Mockito.mock(PreferenceRepository::class.java)
    private val getCountUseCase = GetCountUseCase(preferenceRepository)

    @Test
    fun `return any count`() {
        val a = 1
        Mockito.`when`(preferenceRepository.count)
            .thenReturn(a)

        Assert.assertEquals(getCountUseCase.execute(), a)
    }
}
