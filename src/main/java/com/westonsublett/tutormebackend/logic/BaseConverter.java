package com.westonsublett.tutormebackend.logic;

public class BaseConverter {

    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    private final Instruction instruction = new Instruction();

    public String getJson() {
        return instruction.getGson();
    }

    public void convert(String value, int originalBase, int toBase) {
        int decimal = convertToDecimal(originalBase, value);
        String newBase = convertDecimalToBase(toBase, decimal);
        instruction.addInstructions("= " + newBase);
    }

    public int convertToDecimal(int originalBase, String value) {
        int[] values = convertFromHex(value);

        int counter = values.length;

        int output = 0;
        StringBuilder instruct = new StringBuilder();
        boolean first = true;
        for (int val : values) {
            output += val * Math.pow(originalBase, counter--);
            if (!first)
                instruct.append(" + ");
            instruct.append(val).append(" * ").append(originalBase).append("^").append(counter);
            first = false;
        }
        instruct.append(" = ").append(output);
        instruction.addInstructions(instruct.toString());
        return output;
    }

    public String convertDecimalToBase(int toBase, int value) {
        StringBuilder result = new StringBuilder();

        int lastQuotient = 0;

        for (int operatingNumber = value; operatingNumber > toBase; operatingNumber = operatingNumber / toBase) {
            char val = convertToHex(operatingNumber % toBase);
            result.insert(0, val);
            lastQuotient = operatingNumber / toBase;
            instruction.addInstructions("" + operatingNumber + " % " + toBase + " = " + val + ", " + lastQuotient);
        }
        char last = convertToHex(lastQuotient);
        instruction.addInstructions("" + lastQuotient + " % " + toBase + " = " + last);
        result.insert(0, last);

        return result.toString();
    }

    private char convertToHex(int value) {
        return hex[value];
    }

    private int[] convertFromHex(String value) {
        int[] convertedHex = new int[value.length()];
        int charCounter = 0;
        for (char workingChar : value.toCharArray()) {
            for (int counter = 0; counter < hex.length; counter++) {
                char hex = BaseConverter.hex[counter];
                if (workingChar == hex) {
                    convertedHex[charCounter] = values[counter];
                }
            }
            charCounter++;
        }
        return convertedHex;
    }
}
