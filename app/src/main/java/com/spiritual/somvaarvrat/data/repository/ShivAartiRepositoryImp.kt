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
                title = "🔱 सोमवार व्रत कथा",
                resId = R.raw.shomvaar_vart_katha
            ),

            ShivAartiModel(
                title = "📿 सोलह सोमवार व्रत कथा",
                resId = R.raw.solaha_shomvaar_katha
            ),

            ShivAartiModel(
                title = "🌙 सौम्य प्रदोष व्रत कथा",
                resId = R.raw.pardosh_katha
            ),

            ShivAartiModel(
                title = "🪔 शिव जी आरती",
                resId = R.raw.shiv_aarti
            )
        )
    }
}