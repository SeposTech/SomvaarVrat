package com.spiritual.somvaarvrat.domain.repository.usecase

import com.spiritual.somvaarvrat.data.repository.model.ShivAartiModel
import com.spiritual.somvaarvrat.domain.repository.ShivAartiRepository

class ShivAartiUseCase constructor(private val shivAartiRepository: ShivAartiRepository) {

    suspend operator fun invoke(): List<ShivAartiModel> {
        return shivAartiRepository.getShivAartiList()

    }
}