package app.beatsmith.servicer;

import org.apache.commons.lang3.StringUtils;

import app.beatsmith.entity.ArgTypes;

public class ArgUtils {
    public static void parseArgs(String[] args) {
        parseShortArgs(args);
        parseLongArgs(args);
    }

    private static void parseLongArgs(String[] args) {
        final ArgTypes[] argTypes = ArgTypes.values();
        for (String arg : args) {
            
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseLongArgs'");
    }

    private static void parseShortArgs(String[] args) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseShortArgs'");
    }
}
