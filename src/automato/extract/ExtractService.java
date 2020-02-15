package automato.extract;

import automato.Config;
import automato.rules.Rules;

import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 13/02/2020
 */
public abstract class ExtractService {

    public abstract Rules createExtractedRules(List<String> config, List<String[]> param);

    protected Config instantiateConfig(List<String> config) {
        return new Config(config.get(0),    // states,
                          config.get(1),    // alphabet,
                          config.get(2),    // initialState,
                          config.get(3));   // finalState
    }

}
