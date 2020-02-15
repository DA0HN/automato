package automato.rules;

import automato.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 12/02/2020
 */
public class RulesMapImpl implements Rules{

    private final Map<Map<String,String>, String> parameter;
    private final Config config;

    public RulesMapImpl(Config config, Map<Map<String,String>,String> parameter){
        this.parameter = parameter;
        this.config = config;
    }

    private String nextStateForeach(String currentState, String currentValue) {
        // implementação equivalente utilizando for each
        for(Map<String,String> map : parameter.keySet()) {
            if(map.containsKey(currentState) && map.containsValue(currentValue)) {
                return parameter.get(map);
            }
        }
        throw new IllegalStateException("O estado ou o dado atual não estão sendo reconhecidos");
    }

    @Override
    public String nextState(String currentState, String currentValue) {
        Optional<String> collect = parameter.keySet()
                .stream()
                // filtra o Set de Map<String,String> testando se possui a combinação Key,Value
                .filter(m -> m.containsKey(currentState) && m.containsValue(currentValue))
                // ao encontrar a Key do Map paramater insere para obter o Value
                .map(parameter::get)
                .findFirst();   // retorna o primeiro resultado
        return collect.orElseThrow();   // NoSuchElementException
    }

    @Override
    public Config getConfig() {
        return config;
    }
}
