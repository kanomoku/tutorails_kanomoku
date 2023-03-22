package atomicitybusiness.method;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class YamlUtils {

    public static Map<String, Object> fromYamlStringToMap(String str) {
        Map map = new HashMap<>();
        if (StringUtils.isBlank(str)) {
            return map;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            map = objectMapper.readValue(str, Map.class);
        } catch (JsonProcessingException e) {
            log.info("log something");
        }
        return map;
    }

    public static String fromMapToYamlString(Map<String, Object> map) {

        if (MapUtils.isEmpty(map)) {
            return "";
        }


        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setExplicitStart(true);
        dumperOptions.setExplicitEnd(true);
        return new Yaml(dumperOptions).dumpAsMap(map);
    }
}
