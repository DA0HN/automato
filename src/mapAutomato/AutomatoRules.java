package mapAutomato;

import java.util.Hashtable;
import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class AutomatoRules {

    private final Hashtable<Parameter, String> parameter;
    private final Config config;

    public AutomatoRules(Hashtable<Parameter, String> parameter, Config config) {
        this.parameter = parameter;
        this.config = config;
    }

    public Hashtable<Parameter, String> getParameter() {
        return parameter;
    }

    public Config getConfig() {
        return config;
    }

    @Override
    public String toString() {
        return "Rules{" +
                "parameter=" + parameter +
                ", config=" + config +
                '}';
    }
}
