package automato.rules;

import automato.Config;

import java.util.Map;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 12/02/2020
 */
public class RulesMapImpl implements Rules{

    private Map<String, Map<String,String>> parameter;
    private Config config;

    public RulesMapImpl(Config config, Map<String,Map<String,String>> parameter){
        this.parameter = parameter;
        this.config = config;
    }

    @Override
    public String nextState(String currentState, String currentValue) {
        return this.parameter
                .get(currentState)  // busca um Map<valorDesejado, proximoEstado>
                .get(currentValue); // insere o valor desejado para recuperar o proximo estado
    }

    @Override
    public Config getConfig() {
        return config;
    }
}
