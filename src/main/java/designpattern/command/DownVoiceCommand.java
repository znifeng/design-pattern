package designpattern.command;

public class DownVoiceCommand implements Command {
	MusicPlayer musicPlayer;
	String preVoice;
	
	public DownVoiceCommand(MusicPlayer musicPlayer) {
		this.musicPlayer = musicPlayer;
		preVoice = musicPlayer.getVoice();
	}
	
	@Override
	public void execute() {
		preVoice = musicPlayer.getVoice();
		musicPlayer.down();
	}

	@Override
	public void undo() {
		musicPlayer.setVoice(preVoice);
		System.out.println("Voice changed back to " + musicPlayer.getVoice());
	}
}
