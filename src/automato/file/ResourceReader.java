package automato.file;

import automato.extract.ExtractService;
import automato.rules.Parameter;
import automato.rules.Rules;
import automato.rules.RulesListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * @project automato_finito_deterministico
 * @author Gabriel Honda on 11/02/2020
 */
public class ResourceReader {

    private ExtractService service;

    public ResourceReader(ExtractService service) {
        this.service = service;
    }

    public Rules readAutomatoRules(String path, boolean verbose) {
        List<String> configData = new ArrayList<>();
        List<String[]> functionData = new ArrayList<>();

        try ( BufferedReader buffer = Files.newBufferedReader(Path.of(path)) ) {
            int pointer = 0;

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
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return service.createExtractedRules(configData, functionData);
    }
}
