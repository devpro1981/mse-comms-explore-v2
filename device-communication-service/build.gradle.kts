import org.jetbrains.kotlin.gradle.dsl.JvmTarget

// ──────────────────────────────────────────────────────────────────────────────
// device-communication-service
//   • Business logic  : Java  (src/main/java)
//   • Tests           : Kotlin (src/test/kotlin)
//   • Spring Boot     : 3.5.12
//   • Java toolchain  : 17
// ──────────────────────────────────────────────────────────────────────────────

plugins {
    java
    alias(libs.plugins.kotlin.jvm)                 // Kotlin compiler for test sources
    alias(libs.plugins.spring.boot3)
    alias(libs.plugins.spring.dependency.management)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

dependencies {
    implementation(libs.spring.boot.starter.web)

    // kotlin-reflect is required on the classpath when the Kotlin plugin is applied
    implementation(libs.kotlin.reflect)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.kotlin.test.junit5)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
