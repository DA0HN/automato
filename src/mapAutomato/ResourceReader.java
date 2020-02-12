package mapAutomato;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class ResourceReader {

    public AutomatoRules readAutomataRules(String path, boolean verbose) {
        Config config = null;
        Hashtable<Parameter, String> function = null;

        try ( BufferedReader buffer = Files.newBufferedReader(Path.of(path)) ) {
            int pointer = 0;

            List<String> configData = new ArrayList<>();
            List<String[]> functionData = new ArrayList<>();

            while(buffer.ready()) {
                String line = buffer.readLine();
                if( pointer < 4)
                    configData.add(line);
                else{
                    String[] temp = line.split(",");
                    functionData.add(Arrays.stream(temp)
                                     .map(String::trim)
                                     .toArray(String[]::new)
                    );
                }
                pointer++;
            }

            config = instantiateConfig(configData.get(0),       // estados
                                           configData.get(1),   // alfabeto
                                           configData.get(2),   // estado inicial
                                           configData.get(3));  // estado final

            function = instantiateTransitionFunction(functionData);

            if( verbose ){
                System.out.println(config);
                System.out.println("---------------");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return new AutomatoRules(function, config);
    }

    private Hashtable<Parameter, String> instantiateTransitionFunction(List<String[]> function) {
        Hashtable<Parameter, String> transitionRules = new Hashtable<>();

        for(String[] command : function) {
            transitionRules.put(new Parameter(command[0], command[1]), command[2]);
        }
        return transitionRules;
    }

    private Config instantiateConfig(String states, String alphabet, String initialState, String finalState) {
        return new Config(states,
                          alphabet,
                          initialState,
                          finalState);
    }


}
