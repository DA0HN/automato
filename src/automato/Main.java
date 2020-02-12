package automato;

public class Main {

    public static void main(String[] args) {

        String str = "2, 1, 2, 1";
        AutomatoRules rules = new ResourceReader().readAutomataRules("src/resources/input.txt", false);

        Automato auto = new Automato(rules, true);
        boolean isAccepted = auto.evaluateExpression(str);

        if(isAccepted) {
            System.out.println("Accept: " + str);
        } else {
            System.out.println("Not accept: " + str);
        }

    }
}
