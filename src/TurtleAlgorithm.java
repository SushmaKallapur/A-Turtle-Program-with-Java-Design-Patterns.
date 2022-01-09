// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
/*
    This class handles the file and convert the content into the commands. It also perform that commands.
 */
public class TurtleAlgorithm extends Turtle implements SyntaxTreeExpression{

    private Hashtable<String, Integer> parameters;
    private ArrayList<SyntaxTreeExpression> syntaxTreeCommands;

//  Getter and Setter
    public Hashtable<String, Integer> getParameters() {
        return parameters;
    }

    public void setParameters(Hashtable<String, Integer> parameters) {
        this.parameters = parameters;
    }

    public ArrayList<SyntaxTreeExpression> getSyntaxTreeCommands() {
        return syntaxTreeCommands;
    }

    public void setSyntaxTreeCommands(ArrayList<SyntaxTreeExpression> syntaxTreeCommands) {
        this.syntaxTreeCommands = syntaxTreeCommands;
    }


// Constructor reads the data from file and invoke read data function
    public TurtleAlgorithm(String fileName) {
        syntaxTreeCommands = new ArrayList<SyntaxTreeExpression>();
        parameters = new Hashtable<String, Integer>();

        try {
            String filePath = new File(".").getCanonicalPath() + "/" + fileName;
            File fileLocation = new File(filePath);
            readFileData(fileLocation);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

//  It reads every line in the given file and based on the called syntax tree setup values ,
//  it updates the commands
    private void readFileData(File fileLocation) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileLocation);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String currentLine = bufferedReader.readLine();

        while ((currentLine) != null) {
            SyntaxTreeSetup commands = new SyntaxTreeSetup(currentLine);
            syntaxTreeCommands.add(commands.commandSetup(parameters));
            currentLine = bufferedReader.readLine();

        }
        bufferedReader.close();

    }

//  This method will perform all the commands sequentially
    @Override
    public void accept(SyntaxTreeVisitor syntaxTreeVisitor) {
        Iterator<SyntaxTreeExpression> iterator =   syntaxTreeCommands.iterator();
//      External Iterator
        while (iterator.hasNext()) {
            SyntaxTreeExpression currentCommand = iterator.next();

            if(currentCommand.toString().equals("repeat")) {
                ArrayList<SyntaxTreeExpression> repeatInstructions = new ArrayList<SyntaxTreeExpression>();
                int repeatCounter = ((Repeat) currentCommand).getRepeatCounter();

//              ending the execution of the same command after repeatCounter times
                while (iterator.hasNext()) {
                    SyntaxTreeExpression nextInstruction = iterator.next();
                    if(!nextInstruction.toString().equals("end")) {
                        repeatInstructions.add(nextInstruction);
                    } else {
                        break;
                    }
                }

                for(int i=0;i < repeatCounter; i++) {
//                  Internal iterator
                    repeatInstructions.forEach(instruction -> instruction.accept(syntaxTreeVisitor));
                }
            }
            currentCommand.accept(syntaxTreeVisitor);
        }
        syntaxTreeVisitor.visit(this);

    }

    @Override
    public String toString() {
        return "turtle";
    }
    @Override
    public SyntaxTreeCommand analyze(String expression, Hashtable<String, Integer> parameters) {
        return null;
    }

    @Override
    public void perform(TurtleAlgorithm turtleAlgorithm) {

    }
}
