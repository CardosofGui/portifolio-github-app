package com.example.portifoliogithub.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portifoliogithub.data.model.Repo
import com.example.portifoliogithub.domain.ListUserRepositoriesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(
    private val listUserRepositoriesUseCase: ListUserRepositoriesUseCase
) : ViewModel() {

    private val _repo = MutableLiveData<State>()
    val repo : LiveData<State> = _repo

    fun getRepoList(user : String){
        viewModelScope.launch {
            listUserRepositoriesUseCase(user)
                .onStart {
                    _repo.postValue(State.Loading)
                }.catch {
                    _repo.postValue(State.Error(it))
                }.collect {
                    _repo.postValue(State.Sucess(it))
                }
        }
    }

    sealed class State {
        object Loading : State()
        data class Sucess(val list : List<Repo>) : State()
        data class Error(val error : Throwable) : State()
    }
}