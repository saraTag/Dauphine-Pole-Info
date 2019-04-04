package io.github.oliviercailloux.y2018.dauphine_pole_info;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

public class JsonUtils {

	public static Jsonb getInstance(){
        

        return JsonbBuilder.create();
    }
}
