package automato.extract;

import automato.rules.Rules;
import automato.rules.RulesMapImpl;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 13/02/2020
 */
public class ExtractMapImpl extends ExtractService{

    private Map<Map<String,String>, String> instantiateTransitionFunction(List<String[]> function) {
        Map<Map<String,String>, String> transitionRules = new HashMap<>();

        for(String[] command : function) {
            transitionRules.put(valueAndNextStatePair(command[0],   // currentState
                                                      command[1]),  // currentValue
                                command[2]);                        // nextState
        }
        return transitionRules;
    }

    private Map<String,String> valueAndNextStatePair(String value, String nextState){
         Map<String, String> pair = new HashMap<>();
         pair.put(value, nextState);
         return pair;
    }


    @Override public Rules createExtractedRules(List<String> config, List<String[]> param) {

        setConfig(config);
        setParam(param);

        var configInstance = instantiateConfig(config);
        var paramInstance = instantiateTransitionFunction(param);

        return new RulesMapImpl(configInstance, paramInstance);
    }
}
