package dev.luketarr.sideboxapi.dtos

class ResourceNotFoundException(message: String?) : RuntimeException(message)

class BadRequestException(message: String?) : RuntimeException(message)

class UnauthorizedException(message: String?) : RuntimeException(message)

class ForbiddenException(message: String?) : RuntimeException(message)

class InternalServerErrorException(message: String?) : RuntimeException(message)

data class CustomHttpException (
    var code: String? = null,
    var message: String? = null,
)