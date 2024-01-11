package com.hfad.allmovie.data.remote.dto.movie_details_dto

import com.hfad.allmovie.domain.model.movie_details.ExtraInfo

data class ExtraInfoDto(
    val header: String,
    val para: String
){

    fun toExtraInfo(): ExtraInfo{
        return ExtraInfo(
            header = header,
            para = para
        )
    }
}