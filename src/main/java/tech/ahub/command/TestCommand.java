package tech.ahub.command;

import tech.ahub.reflection.Command;
import tech.ahub.reflection.CommandClass;

@CommandClass(name = "teste")
public class TestCommand {

    @Command(subcommand = "")
    public void teste(){

    }
}
