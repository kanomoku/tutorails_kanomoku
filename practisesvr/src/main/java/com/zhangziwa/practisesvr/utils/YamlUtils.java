package com.zhangziwa.practisesvr.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.representer.Representer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;


@Slf4j
public class YamlUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());


    private YamlUtils() {
    }

    public static Map<String, Object> yamlToMap(String yamlStr) {
        if (StringUtils.isBlank(yamlStr)) {
            return new HashMap<>();
        }

        Map<String, Object> map = new HashMap<>();
        try {
            map = objectMapper.readValue(yamlStr, Map.class);
        } catch (JsonProcessingException e) {
            log.info("yamlToMap occur error {}", e.getMessage());
        }
        return map;
    }

    public static Map<String, Object> yamlToMap2(String yamlStr) {
        if (StringUtils.isBlank(yamlStr)) {
            return new HashMap<>();
        }

        Yaml yaml = new Yaml(new SafeConstructor(new LoaderOptions()));
        return yaml.load(yamlStr);
    }

    public static Map<String, Object> yamlStreamToMap(InputStream yamlInputStream) {
        if (Objects.isNull(yamlInputStream)) {
            return new HashMap<>();
        }

        Map<String, Object> map = new HashMap<>();
        try {
            map = objectMapper.readValue(yamlInputStream, Map.class);
        } catch (IOException e) {
            log.info("yamlStreamToMap occur error {}", e.getMessage());
        }
        return map;
    }

    public static Map<String, Object> yamlFileToMap(String yamlFilePath) {
        FileIUtils.doesFileExist(yamlFilePath);

        Map<String, Object> map = new HashMap<>();
        try (FileInputStream inputStream = new FileInputStream(yamlFilePath)){
            map = yamlStreamToMap(inputStream);
        } catch (IOException e) {
            log.info("yamlFileToMap occur error {}", e.getMessage());
        }
        return map;
    }

    public static Map<String, Object> yamlFileToMap(File yamlFile) {
        Map<String, Object> map = new HashMap<>();
        try (FileInputStream inputStream = FileUtils.openInputStream(yamlFile)){
            map = yamlStreamToMap(inputStream);
        } catch (IOException e) {
            log.info("yamlFileToMap occur error {}", e.getMessage());
        }
        return map;
    }

    public static String mapToYaml(Map<String, Object> map) {
        if (MapUtils.isEmpty(map)) {
            return EMPTY;
        }

        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setExplicitStart(true);
        dumperOptions.setExplicitEnd(true);
        return new Yaml(new SafeConstructor(new LoaderOptions()), new Representer(dumperOptions), dumperOptions).dumpAsMap(map);
    }

}
