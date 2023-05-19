package com.Alex.javacore.patterns.behavioral.iterator;

public class Numbers {
    public int num[] = {1 , 2, 3};
    public Iterator getIterator() {
        return new NumbersIterator();
    }
    private class NumbersIterator implements Iterator {
        int ind;
        public boolean hasNext() {
            if(ind < num.length) return true;
            return false;
        }
        public Object next() {
            if(this.hasNext()) return num[ind++];
            return null;
        }
    }
}
