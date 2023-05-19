package com.Alex.javacore.patterns.behavioral.strategy;

import java.util.ArrayList;

interface Strategy {
    void download(String file);
}
class DownloadWindowsStrategy implements Strategy {
    public void download(String file) {
        System.out.println("windows download: " + file);
    }
}
class DownloadLinuxStrategy implements Strategy {
    public void download(String file) {
        System.out.println("linux download: " + file);
    }
}
class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void download(String file){
        strategy.download(file);
    }
}

public class StrategyTest {//тест
    public static void main(String[] args) {
        Context context = new Context(new DownloadWindowsStrategy());
        context.download("file.txt");
        context = new Context(new DownloadLinuxStrategy());
        context.download("file.txt");
    }
}