public class Note {
    private int noteIx;
    private int duration;

    // Constructor
    public Note(int noteIx, int duration) {
        this.noteIx = noteIx;
        this.duration = duration;
    }

    // Getters
    public int getNoteIx() {return noteIx;}
    public int getDuration() {return duration;}
}
