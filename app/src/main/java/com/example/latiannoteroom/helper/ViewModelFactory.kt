package com.example.latiannoteroom.helper

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.latiannoteroom.ui.insert.NoteAddUpdateViewModel
import com.example.latiannoteroom.ui.main.MainViewModel

class ViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application): ViewModelFactory {
            return INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(application).also { INSTANCE = it }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(mApplication) as T
            }
            modelClass.isAssignableFrom(NoteAddUpdateViewModel::class.java) -> {
                NoteAddUpdateViewModel(mApplication) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
