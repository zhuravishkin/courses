package com.zhuravishkin.courses.javarush.enumpack;

public enum AppleEnum {
    Jonathan(10), GoldenDel, RedDel, Winesap, Cortland;
    private int price;

    AppleEnum(int price) {
        this.price = price;
    }

    AppleEnum() {
    }

    public int getPrice() {
        return price;
    }
}

class EnumDemo {
    public static void main(String args[]) {
        AppleEnum ap;

        ap = AppleEnum.RedDel;

        // Output an enum value.
        System.out.println("Value of ap: " + ap);
        System.out.println();

        ap = AppleEnum.GoldenDel;

        // Compare two enum values.
        if (ap == AppleEnum.GoldenDel)
            System.out.println("ap contains GoldenDel.\n");

        // Use an enum to control a switch statement.
        switch (ap) {
            case Jonathan:
                System.out.println("Jonathan is red.");
                break;
            case GoldenDel:
                System.out.println("Golden Delicious is yellow.");
                break;
            case RedDel:
                System.out.println("Red Delicious is red.");
                break;
            case Winesap:
                System.out.println("Winesap is red.");
                break;
            case Cortland:
                System.out.println("Cortland is red.");
                break;
        }
        System.out.println();

        for (AppleEnum appleEnum :
             AppleEnum.values()) {
            System.out.println(appleEnum);
        }
        System.out.println();

        System.out.println(AppleEnum.valueOf("RedDel"));

        System.out.println();
        System.out.println(ap.ordinal());

        System.out.println();
        ap = AppleEnum.Jonathan;
        System.out.println(ap.getPrice());
    }
}
