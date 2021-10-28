package fr.pageup.demoapp.data.local

import android.content.SharedPreferences
import android.graphics.Insets.add
import android.util.JsonToken
import androidx.core.view.OneShotPreDrawListener.add
import androidx.room.TypeConverter
import com.squareup.moshi.*
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Login
import fr.pageup.demoapp.data.remote.CustomerApi
import fr.pageup.demoapp.data.remote.ServiceProvider
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.converter.moshi.MoshiConverterFactory

class CustomerConverter {

    /*val type = Types.newParameterizedType(CustomerApi::class.java, String::class.java)
    val adapter2 = ServiceProvider.moshi.adapter<List<String>>(type)*/

    val adapter: JsonAdapter<Customer> = ServiceProvider.adapter
    val customer = Customer(11,"lol","12 rue de lol","39100","lolo","3333", Customer.Status.UNDELIVERED)

    private lateinit var preferences: SharedPreferences


        @TypeConverter
        @FromJson
        fun fromJsontoCustomer(json: String) : Customer? {
               return adapter.fromJson("")
        }

        @TypeConverter
        fun toCustomerInfoJson(): String? {

            return adapter.toJson(customer)
        }

}
