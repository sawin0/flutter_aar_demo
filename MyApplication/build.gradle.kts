// Top-level build file where you can add configuration options common to all sub-projects/modules.

tasks.register<Delete>("clean") {
    // use the Gradle Provider API instead of deprecated rootProject.buildDir
    delete(layout.buildDirectory.asFile)
}
