import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.quarkus

plugins {
    id("application")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.quarkus)
    alias(libs.plugins.allopen)
}

kotlin {
    jvmToolchain(17)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("jakarta.persistence.Entity")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

dependencies {
    val quarkusBom = platform(libs.quarkus.bom)
    implementation(quarkusBom)
    implementation(libs.bundles.quarkus)

    testImplementation(libs.bundles.quarkus.test)
}