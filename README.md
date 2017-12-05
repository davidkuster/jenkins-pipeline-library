# jenkins-pipeline-library

Jenkins Pipeline Library experimentation, ala [Fabric8 Pipeline Library](https://github.com/fabric8io/fabric8-pipeline-library).


### Usage

In Jenkinsfile:

    #!/usr/bin/env groovy
    @Library([
        'github.com/fabric8io/fabric8-pipeline-library@master',
        'github.com/davidkuster/jenkins-pipeline-library@master'
    ])