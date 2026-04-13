interface AudioPlayable {
    void playAudio(String file);
}

interface VideoPlayable {
    void playVideo(String file);
}
//Chia nhỏ Interface (ISP)

class AudioPlayer implements AudioPlayable {
    @Override
    public void playAudio(String file) {
        System.out.println("Đang phát audio: " + file);
    }
}

class VideoPlayer implements VideoPlayable {
    @Override
    public void playVideo(String file) {
        System.out.println("Đang phát video: " + file);
    }
}

public class MediaPlayer {
    //Chỉ nói rằng đối tượng nó nhận vào biết chơi audio và chơi video chứ không nói rõ nó là loại cụ thể gì, chơi trên web hay chơi trên
    //window, vv để sau này dễ dàng xử lí.
    private AudioPlayable audioPlayer;
    private VideoPlayable videoPlayer;

    //Nói cả 2 phụ thuộc vào abstraction có nghĩa là lớp cha MediaPlayer phụ thuộc vào interface ...Playable, lớp con cũng phụ thuộc vào interface đó.

    // Nhận đối tượng chơi nhạc và chơi video qua constructor (Áp dụng DIP). Ko cần biết trong tương lai nó là cái loại máy chơi gì, chỉ cần biết
    //nó chơi được.

    //=> Sau này muốn thêm các loại Player khác ví dụ WebPlayer thì chỉ cần viết mỗi cái đó thôi, không cần sửa hay đặt if-else gì ở đây.
    public MediaPlayer(AudioPlayable audio, VideoPlayable video) {
        this.audioPlayer = audio;
        this.videoPlayer = video;
    }

    public void playAudio(String file) {
        if (audioPlayer != null) {
            audioPlayer.playAudio(file);
        }
    }

    public void playVideo(String file) {
        if (videoPlayer != null) {
            videoPlayer.playVideo(file);
        }
    }
}