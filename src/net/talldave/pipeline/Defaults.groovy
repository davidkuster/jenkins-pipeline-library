package net.talldave.pipeline

class Defaults {

    static final mavenContainerName = 'maven'
    static final mavenContainerImage = 'fabric8/maven-builder:2.2.331'

    static final pythonContainerName = 'python'
    static final pythonContainerImage = 'internal image - must be set'

    static final kubectlContainerName = 'kubectl'
    static final kubectlContainerImage = 'fabric8/builder-clients:v5366c66'

}