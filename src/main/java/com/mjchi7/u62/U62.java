package com.mjchi7.u62;

import me.ccampo.uuid62.core.util.UUIDUtilsKt;
import picocli.CommandLine;
import picocli.CommandLine.Model.PositionalParamSpec;
import picocli.CommandLine.Model.CommandSpec;

import java.util.UUID;

public class U62 {

    public static void main(String[] args) {
        var spec = CommandSpec.create();
        spec.addPositional(
                PositionalParamSpec.builder()
                        .paramLabel("uuid")
                        .required(true)
                        .type(UUID.class)
                        .description("The uuid to converts")
                        .build()
        );

        var commandLine = new CommandLine(spec);
        commandLine.setExecutionStrategy(U62::run);
        var exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }

    static int run(CommandLine.ParseResult pr) {
        var originalUUID = (UUID) pr.matchedArgs().get(0).getValue();
        var encoded = UUIDUtilsKt.toBase62String(originalUUID);
        System.out.println(encoded);
        return 0;
    }
}
