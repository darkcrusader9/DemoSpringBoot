package com.avas.springboot.guice;

import com.avas.springboot.guice.module.TextEditorModule;
import com.avas.springboot.guice.textEditor.TextEditor;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TextEditorModule());
        TextEditor textEditor = injector.getInstance(TextEditor.class);
        System.out.println(textEditor.checkSpelling());
    }
}
