package dev.luketarr.sideboxapi.dtos

data class GetProjectResponseDTO (
    var id: Long = 0,
    var name: String = "",
    var description: String = "",
    var createdOn: String = "",
    var updatedOn: String = ""
)

data class CreateProjectRequestDTO(
    val name: String,
    val description: String
)

data class CreateProjectResponseDTO(
    val id: Long,
)

data class UpdateProjectRequestDTO(
    val name: String?,
    val description: String?
)
