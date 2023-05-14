public class ElectricGuitar extends MusicalInstrument implements Tunable, Specialable{
    private static final int TUNED_NOTES = 30;
    private int notesPlayedSinceTune;
    private boolean distortion;

    public ElectricGuitar() {
        this.name = "Electric Guitar";
        this.notesPlayedSinceTune = 0;
        this.distortion = false;
    }

    @Override
    public int getNSimultaneousNotes() {
        return 6;
    }

    @Override
    public void playNote(Note note) {
        if (this.distortion) {
            Player player = new Player(this.getName());
            if (isOutOfTune()) {
                Note tnote = new Note(note.getNoteIx() - 1, note.getDuration());
                System.out.println("Playing note index:" + tnote.getNoteIx() + ", duration: " + tnote.getDuration());
                player.playNote(tnote);
            } else {
                player.playNote(note);
                System.out.println("Playing note index:" + note.getNoteIx() + ", duration: " + note.getDuration());
            }
        } else {
            Player player = new Player(this.getName());
            if (isOutOfTune()) {
                Note tnote = new Note(note.getNoteIx() - 1, note.getDuration());
                System.out.println("Playing note index:" + tnote.getNoteIx() + ", duration: " + tnote.getDuration());
                player.playNote(tnote);
            } else {
                player.playNote(note);
                System.out.println("Playing note index:" + note.getNoteIx() + ", duration: " + note.getDuration());
            }
            this.notesPlayedSinceTune++;
        }
    }

    public boolean isOutOfTune() {
        return notesPlayedSinceTune >= TUNED_NOTES;
    }

    public void tune() {
        System.out.println("Tuning...");
        notesPlayedSinceTune = 0;
    }

    @Override
    public void doSpecialMove() {
        System.out.println("Doing the Hendrix and playing the \"Star-Spangled Banner\" with my teeth");
    }

    public void setDistortionOn(){
        this.distortion=true;
        this.name = "Distortion Electric Guitar";
    }
    public void setDistortionOff(){
        this.distortion=false;
        this.name = "Electric Guitar";
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
