package dev.luketarr.sideboxapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SideboxApiApplication

fun main(args: Array<String>) {
    runApplication<SideboxApiApplication>(*args)
}
