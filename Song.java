public class Song {
    String title;
    private Note[] notes;
    private int nextIndex = 0;

    //Constructor
    public Song(String title, int[] noteIxs, int[] durations) {
        this.title = title;
        this.notes = new Note[noteIxs.length];
        for (int i = 0; i < noteIxs.length; i++) {
            notes[i] = new Note(noteIxs[i], durations[i]);
        }
    }

    //Getter
    public String getTitle() {
        return this.title;
    }

    //Methods
    public boolean hasNext() {
        return nextIndex < notes.length;
    }

    public Note next() {
        Note nextNote = notes[nextIndex];
        nextIndex++;
        return nextNote;
    }

    public void reset() {
        nextIndex = 0;
    }

}
