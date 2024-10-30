package com.example.latiannoteroom.ui.main

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.latiannoteroom.database.Note
import com.example.latiannoteroom.repository.NoteRepository

class MainViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
}