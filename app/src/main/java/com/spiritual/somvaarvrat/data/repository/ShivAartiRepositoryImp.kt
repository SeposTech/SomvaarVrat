package com.spiritual.somvaarvrat.data.repository

import com.spiritual.somvaarvrat.R
import com.spiritual.somvaarvrat.data.repository.model.ShivAartiModel
import com.spiritual.somvaarvrat.domain.repository.ShivAartiRepository
import javax.inject.Inject

class ShivAartiRepositoryImp @Inject constructor() : ShivAartiRepository {
    override suspend fun getShivAartiList(): List<ShivAartiModel> {
        return getAartiList()
    }

    fun getAartiList(): List<ShivAartiModel> {
        return listOf(

            ShivAartiModel(
                title = "🕉️ पूजा विधि",
                resId = R.raw.vidhi
            ),

            ShivAartiModel(
                title = "🔱 सोमववार व्रत कथा",
                resId = R.raw.shomvaar_vart_katha
            ),

            ShivAartiModel(
                title = "📿 महामृत्युंजय मंत्र",
                resId = R.raw.mahamrityunjay_mantra
            ),

            ShivAartiModel(
                title = "🌺 शिव स्तोत्र",
                resId = R.raw.shiv_stotra
            ),

            ShivAartiModel(
                title = "🧘‍♂️ शिव ध्यान मंत्र",
                resId = R.raw.shiv_dhyan_mantra
            ),

            ShivAartiModel(
                title = "🚩 रुद्राष्टक",
                resId = R.raw.rudrashtakam
            )
        )
    }
}