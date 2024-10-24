# Firebase Publishing + Quarkus
The reason for making this repository is because I've had a long running
thorn in my side that I've recently traced and fixed. Whenever I had a
repository with both the firebase publishing plugin (which I sometimes
use to publish to firebase app testing) and the quarkus plugin (which 
I sometimes use to build quarkus applications), I would get some weird
conflicts with jackson-core dependencies.

Using the gradle build scans, I found that the firebase plugin was
bringing in a classpath dependency on an old jackson-core at the root
level of the project. This was causing the quarkus plugin to fail
because its analytics plugin was trying to use a newer version and
getting a class not found error.

It's not so straightforward to override the classpath dependency
when its the root project, so the way I made it work, is to force
the dependency to be the newer version in the quarkus plugin when
a gradle property is set.

The following is added to the root build.gradle.kts file:
```
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
```
