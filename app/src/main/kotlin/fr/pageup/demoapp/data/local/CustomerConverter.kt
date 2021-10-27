package fr.pageup.demoapp.data.local

import android.graphics.Insets.add
import android.util.JsonToken
import androidx.core.view.OneShotPreDrawListener.add
import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import fr.pageup.demoapp.data.model.Customer
import fr.pageup.demoapp.data.model.Login
import fr.pageup.demoapp.data.remote.ServiceProvider
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.converter.moshi.MoshiConverterFactory

class CustomerConverter {
        @TypeConverter
        fun toCustomerInfo(customerInfo: JsonAdapter<Customer>): Customer? {
            val type = object : List<Customer>
            customerInfo = ServiceProvider.adapter

        }

        @TypeConverter
        fun toCustomerInfo(customerInfo:Customer): JSONArray?{
            return null
        }


}
