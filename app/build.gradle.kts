plugins {
    id("com.android.application")
    id("kotlin-android")
    id ("kotlin-kapt")
    id ("kotlin-parcelize")
    id("androidx.navigation.safeargs")
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

    buildFeatures {
        dataBinding = true
        viewBinding = true
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

    sourceSets {
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
        getByName("debug").java.srcDirs("src/debug/kotlin")
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
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
    implementation(Libs.recyclerView)
    implementation(Libs.recyclerViewSelection)

    // Jetpack
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUI)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycleLiveData)
    implementation(Libs.lifecycleRunTime)
    implementation(Libs.lifecycleSavedState)
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation(Libs.room)
    implementation(Libs.roomKtx)
    kapt(Libs.kaptRoom)
    kapt(Libs.kaptLifecycle)

    //Retrofit
    implementation(Libs.moshi)
    implementation(Libs.retrofitAndMoshi)
    kapt(Libs.kaptMoshiKotlin)

    // Third party
    implementation(Libs.koin)
    implementation(Libs.timber)

    // Test
    testImplementation(Libs.junit)
    testImplementation(Libs.koinTest)
    androidTestImplementation(Libs.junitTest)
    androidTestImplementation(Libs.espressoCore)


}
