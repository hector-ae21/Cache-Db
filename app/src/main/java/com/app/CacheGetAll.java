package com.app;

import gradle.cliapp.with.lib.template.Cache;
import gradle.cliapp.with.lib.template.utils.Hash;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "get-all", mixinStandardHelpOptions = true)
public class CacheGetAll implements Callable<Integer> {
        @CommandLine.Option(names = {"-c","--count"}, description = "If count of elements")
        private boolean count;

        @CommandLine.Option(names = {"-collect", "--collection"}, description = "collection")
        private String collection = "default";

        @Override
        public Integer call() {
            Cache cache = new Cache(Hash.hashCodesHex(collection));
            if (count == false) {
                for (String key : cache.getAll()) {
                    System.out.println(key);
                }

            } else {
                System.out.println(cache.size());
            }
            return 0;
        }

}