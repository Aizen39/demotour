plugins {
    id("com.android.application")
    id("kotlin-android")
    id ("kotlin-kapt")
    id ("kotlin-parcelize")
    id ("io.gitlab.arturbosch.detekt").version(Versions.detektVersion)
}

val toolsDir = "${project.rootDir}/tools"

apply(from= "$toolsDir/ktlint.gradle")
apply(from= "$toolsDir/detekt.gradle")
//apply(from= "$toolsDir/jacoco.gradle")

android {

    signingConfigs {
        create("signingConfigRelease") {
            storeFile = file(KeyHelper.getValue(KeyHelper.KEY_STORE_FILE))
            storePassword = KeyHelper.getValue(KeyHelper.KEY_STORE_PASS)
            keyAlias = KeyHelper.getValue(KeyHelper.KEY_ALIAS)
            keyPassword = KeyHelper.getValue(KeyHelper.KEY_PASS)
        }
    }

    defaultConfig {

        applicationId = Configs.applicationId
        minSdkVersion(Configs.minSdkVersion)
        targetSdkVersion(Configs.targetSdkVersion)
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        compileSdkVersion(Configs.compileSkdVersion)
        buildToolsVersion(Configs.buildToolsVersion)

        signingConfig = signingConfigs.getByName("signingConfigRelease")

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    packagingOptions {
        exclude("META-INF/**")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Core
    implementation(Libs.kotlinStdLib)
    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)

    // Design
    implementation(Libs.material)
    implementation(Libs.constraintLayout)

    // Test
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.junitTest)
    androidTestImplementation(Libs.espressoCore)
}
