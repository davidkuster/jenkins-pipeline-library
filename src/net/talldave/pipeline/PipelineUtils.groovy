package net.talldave.pipeline

String getVersion() {
    String cmd = 'git rev-parse --short HEAD'
    String commit_id = sh(script: cmd, returnStdout: true).trim()
    String version = "commit_${commit_id}_build_${env.BUILD_NUMBER}_${env.BUILD_TIMESTAMP}"
    echo "using version $version"
    return version
}
