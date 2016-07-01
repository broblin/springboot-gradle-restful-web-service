package sbg.withdrawal;

/**
 * Created by benoit on 01/07/16.
 */
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Incroyable mais vrai : il faut une conf spéciale pour que Jackson sérialise les dates au format ISO
 */
public class IsoLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider arg2)
            throws IOException, JsonProcessingException {
        gen.writeString(DateTimeFormatter.ISO_DATE_TIME.format(value));
    }

}
