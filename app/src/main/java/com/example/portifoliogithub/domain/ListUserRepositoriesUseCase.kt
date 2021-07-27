package com.example.portifoliogithub.domain

import com.example.portifoliogithub.core.UseCase
import com.example.portifoliogithub.data.model.Repo
import com.example.portifoliogithub.data.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
) : UseCase<String, List<Repo>>() {


    override suspend fun execute(param: String): Flow<List<Repo>> = repository.listRepositories(param)
}