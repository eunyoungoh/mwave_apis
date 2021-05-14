package com.cjenm.mwave.apis.common.utils;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder {
    public static CreateMap<String, Object> put(String key, Object val) {
        return new CreateMap<>(key, val);
    }

    public static final class CreateMap<String, Object> {
        private final HashMap<String, Object> map;

        public CreateMap(String key, Object val) {
            map = new HashMap<>();
            map.put(key, val);
        }

        public CreateMap<String, Object> put(String key, Object val) {
            map.put(key, val);
            return this;
        }

        public Map<String, Object> build() {
            return map;
        }
    }
}
