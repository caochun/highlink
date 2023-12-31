package info.nemoworks.highlink.model;

import info.nemoworks.highlink.model.ExitTransaction.ExitRawTransaction;
import info.nemoworks.highlink.model.extendTransaction.ExtendRawTransaction;
import info.nemoworks.highlink.model.gantryTransaction.GantryRawTransaction;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

public class RawTransactionFactory {

    public static HighwayTransaction fromJson(JsonNode json) throws Exception {
        if (json.isArray()) {
            throw new Exception();
        }
        ObjectMapper mapper = new ObjectMapper();

        if (json.get("EXTOLLSTATION") != null) {
            return mapper.treeToValue(json, ExitRawTransaction.class);
        }
        if (json.get("GANTRYID") != null) {
            return mapper.treeToValue(json, GantryRawTransaction.class);
        }
        if (json.get("PARKOPERATORID") != null) {
            return mapper.treeToValue(json, ExtendRawTransaction.class);
        }
        return mapper.treeToValue(json, EntryRawTransaction.class);
    }
}
