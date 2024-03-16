package com.avas.springboot.guice.module;

import com.avas.springboot.guice.annotation.WinWord;
import com.avas.springboot.guice.provider.SpellCheckProvider;
import com.avas.springboot.guice.spellCheck.SpellChecker;
import com.avas.springboot.guice.spellCheck.WinWordSpellChecker;
import com.avas.springboot.guice.spellCheck.WordSpellChecker;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class TextEditorModule extends AbstractModule {
    //1st method to configure interface with concrete implementation
//    @Override
//    protected void configure(){
//        bind(SpellChecker.class).annotatedWith(Names.named("Word")).to(WordSpellChecker.class);
//    }

    // 2nd method which provides complex object.
//    @Provides
//    public SpellChecker provideSpellChecker(){
//        String dbUrl = "jdbc:mysql://localhost:5326/emp";
//        String user = "user";
//        int timeout = 100;
//        return new WordSpellChecker(dbUrl, user, timeout);
//    }

    @Override
    protected void configure(){
        bind(SpellChecker.class).toProvider(SpellCheckProvider.class);
    }


}
