package com.elvis.studysupporter.controller.dto

data class MembersResponse<T>(
    val data: List<T>
)