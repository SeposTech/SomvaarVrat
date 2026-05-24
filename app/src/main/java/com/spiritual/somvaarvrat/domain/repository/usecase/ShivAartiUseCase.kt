package com.spiritual.somvaarvrat.domain.repository.usecase

import com.spiritual.somvaarvrat.data.repository.model.ShivAartiModel
import com.spiritual.somvaarvrat.domain.repository.ShivAartiRepository
import javax.inject.Inject

class ShivAartiUseCase  @Inject constructor(private val shivAartiRepository: ShivAartiRepository) {

    suspend operator fun invoke(): List<ShivAartiModel> {
        return shivAartiRepository.getShivAartiList()

    }
}