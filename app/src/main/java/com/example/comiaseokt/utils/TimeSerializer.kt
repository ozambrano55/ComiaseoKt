package com.example.comiaseokt.utils

import com.google.gson.*
import java.lang.reflect.Type
import java.sql.Time

class TimeSerializer : JsonDeserializer<Time>, JsonSerializer<Time> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Time {
        return Time.valueOf(json.asString)
    }

    override fun serialize(
        src: Time,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement {
        return JsonPrimitive(src.hours.toString() + ":" + src.minutes + ":" + src.seconds)
    }
}
