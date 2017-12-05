/**
 * Creates a Maven container.
 *
 * Usage:
 *
 * mavenContainer {}
 * mavenContainer { name: 'abc' }
 * mavenContainer { name: 'abc', image: 'xyz' }
 */
def call(Map parameters = [:], body) {

    final defaultContainerName = 'maven'
    final defaultMavenImage = 'fabric8/maven-builder:2.2.331'

    String name = parameters.get('name', defaultContainerName)
    String image = parameters.get('image', defaultMavenImage)

    echo "creating Maven container with name [$name] and image [$image]"

    containerTemplate(
        name: name,
        image: image,
        command: '/bin/sh -c',
        args: 'cat',
        ttyEnabled: true,
        envVars: [
            containerEnvVar(
                key: 'MAVEN_OPTS',
                value: '-Duser.home=/root/')
        ]
    )
}