package Pacage8.TaskTen;

import Pacage8.util.ArrayUtils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static Pacage8.TaskTen.Task.courcesToString;


public class Program {

    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean programExecution;
        public boolean error;
        public boolean help;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (!args[0].equals("-r")) {
                params.error = true;
                params.help = true;
                return params;
            }
            if (args[0].equals("-r")) {
                params.programExecution = true;
            }
            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }

            params.inputFile = args[1];
            if (args.length > 2) {
                params.outputFile = args[2];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }

    public static void main(String[] args)  throws Exception {
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("    -r  // reverse rows");
            out.println("  <cmd> --help");
            System.exit(params.error ? 1 : 0);
        }
        String[][] arr2 = ArrayUtils.readStringArray2FromFile(params.inputFile);
        if (arr2 == null) {
            System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
            System.exit(2);
        }
        if (params.programExecution) {
            var cources = Task.execution(Task.makeStudents(arr2), 3, 2);
            String[][] answer = courcesToString(cources);
            if (params.outputFile == null) {
                PrintStream out = System.out;
                for (int i = 0; i < answer.length; i++) {
                    out.println(Arrays.toString(answer[i]));
                }
            } else {
                PrintStream out = new PrintStream(params.outputFile);
                ArrayUtils.writeArrayToFile(params.outputFile, answer);
                out.close();
            }
        }

    }
}

