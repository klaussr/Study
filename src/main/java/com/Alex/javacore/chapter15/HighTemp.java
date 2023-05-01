package com.Alex.javacore.chapter15;

interface myFunc1<T> {
    boolean func(T v1, T v2);
}
public class HighTemp {
    private int hTemp;
    HighTemp(int ht) {
        hTemp = ht;
    }

    boolean sameTemp(HighTemp ht2) {
        return hTemp == ht2.hTemp;
    }

    boolean lessThanTemp(HighTemp ht2) {
        return hTemp < ht2.hTemp;
    }
}

class InstanceMethWithObjectRefDemo {
    static <T> int counter(T[] vals, myFunc1<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int count;
        HighTemp[] weekDayHighs = {
                new HighTemp(82), new HighTemp(89), new HighTemp(90), new HighTemp(32), new HighTemp(34), new HighTemp(45), new HighTemp(35)};

        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была 89: " + count);

        HighTemp[] weekDayHighs2 = {
                new HighTemp(84), new HighTemp(79), new HighTemp(90), new HighTemp(38), new HighTemp(34), new HighTemp(45), new HighTemp(65)};

        count = counter(weekDayHighs2, HighTemp::sameTemp, new HighTemp(45));
        System.out.println("Дней, когда максимальная температура была 45: " + count);

        count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(45));
        System.out.println("Дней, когда максимальная температура была меньше 45: " + count);

        count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(90));
        System.out.println("Дней, когда максимальная температура была меньше 90: " + count);

    }
}
