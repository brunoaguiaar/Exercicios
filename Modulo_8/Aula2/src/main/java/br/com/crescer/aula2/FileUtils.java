package br.com.crescer.aula2;

public interface FileUtils {
    boolean mk(String string);

    boolean rm(String string);

    String ls(String string);

    boolean mv(String in, String out);
}
