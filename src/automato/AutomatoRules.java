package automato;

import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class AutomatoRules {

    private final List<Parameter> parameter;
    private final Config config;

    public AutomatoRules(List<Parameter> parameter, Config config) {
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
    public String toString() {
        return "AutomatoRules{" +
                "parameter=" + parameter +
                ", config=" + config +
                '}';
    }
}
