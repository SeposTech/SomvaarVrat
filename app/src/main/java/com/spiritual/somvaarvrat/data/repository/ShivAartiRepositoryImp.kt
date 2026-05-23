package com.spiritual.somvaarvrat.data.repository

import com.spiritual.somvaarvrat.R
import com.spiritual.somvaarvrat.data.repository.model.ShivAartiModel
import com.spiritual.somvaarvrat.domain.repository.ShivAartiRepository

class ShivAartiRepositoryImp : ShivAartiRepository {
    override suspend fun getShivAartiList(): List<ShivAartiModel> {
        return getAartiList()
    }

    fun getAartiList(): List<ShivAartiModel> {
        return listOf(

            ShivAartiModel(
                title = "🕉️ शिव आरती",
                resId = R.raw.shiv_aarti
            ),

            ShivAartiModel(
                title = "🔱 शिव चालीसा",
                resId = R.raw.shiv_chalisa
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