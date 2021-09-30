object Configs {
    const val applicationId = "fr.pageup.template"
    const val compileSkdVersion = 30
    const val buildToolsVersion = "30.0.2"
    const val minSdkVersion = 21
    const val targetSdkVersion = 30

    // Build versions
    private const val versionMajor = 0
    private const val versionMinor = 0
    private const val buildNumber = 1

    private const val prefixVersion = "v"
    const val versionCode = versionMajor * 1000000 + versionMinor * 1000 + buildNumber
    const val versionName = "$prefixVersion$versionMajor.$versionMinor.$buildNumber"
}