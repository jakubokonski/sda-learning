public class _24_Enums {
    public static void main(String[] args) {
        Status status = Status.IN_PROGRESS;
        status = Status.SENT;
        status = Status.DELIVERED;

        // status is ordinal and string
        // avoid ordinal
        int i1 = status.ordinal(); // pod jakim indexem jest wartość, raczej mało przydatne, zmiana kolejności w emum zmienia index, dodanie czegość pomiędzy
        System.out.println(status + " ordinal is " + i1);

        String name = status.name();
        System.out.println("status name " + name);

        // how to compare enums
        Status status2 = Status.IN_PROGRESS;
        System.out.println("equals = " + status.equals(status2));
        status = Status.IN_PROGRESS;
        System.out.println("equals = " + status.equals(status2));
        System.out.println("equals == " + (status == status2)); // można, ale lepiej przez equals
        System.out.println(status.getValue());
        if (status.getValue() == 1) {
            System.out.println("In progress");
        }

        // how to convert string to eunum
        Status statusFromString = Status.valueOf("SENT");
        System.out.println("status from string " + statusFromString);

        // enums can be used in switch
        System.out.println("Switch result:");
        switch (statusFromString) {
            case IN_PROGRESS:
                System.out.println("In progress");
                break;
            case SENT:
                System.out.println("Sent");
                break;
            case DELIVERED:
                System.out.println("Delivered");
                break;
        }

    }
}

enum Status {
    IN_PROGRESS(1), SENT(2), DELIVERED(3); // (value) forma konstructora, wywołujemy konstruktory i podajemy wartości

    private int value;

    Status(int value) { // constructor
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}