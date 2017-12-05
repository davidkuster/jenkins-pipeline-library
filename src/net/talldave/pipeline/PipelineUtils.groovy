package net.talldave.pipeline

/**
 * Create the label to use for the build agent pod
 */
String getNodeLabel() {
    "buildpod.${env.JOB_NAME}.${env.BUILD_NUMBER}".replace('-', '_').replace('/', '_').replace('%2F', '_').replace('%', '_')
}

/**
 * Create the version value to use for the current build.
 * Includes the Git SHA, build number and timestamp.
 * Example: commit_79be90b_build_62_20171205205148
 */
String getBuildVersion() {
    String cmd = 'git rev-parse --short HEAD'
    String commit_id = sh(script: cmd, returnStdout: true).trim()
    String version = "commit_${commit_id}_build_${env.BUILD_NUMBER}_${env.BUILD_TIMESTAMP}"
    echo "using version $version"
    version
}
