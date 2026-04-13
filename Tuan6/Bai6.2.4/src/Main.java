public class Main {
    public static void main(String[] args) {
        AudioPlayable myAudioPlayer = new AudioPlayer();
        VideoPlayable myVideoPlayer = new VideoPlayer();

        MediaPlayer player = new MediaPlayer(myAudioPlayer, myVideoPlayer);

        System.out.println("--- Bắt đầu phát Media ---");
        player.playAudio("bai_hat_hay.mp3");
        player.playVideo("phim_hanh_dong.mp4");
    }
}