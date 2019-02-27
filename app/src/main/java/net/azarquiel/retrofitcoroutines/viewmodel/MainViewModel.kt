package net.azarquiel.retrofitcoroutines.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import net.azarquiel.retrofitcoroutines.api.MainRepository
import net.azarquiel.retrofitcoroutines.model.Bar

/**
 * Created by pacopulido on 04/02/2019.
 */

class MainViewModel : ViewModel() {

    private val repository: MainRepository = MainRepository()

    fun getDataBares(): MutableLiveData<List<Bar>> {
        return repository.getDataBares()
    }

    fun saveBar(
        nombrebar: String,
        direccion: String,
        municipio: String,
        provincia: String
    ): Bar? {
        return repository.saveBar(nombrebar, direccion, municipio, provincia)
    }
}
