abstract class Instrument{
    String name;
    int year;

    Instrument(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    abstract String play();
    public String getInstrumentDeteils() {
        return "Instrument: " + name + "\nYear made: " + year;
    }
}

interface Tunable {
    String tune();
    String adjustPitch(boolean up);
}

interface Maintainable {
    String clean();
    String inspect();
}

class StringedInstrument extends Instrument {
    private int numberOfStrings;

    StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year);
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    @Override
    public String play() {
        return "I'm playing a stringed instrument";
    }

    @Override
    public String getInstrumentDeteils() {
        return super.getInstrumentDeteils() + "\nString(s): " + numberOfStrings;
    }

}

class Guitar extends StringedInstrument implements Tunable, Maintainable {
    private String guitarType; //acoustic, electric, etc

    Guitar(String type, String name, int year, int numberOfStrings ) {
        super(name, year, numberOfStrings);
        this.guitarType = type;
    }

    public String getGuitarType() {
        return guitarType;
    }

    @Override
    public String play() {
        return super.play() + ", a " + super.name + " " + guitarType + " guitar";
    }

    @Override
    public String getInstrumentDeteils() {
        return super.getInstrumentDeteils() + "\nType: " + guitarType;
    }

    @Override
    public String tune() {
        return "Tuning the " + super.name + " " + guitarType + " guitar";
    }

    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing the pitch of the guitar" : "Decreasing the pitch of the guitar";
    }

    @Override
    public String clean() {
        return "Cleaning the " + super.name + " " + guitarType + " guitar";
    }

    @Override
    public String inspect() {
        return "Inspecting the " + super.name + " " + guitarType + " guitar, made in year " + year;
    }

}

class Piano extends Instrument implements Tunable, Maintainable {
    private boolean isGrand;

    Piano(String name, int year, boolean isGrand ) {
        super(name, year);
        this.isGrand = isGrand;
    }

    public boolean isItGrand() {
        return isGrand;
    }

    @Override
    public String play() {
        return "I'm playing a " + super.name + " " + (isGrand ? "grand" : "upright")  + " piano";
    }

    @Override
    public String getInstrumentDeteils() {
        return super.getInstrumentDeteils() + "\nType: " + (isGrand ? "grand" : "upright");
    }

    @Override
    public String tune() {
        return "Tuning the " + super.name + " " + (isGrand ? "grand" : "upright") + " piano";
    }

    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing the pitch of the piano" : "Decreasing the pitch of the piano";
    }

    @Override
    public String clean() {
        return "Cleaning the " + super.name + " " + (isGrand ? "grand" : "upright") + " piano";
    }

    @Override
    public String inspect() {
        return "Inspecting the " + super.name + " " + (isGrand ? "grand" : "upright") + " piano, made in year " + year;
    }

}

public class MusicShop {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[10];
        Guitar yamahaGuitar = new Guitar("acoustic","Yamaha",2019,6);
        Piano pianoKawai = new Piano("Kawai", 2023,true);

        instruments[0] = yamahaGuitar;
        instruments[1] = pianoKawai;

        Instrument myNewGuitar = instruments[0];
        Instrument myNewPiano = instruments[1];

        System.out.println("\nTesting overridden methods of abstract class Instrument");
        for (int i = 0; i < instruments.length; i++) {
            if (instruments[i] != null) {
                System.out.println(instruments[i].play());
            }
        }

        System.out.println("\nTesting methods of interfaces Tunable and Maintainable");
        for (Instrument instrument : instruments) {
            if (instrument instanceof Tunable) {
                System.out.println(((Tunable) instrument).tune());
                System.out.println(((Tunable) instrument).adjustPitch(true));
            }
            if (instrument instanceof Maintainable) {
                System.out.println(((Maintainable) instrument).clean());
                System.out.println(((Maintainable) instrument).inspect());
            }
            if (instrument != null) {System.out.println();}
        }

    }
}
