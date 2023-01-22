package com.elvis.studysupporter.presenter.api.dto

data class MembersResponse<T>(
    val data: List<T>
)