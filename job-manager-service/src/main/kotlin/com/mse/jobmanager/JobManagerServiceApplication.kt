package com.mse.jobmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JobManagerServiceApplication

fun main(args: Array<String>) {
    runApplication<JobManagerServiceApplication>(*args)
}
