package co.com.japl.facturacionelectronica.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

public final class EmptyStringAsNullTypeAdapter<T> implements JsonDeserializer<T>,JsonSerializer<T>{

// Let Gson instantiate it itself
private EmptyStringAsNullTypeAdapter() {
}

public T deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
    throws JsonParseException {
if ( jsonElement.isJsonPrimitive() ) {
    final JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
    if ( jsonPrimitive.isString() && jsonPrimitive.getAsString().isEmpty() ) {
        return null;
    }
}
return context.deserialize(jsonElement, type);
}

public JsonElement serialize(final T value, final Type type, final JsonSerializationContext context)
	    throws JsonParseException {
	if ( value == null ) {
		return new JsonPrimitive("");
		}
	return context.serialize(value, type);
	}

}
