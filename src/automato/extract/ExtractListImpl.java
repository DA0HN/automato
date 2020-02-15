package automato.extract;

import automato.rules.Parameter;
import automato.rules.Rules;
import automato.rules.RulesListImpl;

import java.util.ArrayList;
import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 13/02/2020
 */
public class ExtractListImpl extends ExtractService {

    @Override public Rules createExtractedRules(List<String> config, List<String[]> param) {
        
        var configInstance = instantiateConfig(config);
        var paramInstance = instantiateTransitionFunction(param);
        
        return new RulesListImpl(paramInstance, configInstance);
    }

    private List<Parameter> instantiateTransitionFunction(List<String[]> param) {
        List<Parameter> transitionRules = new ArrayList<>();

        for(String[] command : param) {
            transitionRules.add(new Parameter(command[0],   // estado atual
                                              command[1],   // string de entrada
                                              command[2])   // proximo estado
            );
        }
        return transitionRules;
    }


}
