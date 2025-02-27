package com.linov.community

import com.linov.community.contributors.*
import io.ktor.application.ApplicationCall

object ContributorHelper {
    var contributors: MutableMap<String, Contributor> = mutableMapOf()

    init {
        contributors.apply {
            Regina.initialize(this)
            AddinGamaBertaqwa.initialize(this)
            AriPurnamaAJi.initialize(this)
            AhmadZafrullah.initialize(this)
            IlhamBintang.initialize(this)
            Anwar907.initialize(this)
            GustiCahya.initialize(this)
            RahmatFathoni.initialize(this)
            RiyanRizkiyawan.initialize(this)
            EbySofyan.initialize(this)
            NaufalPrakoso.initialize(this)
            YudaKarnaen.initialize(this)
            AnasSegafMulachela.initialize(this)
            AgungSaputra.initialize(this)
            RickyAnwar.initialize(this)
            BagiHartawan.initialize(this)
            Ardianta.initialize(this)
            Jiadibo.initialize(this)
            WahyuSyarif.initialize(this)
            Fathurrahman.initialize(this)
            HayiNukman.initialize(this)
            // todo tambahkan inisialisasi ke class Contributor anda
        }
    }

    suspend fun response(call: ApplicationCall) {
        val id = call.parameters["id"]
        contributors[id]?.response(call)
    }

    fun mapIdToContributor() = contributors.entries
        .groupBy { it.value.email }
        .map { it.value.first().key to it.value.first().value }.toList()
}

