package com.avas.springboot.guice.provider;


import com.avas.springboot.guice.spellCheck.SpellChecker;
import com.avas.springboot.guice.spellCheck.WinWordSpellChecker;
import com.avas.springboot.guice.spellCheck.WordSpellChecker;
import com.google.inject.Provider;

import java.util.ServiceLoader;

public class SpellCheckProvider implements Provider<SpellChecker> {
    @Override
    public SpellChecker get() {
        String dbUrl = "jdbc:mysql://localhost:5326/emp";
        String user = "user";
        int timeout = 100;
        return new WinWordSpellChecker(dbUrl, user, timeout);
    }
}
