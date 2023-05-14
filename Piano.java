public class Piano extends MusicalInstrument implements Tunable{
    private static final int TUNED_NOTES = 40;
    private int notesPlayedSinceTune;

    public Piano() {
        this.name = "Piano";
        this.notesPlayedSinceTune = 0;
    }

    @Override
    public int getNSimultaneousNotes() {
        return 10;
    }

    @Override
    public void playNote(Note note) {
        Player player = new Player(this.getName());
        if (isOutOfTune()) {
            Note tnote = new Note(note.getNoteIx() - 1, note.getDuration());
            player.playNote(tnote);
            System.out.println("Playing note index:" + tnote.getNoteIx() + ", duration: " + tnote.getDuration());
        } else {
            player.playNote(note);
            System.out.println("Playing note index:" + note.getNoteIx() + ", duration: " + note.getDuration());
        }
        notesPlayedSinceTune++;
    }
    public boolean isOutOfTune() {
        return notesPlayedSinceTune >= TUNED_NOTES;
    }

    public void tune() {
        System.out.println("Tuning...");
        notesPlayedSinceTune = 0;
    }

    public void playSlide(int from, int to, int duration) {
        if (from < to) {
            for (int i = from; i < to; i++) {
                Note note = new Note(i, duration);
                this.playNote(note);
            }
        } else {
            for (int i = from; i > to; i--) {
                Note note = new Note(i, duration);
                this.playNote(note);
            }
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
