package net.azarquiel.retrofitcoroutines.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.azarquiel.retrofitcoroutines.api.MainRepository
import net.azarquiel.retrofitcoroutines.model.Bar

/**
 * Created by pacopulido on 04/02/2019.
 */

class MainViewModel : ViewModel() {

    private var repository: MainRepository = MainRepository()

    fun loadData(): MutableLiveData<List<Bar>> {
        val dataBares = MutableLiveData<List<Bar>>()
        GlobalScope.launch(Main) {
            dataBares.value = repository.getDataBares()
        }
        return dataBares
    }

    fun saveBar(
        nombrebar: String,
        direccion: String,
        municipio: String,
        provincia: String
    ):MutableLiveData<Bar> {
        val bar= MutableLiveData<Bar>()
        GlobalScope.launch(Main) {
            bar.value = repository.saveBar(nombrebar, direccion, municipio, provincia)
        }
        return bar
    }
}
