package com.spiritual.somvaarvrat.domain.repository

import com.spiritual.somvaarvrat.data.repository.model.ShivAartiModel

interface ShivAartiRepository {
    suspend fun getShivAartiList(): List<ShivAartiModel>
}