package com.app;

import picocli.CommandLine;

@CommandLine.Command(name = "cache", mixinStandardHelpOptions = true, subcommands = {
        CachePut.class,
        CacheRemove.class,
        CacheExist.class,
        CacheGetKey.class,
        CacheAdd.class,
        CacheGetAll.class,

})
public class CacheCli {
}
