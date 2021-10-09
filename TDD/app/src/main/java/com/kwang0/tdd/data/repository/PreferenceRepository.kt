package com.kwang0.tdd.data.repository

import com.kwang0.tdd.data.local.LocalPreferenceDataSource
import com.kwang0.tdd.enum.ThemeMode
import javax.inject.Inject

interface PreferenceRepository {
    var themeMode: ThemeMode
    var count: Int
}

class PreferenceRepositoryImpl @Inject constructor(
    private val localPreferenceDataSource: LocalPreferenceDataSource,
) : PreferenceRepository {
    override var themeMode: ThemeMode
        get() = localPreferenceDataSource.themeMode
        set(value) {
            localPreferenceDataSource.themeMode = value
        }

    override var count: Int
        get() = localPreferenceDataSource.count
        set(value) {
            localPreferenceDataSource.count = value
        }
}
