public abstract class MusicalInstrument {
    protected String name;

    public String getName() {return name;}
    public abstract int getNSimultaneousNotes();
    public abstract void playNote(Note note);

    public void playSong(Song song) {
        System.out.println("Playing "+song.getTitle()+" on "+this.getName());
        while(song.hasNext()){
            playNote(song.next());
        }
        System.out.println("Done playing "+song.getTitle());
        song.reset();
    }

}
