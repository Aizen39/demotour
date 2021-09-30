// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {

        classpath(Libs.classpathGradle)
        classpath(Libs.classpathKotlinGradle)
        classpath(Libs.classpathNavigationSafeArgs)
        classpath(Libs.classpathJacoco)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {

    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
