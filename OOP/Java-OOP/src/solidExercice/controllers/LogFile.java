package solidExercice.controllers;

import solidExercice.interfaces.File;

public class LogFile implements File {
    private StringBuilder builder;

    public LogFile() {
        this.builder = new StringBuilder();
    }

    @Override
    public void write(String text) {
        this.builder.append(text);
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (int i = 0; i < this.builder.length(); i++) {
            char symbol = this.builder.charAt(i);
            if (Character.isAlphabetic(symbol)) {
                sum += symbol;
            }
        }
        return sum;
    }
}
