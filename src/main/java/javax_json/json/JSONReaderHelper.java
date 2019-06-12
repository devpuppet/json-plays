package javax_json.json;

import javax_json.model.Duke;

import javax.json.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JSONReaderHelper {

    public void readJson(File jsonFile) {

        JsonStructure jsonStructure = null;

        try (BufferedReader bufferedReader = Files.newBufferedReader(jsonFile.toPath());
             JsonReader reader = Json.createReader(bufferedReader)) {

            jsonStructure = reader.read();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonStructure);

        if (jsonStructure.getValueType().equals(JsonValue.ValueType.OBJECT)) {

            JsonObject jsonObject = jsonStructure.asJsonObject();

            Duke duke = new Duke.Builder()
                    .withAge(jsonObject.getInt("age"))
                    .withCity(jsonObject.getString("city"))
                    .withFirstName(jsonObject.getString("firstName"))
                    .withLastName(jsonObject.getString("lastName"))
                    .withPhoneNumbers(jsonObject.getJsonArray("phoneNumbers"))
                    .withPostalCode(jsonObject.getString("postalCode"))
                    .withState(jsonObject.getString("state"))
                    .withStreetAddress(jsonObject.getString("streetAddress"))
                    .build();

            jsonObject.getString("hungry", "N/A");

            duke.printDuke();
        }

    }

}
