import javax.sound.midi.*;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private static final Map<String, Integer> instrumentToIx;
    MidiChannel[] mChannels;

    static {
        instrumentToIx = new HashMap<>();
        instrumentToIx.put("Piano", 0);
        instrumentToIx.put("Electric Guitar", 26);
        instrumentToIx.put("Distortion Electric Guitar", 30);
        instrumentToIx.put("Trumpet", 56);
        instrumentToIx.put("Muted Trumpet", 59);
    }

    public Player(String instrument) {
        try {
            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();

            //get and load default instrument and channel lists
            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            mChannels = midiSynth.getChannels();
            mChannels[0].programChange(instr[instrumentToIx.get(instrument)].getPatch().getProgram());

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playNote(Note note) {
        int noteIx = note.getNoteIx();
        if (noteIx > 0) {
            mChannels[0].noteOn(noteIx, 100);
        }
        try {
            Thread.sleep(note.getDuration()); // wait the duration (in milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (noteIx > 0) {
            mChannels[0].noteOff(noteIx); // turn of the note
        }
    }

}
