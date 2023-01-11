package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utils.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "remove", mixinStandardHelpOptions = true)
public class CacheRemove implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The key to be removed")
    private String key;

    @CommandLine.Option(names = {"-collect", "--collection"}, description = "The collection to be used")
    private String collection = "default";


    @Override
    public Integer call() {
        Cache cache = new Cache(Hash.hashCodesHex(collection));
        cache.remove(key);
        System.out.println(1);
        return 0;
    }
}
