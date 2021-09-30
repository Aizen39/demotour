import java.io.File
import java.io.FileInputStream
import java.util.*

object KeyHelper {

    const val KEY_STORE_FILE = "storeFile"
    const val KEY_STORE_PASS = "storePassword"
    const val KEY_ALIAS = "keyAlias"
    const val KEY_PASS = "keyPassword"

    private val properties by lazy {
        Properties().apply {
            //println(this)
            load(FileInputStream(File("keystore.properties")))
        }
    }

    fun getValue(key: String): String {
        return properties.getProperty(key)
    }
}