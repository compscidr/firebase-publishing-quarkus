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