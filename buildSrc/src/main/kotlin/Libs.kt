object Libs {


    // Classpath Gradle Plugin
    const val classpathGradle =
        "com.android.tools.build:gradle:${Versions.classpathGradleVersion}"
    // Classpath Kotlin Gradle Plugin
    const val classpathKotlinGradle =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    // Classpath Navigation safe args Plugin
    const val classpathNavigationSafeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
    // Classpath jacoco plugin
    const val classpathJacoco =
        "org.jacoco:org.jacoco.core:${Versions.jacocoVersion}"


    // Core
    const val kotlinStdLib =
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"

    // Design
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val recyclerView =  "androidx.recyclerview:recyclerview:${Versions.recyclerviewVersion}"
    const val recyclerViewSelection = "androidx.recyclerview:recyclerview-selection:${Versions.recyclerviewSelectionVersion}"

    // Jetpack
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifecycleRunTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleVersion}"
    const val kaptLifecycle = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleVersion}"

    // Third party
    const val koin = "io.insert-koin:koin-android:${Versions.koinVersion}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val kaptMoshi = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
    
    // Test
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val junitTest = "androidx.test.ext:junit:${Versions.junitTestVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val koinTest = "io.insert-koin:koin-test:${Versions.koinVersion}"
}
