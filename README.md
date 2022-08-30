## Building
1. Run `mvn clean install`
2. Start a GraalVM Container Image `docker run --entrypoint bash -it --name graalvm --rm ghcr.io/graalvm/native-image:22.2.0`
3. Copy both of the dependent jars and app jar to the container: `docker cp u62-1.0.jar graalvm:/app && docker cp libs graalvm:/app`
4. Build the native image in container: `native-image -cp "libs/*" --no-fallback --static -jar u62-1.0.jar u62`
5. Copy the binary `docker cp graalvm:/app/u62 u62`