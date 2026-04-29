import org.jetbrains.kotlin.gradle.dsl.JvmTarget

// ──────────────────────────────────────────────────────────────────────────────
// job-manager-service
//   • Business logic + Tests : Kotlin (src/main/kotlin, src/test/kotlin)
//   • Spring Boot            : 4.0.3
//   • Java toolchain         : 21
// ──────────────────────────────────────────────────────────────────────────────

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)              // opens Spring-annotated classes for proxying
    alias(libs.plugins.spring.boot4)
    alias(libs.plugins.spring.dependency.management)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

dependencies {
    implementation(libs.spring.boot.starter.web)
    implementation(libs.kotlin.reflect)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.kotlin.test.junit5)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
