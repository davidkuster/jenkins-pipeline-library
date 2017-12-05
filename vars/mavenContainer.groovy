final static defaultMavenImage = 'fabric8/maven-builder:2.2.331'
final static defaultContainerName = 'maven'

/**
 * Creates a Maven container.
 *
 * Usage:
 *
 * mavenContainer()
 *
 * mavenContainer { name: 'xyz' }
 */
def call(Map parameters = [:], body) {

    String name = parameters.get('name', defaultContainerName)
    String image = parameters.get('image', defaultMavenImage)

    containerTemplate(
        name: name,
        image: image,
        command: '/bin/sh -c',
        args: 'cat',
        ttyEnabled: true,
        envVars: [
            containerEnvVar(key: 'MAVEN_OPTS', value: '-Duser.home=/root/')
        ]
    )
}