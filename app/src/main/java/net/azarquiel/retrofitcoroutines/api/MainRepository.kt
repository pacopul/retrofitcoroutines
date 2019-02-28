package net.azarquiel.retrofitcoroutines.api

import net.azarquiel.retrofitcoroutines.model.Bar

/**
 * Created by pacopulido on 04/02/2019.
 */

class MainRepository() {
    val service = WebAccess.barService

    suspend fun getDataBares(): List<Bar> {
        val webResponse = service.getDataBares().await()
        if (webResponse.isSuccessful) {
            return webResponse.body()!!.bares
        }
        return emptyList()
    }

    suspend fun saveBar(
        nombrebar: String,
        direccion: String,
        municipio: String,
        provincia: String
    ): Bar? {
        var bar: Bar? = null
        val webResponse = service.saveBar(nombrebar, direccion, municipio, provincia).await()
        if (webResponse.isSuccessful) {
            bar = webResponse.body()!!.bar
        }
        return bar
    }

}
