package Cache

import Models.Food
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object AppCache {
    private const val NAME = "toCache"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    var objectString: ArrayList<Food>
        get() = gsonStringToArray(preferences.getString("object", "[]")!!)
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("object", arrayToGsonString(value))
            }
        }

    private fun arrayToGsonString(arrayList: ArrayList<Food>): String {
        return Gson().toJson(arrayList)
    }

    private fun gsonStringToArray(gsonString: String): ArrayList<Food> {
        val typeToken = object : TypeToken<ArrayList<Food>>() {}.type
        return Gson().fromJson(gsonString, typeToken)
    }
}