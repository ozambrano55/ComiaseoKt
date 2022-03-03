package com.example.comiaseokt.utils

import com.google.gson.*
import java.lang.reflect.Type
import java.sql.Date
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateSerializer : JsonDeserializer<Date?>, JsonSerializer<Date?> {
    @Throws(JsonParseException::class)
    override fun deserialize(je: JsonElement, type: Type, jdc: JsonDeserializationContext): Date? {
        val date = je.asString
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        formatter.timeZone = TimeZone.getDefault()
        return try {
            Date(formatter.parse(date).time)
        } catch (e: ParseException) {
            System.err.println("Failed to parse Date due to:" + e.message)
            null
        }
    }

    override fun serialize(
        date: Date?,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement? {
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        formatter.timeZone = TimeZone.getDefault()
        return try {
            JsonPrimitive(formatter.format(date))
        } catch (e: Exception) {
            System.err.println("Failed to parse Date due to:" + e.message)
            return null
        }
    }
}
