import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.ResponseTransformer;

class JacksonTransformer implements ResponseTransformer {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String render(Object model) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(model);
    }

}
