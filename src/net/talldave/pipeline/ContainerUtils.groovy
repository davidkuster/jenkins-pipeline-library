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
def mavenContainer(args = null) {
    String name = args?.name ?: Defaults.mavenContainerName
    String image = args?.image ?: Defaults.mavenContainerImage

    echo "creating container with name [$name] and image [$image]"
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


/**
 * Creates an SBT container.
 *
 * Usage:
 *
 * sbtContainer()
 * sbtContainer(name: 'abc')
 * sbtContainer(image: 'xyz')
 * sbtContainer(name: 'abc', image: 'xyz')
 */
def sbtContainer(args = null) {
    createContainer(
        args?.name ?: Defaults.sbtContainerName,
        args?.image ?: Defaults.sbtContainerImage)
}


/**
 * Creates a Python container.
 *
 * Usage:
 *
 * pythonContainer()
 * pythonContainer(name: 'abc')
 * pythonContainer(image: 'xyz')
 * pythonContainer(name: 'abc', image: 'xyz')
 */
def pythonContainer(args = null) {
    createContainer(
        args?.name ?: Defaults.pythonContainerName,
        args?.image ?: Defaults.pythonContainerImage)
}


/**
 * Creates a container with Kubectl.
 *
 * Usage:
 *
 * kubectlContainer()
 * kubectlContainer(name: 'abc')
 * kubectlContainer(image: 'xyz')
 * kubectlContainer(name: 'abc', image: 'xyz')
 */
def kubectlContainer(args = null) {
    createContainer(
        args?.name ?: Defaults.kubectlContainerName,
        args?.image ?: Defaults.kubectlContainerImage)
}


// utility method to DRY out container templates
def createContainer(String name, String image) {
    echo "creating container with name [$name] and image [$image]"
    containerTemplate(
        name: name,
        image: image,
        command: '/bin/sh -c',
        args: 'cat',
        ttyEnabled: true
    )
}