package dev.luketarr.sideboxapi.dtos

data class GetProjectResponseDTO (
    var id: Long = 0,
    var name: String = "",
    var description: String = "",
    var createdOn: String = "",
    var updatedOn: String = ""
)