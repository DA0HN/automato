package automato.rules;

import automato.Config;

import java.util.Map;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 12/02/2020
 */
public class RulesMapImpl implements Rules{

    private Map<Map<String,String>, String> parameter;
    private Config config;

    public RulesMapImpl(Config config, Map<Map<String,String>,String> parameter){
        this.parameter = parameter;
        this.config = config;
    }

    @Override
    public String nextState(String currentState, String currentValue) {
        for(Map<String,String> map : parameter.keySet()) {
            if(map.containsKey(currentState) && map.containsValue(currentValue)) {
                return parameter.get(map);
            }
        }
        throw new IllegalStateException("O estado ou o dado atual não estão sendo reconhecidos");
    }

    @Override
    public Config getConfig() {
        return config;
    }
}
