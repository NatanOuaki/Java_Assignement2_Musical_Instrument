import java.util.concurrent.TimeUnit;

public class Assignment2 {
    public static void main(String[] args) {
        // Notes for the song "Little Jonathan":
        int[] littleJonathanNoteIxs = new int[] {
                67, 64, 64, 65, 62, 62,
                60, 62, 64, 65, 67, 67, 67,
                67, 64, 64, 65, 62, 62,
                60, 64, 67, 67, 60
        };

        // solve.Note durations the song "Little Jonathan":
        int[] littleJonathanDurations = new int[] {
                250, 250, 500, 250, 250, 500,
                250, 250, 250, 250, 250, 250, 500,
                250, 250, 500, 250, 250, 500,
                250, 250, 250, 250, 1000
        };


        Song littleJonathan = new Song(
                "Little Jonathan", littleJonathanNoteIxs,
                littleJonathanDurations);

        // Playing the piano:
        Piano piano = new Piano();
        System.out.println(piano);

        // Playing a slide:
        System.out.println("\nSlide up...");
        piano.playSlide(60, 72, 50);
        piano.playNote(new Note(72, 1000));
        sleep(1);
        System.out.println("\nAnd slide down...");
        piano.playSlide(72, 60, 50);
        piano.playNote(new Note(60, 1000));

        // Playing the song:
        sleep(1);
        System.out.println();
        piano.playSong(littleJonathan);

        sleep(1);
        System.out.println();
        piano.tune();
        piano.playSong(littleJonathan);

        System.out.println();
        System.out.println(
                piano.getName() + " can play " + piano.getNSimultaneousNotes() +
                        " simultaneous notes.");


        // Playing the electric guitar:
        ElectricGuitar guitar = new ElectricGuitar();
        sleep(1);
        System.out.println();
        System.out.println(guitar);

        // Playing the song:
        System.out.println();
        guitar.playSong(littleJonathan);

        guitar.setDistortionOn();
        sleep(1);
        System.out.println();
        guitar.playSong(littleJonathan);

        guitar.tune();
        guitar.setDistortionOff();
        sleep(1);
        System.out.println();
        guitar.playSong(littleJonathan);

        System.out.println();
        System.out.println(
                guitar.getName() + " can play " + guitar.getNSimultaneousNotes() +
                        " simultaneous notes.");
        guitar.doSpecialMove();

        // Playing the trumpet:
        Trumpet trumpet = new Trumpet();
        sleep(1);
        System.out.println();
        System.out.println(trumpet);

        // Playing the song:
        System.out.println();
        trumpet.playSong(littleJonathan);

        trumpet.setMuteOn();
        sleep(1);
        System.out.println();
        trumpet.playSong(littleJonathan);

        trumpet.setMuteOff();
        sleep(1);
        System.out.println();
        trumpet.playSong(littleJonathan);

        System.out.println();
        System.out.println(
                trumpet.getName() + " can play " + trumpet.getNSimultaneousNotes() +
                        " simultaneous notes.");

        MusicalInstrument[] instruments = new MusicalInstrument[]{trumpet, piano, guitar};
        System.out.println();
        System.out.println("Running the \"doSpecialMoves\" method, doing special moves for all instruments (when applicable):");
        doSpecialMoves(instruments);
        playYourOwnSong();
    }

    public static void doSpecialMoves(MusicalInstrument[] instruments) {
        // TODO: implement your code here.
        for (MusicalInstrument instrument : instruments) {
            if (instrument instanceof Specialable) {
                System.out.println("Doing a special move with " + instrument.getName() + ".");
                ((Specialable) instrument).doSpecialMove();
            } else {
                System.out.println(instrument.getName() + " does not have a special move.");
            }
        }
    }

    public static void playYourOwnSong() {
        // TODO: implement your code here (optional bonus question).
// Notes for the song "Happy Birthday":
        int[] happyBirthdayNoteIxs = new int[] {
                60, 60, 62, 60, 65, 64,
                60, 60, 62, 60, 67, 65,
                60, 60, 72, 69, 65, 64, 62,
                70, 70, 69, 65, 67, 65,
        };

        int[] happyBirthdayDurations = new int[] {
                250, 250, 500, 500, 500, 1000,
                250, 250, 500, 500, 500, 1000,
                250, 250, 500, 500, 500, 500, 500, 500,
                250, 250, 500, 500, 500, 1000
        };

        Song happyBirthday = new Song(
                "Happy Birthday", happyBirthdayNoteIxs,
                happyBirthdayDurations);

        Piano piano = new Piano();
        // Playing the song:
        sleep(1);
        System.out.println();
        piano.playSong(happyBirthday);

        ElectricGuitar guitar = new ElectricGuitar();
        sleep(1);
        // Playing the song:
        System.out.println();
        guitar.playSong(happyBirthday);


        Trumpet trumpet = new Trumpet();
        sleep(1);
        System.out.println();
        System.out.println(trumpet);

        // Playing the song:
        System.out.println();
        trumpet.playSong(happyBirthday);
    }

    private static void sleep(int seconds) {
        // Auxiliary function to delay the program for a given amount of seconds.
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
