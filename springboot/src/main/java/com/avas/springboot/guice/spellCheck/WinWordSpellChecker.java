package com.avas.springboot.guice.spellCheck;

import com.avas.springboot.guice.spellCheck.SpellChecker;
import com.google.inject.Inject;

public class WinWordSpellChecker implements SpellChecker {

    private String dbUrl;
    private String user;
    private Integer timeout;

    @Inject
    public WinWordSpellChecker(String dbUrl, String user, Integer timeout) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.timeout = timeout;
    }


    @Override
    public String spellCheck() {
        System.out.println("Inside WinWord");
        System.out.println(this.dbUrl);
        System.out.println(this.user);
        System.out.println(this.timeout);

        return "Checked using WinWord";
    }
}
