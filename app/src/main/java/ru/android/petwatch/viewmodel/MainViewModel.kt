package ru.android.petwatch.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(app: Application) : AndroidViewModel(app) {


    var showToolBar = MutableLiveData<Boolean>()





}