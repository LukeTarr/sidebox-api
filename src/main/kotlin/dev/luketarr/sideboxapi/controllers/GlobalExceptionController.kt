package dev.luketarr.sideboxapi.controllers

import dev.luketarr.sideboxapi.dtos.*
import io.swagger.v3.oas.annotations.Hidden
import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@Hidden
class GlobalExceptionController {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<CustomHttpException> {
        return ResponseEntity(
            CustomHttpException(HttpStatus.NOT_FOUND.toString(), ex.message),
            HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException): ResponseEntity<CustomHttpException> {
        return ResponseEntity(
            CustomHttpException(HttpStatus.BAD_REQUEST.toString(), ex.message),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(UnauthorizedException::class)
    fun handleUnauthorizedException(ex: UnauthorizedException): ResponseEntity<CustomHttpException> {
        return ResponseEntity(
            CustomHttpException(HttpStatus.UNAUTHORIZED.toString(), ex.message),
            HttpStatus.UNAUTHORIZED
        )
    }

    @ExceptionHandler(ForbiddenException::class)
    fun handleForbiddenException(ex: ForbiddenException): ResponseEntity<CustomHttpException> {
        return ResponseEntity(
            CustomHttpException(HttpStatus.FORBIDDEN.toString(), ex.message),
            HttpStatus.FORBIDDEN
        )
    }

    @ExceptionHandler(InternalServerErrorException::class)
    fun handleInternalServerErrorException(ex: InternalServerErrorException): ResponseEntity<CustomHttpException> {
        return ResponseEntity(
            CustomHttpException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.message),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}