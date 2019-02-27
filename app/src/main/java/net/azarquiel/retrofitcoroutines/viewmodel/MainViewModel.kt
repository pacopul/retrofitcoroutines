package net.azarquiel.retrofitcoroutines.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.azarquiel.retrofitcoroutines.api.MainRepository
import net.azarquiel.retrofitcoroutines.model.Bar

/**
 * Created by pacopulido on 04/02/2019.
 */

class MainViewModel : ViewModel() {

    private val repository: MainRepository = MainRepository()

    val dataBares = MutableLiveData<List<Bar>>()

    fun loadData() {
        GlobalScope.launch(Main) {
            val result = repository.getDataBares()
            dataBares.value = result
        }
    }

    fun saveBar(
        nombrebar: String,
        direccion: String,
        municipio: String,
        provincia: String
    ) {
        GlobalScope.launch(Main) {
            val result = repository.saveBar(nombrebar, direccion, municipio, provincia)
            result ?: println("El bar no se ha guardado")
        }
    }
}
