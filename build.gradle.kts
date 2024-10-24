plugins {
    alias(libs.plugins.allopen) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.firebase.app.distribution) apply false
}

// this is the only way we can get quarkusDev to work - because of the stupid firebase publishing
// plugin, because it uses a really old version of jackson that overrides any subprojects that use
// the jackson-core library as a build dependency / classpath. We'll need to toggle this so it
// doesn't take effect when we're trying to use the firebase publish
buildscript {
    if (properties.containsKey("quarkus").not()) {
        println("NOT QUARKUS")
    } else {
        println("QUARKUS")
        configurations.classpath {
            resolutionStrategy {
                force(libs.jackson.core)
            }
        }
    }
}