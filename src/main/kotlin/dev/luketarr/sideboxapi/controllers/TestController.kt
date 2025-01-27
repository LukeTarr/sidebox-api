package dev.luketarr.sideboxapi.controllers

import dev.luketarr.sideboxapi.db.models.Project
import dev.luketarr.sideboxapi.services.ProjectService
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Tag(name = "Users", description = "User management APIs")
class TestController (
    private val projectService: ProjectService
) {

//    @Operation(
//        summary = "Test returns data",
//        description = "Returns Data"
//    )
//    @ApiResponses(value = [
//        ApiResponse(responseCode = "200", description = "Test Successful"),
//    ])
    @GetMapping("/test")
    fun getTest() : ResponseEntity<Void>{
        return ResponseEntity.ok().build()
    }

}