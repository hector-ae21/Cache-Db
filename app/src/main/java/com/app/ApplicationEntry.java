package com.app;
import gradle.cliapp.with.lib.template.Cache;
import picocli.CommandLine;

public class ApplicationEntry{
    public static void main(String[] args){
        int exitCode = new CommandLine(new CacheCli())
                .execute(args);
        System.exit(exitCode);
    }
}