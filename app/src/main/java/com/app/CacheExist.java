package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utils.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "exist", mixinStandardHelpOptions = true)
public class CacheExist implements Callable<Integer> {


    @CommandLine.Parameters(index = "0", description = "The key to be found")
    private String key;

    @CommandLine.Option(names = {"-collect", "--collection"}, description = "The collection to be used")
    private String collection = "default";

    @Override
    public Integer call() {
        Cache cache = new Cache(Hash.hashCodesHex(collection));
        System.out.println(cache.exists(key));
        return 0;
    }
}