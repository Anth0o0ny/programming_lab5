package com.github.anth0o0ny.programming_lab5;

public enum CommandsEnum {
    HELP("help"),
    INFO("info"),
    SHOW("show"),
    ADD("add"),
    UPDATE("update"),
    REMOVE_BY_ID("remove_by_id"),
    CLEAR("clear"),
    SAVE("save"),
    EXECUTE_SCRIPT("execute_script"),
    EXIT("exit"),
    INSERT_AT("insert_at"),
    ADD_IF_MIN("add_if_min"),
    SHUFFLE("shuffle"),
    REMOVE_ALL_BY_SCREENWRITER("remove_all_by_screenwriter"),
    GROUP_COUNTING_BY_TAGLINE("group_counting_by_tagline"),
    PRINT_DESCENDING("print_descending");



    public String commandName;

    CommandsEnum(String commandName) {
        this.commandName = commandName;
    }
}
