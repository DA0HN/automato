package automato.extract;

import automato.rules.Rules;
import automato.rules.RulesMapImpl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 13/02/2020
 */
public class ExtractMapImpl extends ExtractService{

    private Map<String, Map<String,String>> instantiateTransitionFunction(List<String[]> function) {
        Map<String, Map<String,String>> transitionRules = new Hashtable<>();

        for(String[] command : function) {
            var foo = new Hashtable<String, String>();
            foo.put(command[1], command[2]);
            transitionRules.put(command[0], foo);
        }
        return transitionRules;
    }

    @Override public Rules createExtractedRules(List<String> config, List<String[]> param) {

        var configInstance = instantiateConfig(config);
        var paramInstance = instantiateTransitionFunction(param);

        return new RulesMapImpl(configInstance, paramInstance);
    }
}
