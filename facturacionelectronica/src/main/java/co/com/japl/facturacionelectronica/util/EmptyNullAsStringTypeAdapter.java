package co.com.japl.facturacionelectronica.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public final class EmptyNullAsStringTypeAdapter<T> implements JsonSerializer<T> {

// Let Gson instantiate it itself
private EmptyNullAsStringTypeAdapter() {
}

public JsonElement serialize(final T value, final Type type, final JsonSerializationContext context)
    throws JsonParseException {
if ( value == null ) {
	return new JsonPrimitive("");
	}
return context.serialize(value, type);
}
}
