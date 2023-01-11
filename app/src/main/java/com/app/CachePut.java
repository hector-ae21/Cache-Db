package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utils.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "put", mixinStandardHelpOptions = true)
public class CachePut implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The key to be updated")
    private String key;

    @CommandLine.Parameters(index = "1", description = "The value to be updated")
    private String value;

    @CommandLine.Option(names = {"-collect", "--collection"}, description = "The collection to be used")
    private String collection = "default";

    @Override
    public Integer call() {
        Cache cache = new Cache(Hash.hashCodesHex(collection));
        cache.put(key, value);
        System.out.println("Key ===> " + key + "\nValue ===> " + value);
        return 0;
    }
}
