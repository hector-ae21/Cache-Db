package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utils.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "add", mixinStandardHelpOptions = true)
/**
 * Add a new cache entry
 */
public class CacheAdd implements Callable<Integer> {

        @CommandLine.Parameters(index = "0", description = "The key to be added")
        private String key;


        @CommandLine.Parameters(index = "1", description = "The value to be added")
        private String value;

        @CommandLine.Option(names = {"-collect", "--collection"}, description = "The collection to be used")
        private String collection = "default";


    /**
     * Add a new cache entry
     * @return
     * @throws Exception
     */
    @Override
        public Integer call() throws Exception {
            Cache cache = new Cache(Hash.hashCodesHex(collection));
            cache.addNew(key, value);
            System.out.println("Key ===> " + key + "\nValue ===> " + value);
            return 0;
        }
}
