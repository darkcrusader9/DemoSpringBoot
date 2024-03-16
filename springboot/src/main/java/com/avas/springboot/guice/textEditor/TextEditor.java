package com.avas.springboot.guice.textEditor;

import com.avas.springboot.guice.annotation.WinWord;
import com.avas.springboot.guice.spellCheck.SpellChecker;
import com.google.inject.Inject;

import javax.inject.Named;

public class TextEditor {
    private SpellChecker spellChecker;

    @Inject
    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public String checkSpelling(){
        return spellChecker.spellCheck();
    }

}
