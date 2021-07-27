package com.example.portifoliogithub.data.repositories

import com.example.portifoliogithub.core.RemoteException
import com.example.portifoliogithub.data.model.Repo
import com.example.portifoliogithub.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service : GitHubService) : RepoRepository {

    override suspend fun listRepositories(user: String) = flow {
        try {
            emit(service.listRepositories(user))
        }catch (e : HttpException){
            throw RemoteException(e.message ?: "Não foi possivel realizar a busca")
        }
    }

}