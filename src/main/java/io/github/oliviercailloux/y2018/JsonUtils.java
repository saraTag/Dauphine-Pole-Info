package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonUtils {

	public static Jsonb getInstance(){
        

        return JsonbBuilder.create();
    }
}
