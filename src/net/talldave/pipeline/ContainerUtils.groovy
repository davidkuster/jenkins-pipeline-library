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
def mavenContainer(String name = Defaults.mavenContainerName,
                   String image = Defaults.mavenContainerImage) {
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
def pythonContainer(String name = Defaults.pythonContainerName,
                   String image = Defaults.pythonContainerImage) {
    echo "creating Python container with name [$name] and image [$image]"
    genericContainer(name, image)
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
def kubectlContainer(String name = Defaults.kubectlContainerName,
                   String image = Defaults.kubectlContainerIamge) {
    echo "creating Kubectl container with name [$name] and image [$image]"
    genericContainer(name, image)
}


// utility method to DRY out container templates
def genericContainer(String name, String image) {
    containerTemplate(
        name: name,
        image: image,
        command: '/bin/sh -c',
        args: 'cat',
        ttyEnabled: true
    )
}