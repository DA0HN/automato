package automato.extract;

import automato.Config;
import automato.rules.Rules;

import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 13/02/2020
 */
public abstract class ExtractService {

    protected List<String[]> param;
    protected List<String> config;

    protected void setParam(List<String[]> param) {
        this.param = param;
    }

    protected void setConfig(List<String> config) {
        this.config = config;
    }

    public List<String[]> getParam() {
        return param;
    }

    public List<String> getConfig() {
        return config;
    }

    public abstract Rules createExtractedRules(List<String> config, List<String[]> param);

    protected Config instantiateConfig(List<String> config) {
        return new Config(config.get(0),    // states,
                          config.get(1),    // alphabet,
                          config.get(2),    // initialState,
                          config.get(3));   // finalState
    }

}
