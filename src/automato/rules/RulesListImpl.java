package automato.rules;

import automato.Config;

import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 12/02/2020
 */
public class RulesListImpl implements Rules {

    private final List<Parameter> parameter;
    private final Config config;

    public RulesListImpl(List<Parameter> parameter, Config config) {
        this.parameter = parameter;
        this.config = config;
    }

    public List<Parameter> getParameter() {
        return parameter;
    }
    public Config getConfig() {
        return config;
    }

    @Override
    public String nextState(String currentState, String currentValue) {
        for(Parameter param : parameter){
            if(param.getRequiredState().equals(currentState) && param.getRequiredValue().equals(currentValue)) {
                return param.getNextState();
            }
        }
        throw new IllegalStateException("O estado ou o dado atual não estão sendo reconhecidos");
    }

    @Override
    public String toString() {
        return "Rules{" +
                "parameter=" + parameter +
                ", config=" + config +
                '}';
    }
}
