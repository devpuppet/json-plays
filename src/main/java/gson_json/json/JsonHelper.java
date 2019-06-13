package gson_json.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHelper {

    GsonBuilder builder;
    Gson gson;

    public JsonHelper() {
        builder = new GsonBuilder();
        gson = builder
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    public <T> T parseJsonToObject(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public <T> String parseObjectToJson(T object) {
        return gson.toJson(object);
    }

}
