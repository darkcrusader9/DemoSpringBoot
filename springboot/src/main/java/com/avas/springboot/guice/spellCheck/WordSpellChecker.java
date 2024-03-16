package com.avas.springboot.guice.spellCheck;

import javax.inject.Inject;

public class WordSpellChecker implements SpellChecker{
    private String dbUrl;
    private String user;
    private Integer timeout;

    @Inject
    public WordSpellChecker(String dbUrl, String user, Integer timeout) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.timeout = timeout;
    }

    @Override
    public String spellCheck() {
        System.out.println("Inside Word");
        System.out.println(this.dbUrl);
        System.out.println(this.user);
        System.out.println(this.timeout);
        return "Checked using Word";
    }
}
