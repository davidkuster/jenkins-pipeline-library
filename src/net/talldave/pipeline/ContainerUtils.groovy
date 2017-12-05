package net.talldave.pipeline

// Container utility functions.
// Choosing this for simplicity over more DSL-like closures in var dir.

/**
 * Creates a Maven container.
 *
 * Usage:
 *
 * mavenContainer()
 * mavenContainer(name: 'abc')
 * mavenContainer(image: 'xyz')
 * mavenContainer(name: 'abc', image: 'xyz')
 */
def mavenContainer(String name = Defaults.mavenName,
                   String image = Defaults.mavenImage) {
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