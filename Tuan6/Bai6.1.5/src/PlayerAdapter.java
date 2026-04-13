public class PlayerAdapter implements Player {
    OldPlayer oldPlayer;

    public PlayerAdapter() {
        oldPlayer = new OldPlayer();
    }

    @Override
    public void play(String name) {
        oldPlayer.playFile(name);
    }
}
