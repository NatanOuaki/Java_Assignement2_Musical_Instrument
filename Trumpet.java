public class Trumpet extends MusicalInstrument implements Specialable {
    private static final int TUNED_NOTES = 1;
    private int notesPlayedSinceTune;
    private boolean isMuted;

    public Trumpet() {
        this.name = "Trumpet";
        this.notesPlayedSinceTune = 0;
        this.isMuted = false;
    }

    @Override
    public int getNSimultaneousNotes() {
        return 1;
    }

    @Override
    public void playNote(Note note) {
        Player player = new Player(this.getName());
            player.playNote(note);
            System.out.println("Playing note index:" + note.getNoteIx() + ", duration: " + note.getDuration());
    }

    @Override
    public void doSpecialMove() {
        System.out.println("Improvising like Miles Davis!");
    }

    public void setMuteOn() {
        isMuted = true;
        this.name = "Muted Trumpet";
    }

    public void setMuteOff() {
        isMuted = false;
        this.name = "Trumpet";
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
