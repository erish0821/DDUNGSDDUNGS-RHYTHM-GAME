package dynamic_beat_last3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	public int score = 0;
	
	
	boolean musicEnd = false;
	public String rank;
	
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
			.getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
			.getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
			.getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	
	
	private String titleName;
	private String musicTitle;
	private Music gameMusic;
	Integer gameScore = 0; //점수 변수
	


  
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Music result = new Music("resultmusic.mp3", false);
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		
		
		
	        

		for(int i = 0; i < noteList.size(); i++)
		{
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, 
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString(Integer.toString(score), 1120, 180);	// 점수
		g.drawString("Score", 1100, 100);
		
		
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);

		

	}
	
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.gif")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
		if(musicEnd) {
			if(score < 5000) rank = "F"; 
			else if(score >= 5000) rank = "C"; 
			else if(score >= 10000) rank = "B"; 
			else if(score >= 20000) rank = "A"; 
			else if(score >= 30000) rank = "S"; 
		}
	}
	
	public void close() {
		gameMusic.close();
		result.start();
		musicEnd = true;
		this.interrupt();
	}
	
	public void dropNotes(String titleName) { //중요한 부분 1초당 500!!!!!!!
		Beat[] beats = null;  //ASAP 비트
	      if(titleName.equals("ASAP")) {
	         int startTime = 3700 - Main.REACH_TIME * 1000;
	         int gap = 100;
	         beats = new Beat[] {
	               
	               new Beat(startTime, "Space"),
	               new Beat(startTime + gap * 2, "Space"),
	               new Beat(startTime + gap * 4, "Space"),
	               
	               new Beat(startTime + gap * 10, "S"),
	               new Beat(startTime + gap * 12, "D"),
	               new Beat(startTime + gap * 16, "F"),
	               new Beat(startTime + gap * 18, "Space"),
	               new Beat(startTime + gap * 21, "K"),
	               
	               new Beat(startTime + gap * 29, "F"),
	               new Beat(startTime + gap * 32, "S"),
	               new Beat(startTime + gap * 34, "K"),
	               new Beat(startTime + gap * 36, "L"),
	               new Beat(startTime + gap * 40, "Space"),
	               
	               new Beat(startTime + gap * 48, "D"),
	               new Beat(startTime + gap * 51, "F"),
	               new Beat(startTime + gap * 54, "L"),
	               new Beat(startTime + gap * 57, "K"),
	               new Beat(startTime + gap * 59, "J"),
	               
	               new Beat(startTime + gap * 66, "S"),
	               new Beat(startTime + gap * 69, "S"),
	               
	               new Beat(startTime + gap * 76, "S"),
	               new Beat(startTime + gap * 80, "D"),
	               new Beat(startTime + gap * 83, "F"),
	               new Beat(startTime + gap * 87, "J"),
	               new Beat(startTime + gap * 93, "J"),
	               new Beat(startTime + gap * 98, "K"),
	               
	               new Beat(startTime + gap * 113, "S"),
	               new Beat(startTime + gap * 117, "K"),
	               new Beat(startTime + gap * 120, "L"),
	               new Beat(startTime + gap * 124, "D"),
	               new Beat(startTime + gap * 129, "K"),
	               new Beat(startTime + gap * 133, "D"),
	               new Beat(startTime + gap * 137, "Space"),
	               
	               new Beat(startTime + gap * 148, "S"),
	               new Beat(startTime + gap * 154, "D"),
	               new Beat(startTime + gap * 156, "F"),
	               new Beat(startTime + gap * 161, "K"),
	               new Beat(startTime + gap * 167, "Space"),
	               new Beat(startTime + gap * 171, "Space"),
	               
	               new Beat(startTime + gap * 187, "S"),
	               new Beat(startTime + gap * 191, "F"),
	               new Beat(startTime + gap * 193, "Space"),
	               new Beat(startTime + gap * 197, "K"),
	               new Beat(startTime + gap * 201, "L"),
	               new Beat(startTime + gap * 207, "F"),
	               new Beat(startTime + gap * 211, "S"),
	               
	               //---------------------------------------------------------------------------------------------------------------
	               
	               new Beat(startTime + gap * 225, "S"),
	               new Beat(startTime + gap * 228, "K"),
	               new Beat(startTime + gap * 231, "F"),
	               new Beat(startTime + gap * 234, "Space"),
	               new Beat(startTime + gap * 237, "K"),
	               new Beat(startTime + gap * 240, "D"),
	               
	               new Beat(startTime + gap * 242, "S"),
	               new Beat(startTime + gap * 245, "F"),
	               new Beat(startTime + gap * 248, "L"),
	               new Beat(startTime + gap * 251, "K"),
	               new Beat(startTime + gap * 254, "Space"),
	               
	               new Beat(startTime + gap * 259, "S"),
	               new Beat(startTime + gap * 263, "F"),
	               new Beat(startTime + gap * 267, "L"),
	               new Beat(startTime + gap * 271, "K"),
	               new Beat(startTime + gap * 274, "Space"),
	               new Beat(startTime + gap * 277, "K"),
	               new Beat(startTime + gap * 281, "L"),
	               new Beat(startTime + gap * 285, "K"),
	               new Beat(startTime + gap * 288, "L"),
	               
	               new Beat(startTime + gap * 300, "Space"),
	               new Beat(startTime + gap * 303, "K"),
	               new Beat(startTime + gap * 306, "L"),
	               new Beat(startTime + gap * 309, "F"),
	               new Beat(startTime + gap * 312, "S"),
	            
	               new Beat(startTime + gap * 318, "Space"),
	               new Beat(startTime + gap * 322, "S"),
	               new Beat(startTime + gap * 325, "F"),
	               new Beat(startTime + gap * 328, "D"),
	               new Beat(startTime + gap * 331, "K"),
	               
	               new Beat(startTime + gap * 336, "Space"),
	               new Beat(startTime + gap * 339, "S"),
	               new Beat(startTime + gap * 342, "F"),
	               new Beat(startTime + gap * 345, "D"),
	               new Beat(startTime + gap * 348, "K"),
	            
	               new Beat(startTime + gap * 364, "Space"),
	               new Beat(startTime + gap * 367, "L"),
	               new Beat(startTime + gap * 371, "K"),
	               new Beat(startTime + gap * 375, "S"),
	               new Beat(startTime + gap * 379, "D"),
	               
	               new Beat(startTime + gap * 438, "Space"),
	               new Beat(startTime + gap * 441, "L"),
	               new Beat(startTime + gap * 444, "K"),
	               new Beat(startTime + gap * 447, "S"),
	               new Beat(startTime + gap * 450, "D"),
	               
	               new Beat(startTime + gap * 536, "S"),
	               new Beat(startTime + gap * 542, "D"),
	               new Beat(startTime + gap * 547, "F"),
	               new Beat(startTime + gap * 552, "J"),
	               new Beat(startTime + gap * 557, "J"),
	               new Beat(startTime + gap * 561, "K"),
	            
	               new Beat(startTime + gap * 574, "S"),
	               new Beat(startTime + gap * 576, "K"),
	               new Beat(startTime + gap * 580, "L"),
	               new Beat(startTime + gap * 584, "D"),
	               new Beat(startTime + gap * 588, "K"),
	               new Beat(startTime + gap * 592, "D"),
	               new Beat(startTime + gap * 596, "Space"),
	               
	               new Beat(startTime + gap * 613, "S"),
	               new Beat(startTime + gap * 619, "D"),
	               new Beat(startTime + gap * 624, "F"),
	               new Beat(startTime + gap * 629, "J"),
	               new Beat(startTime + gap * 634, "J"),
	               new Beat(startTime + gap * 638, "K"),
	               
	               new Beat(startTime + gap * 651, "S"),
	               new Beat(startTime + gap * 653, "K"),
	               new Beat(startTime + gap * 657, "L"),
	               new Beat(startTime + gap * 661, "D"),
	               new Beat(startTime + gap * 666, "K"),
	               new Beat(startTime + gap * 671, "D"),
	               new Beat(startTime + gap * 675, "Space"),
	               
	               // ----------------------------------------
	               
	               
	               
	               new Beat(startTime + gap * 830, "Space"),
	               new Beat(startTime + gap * 832, "Space"),
	               new Beat(startTime + gap * 834, "Space"),
	               
	               new Beat(startTime + gap * 840, "S"),
	               new Beat(startTime + gap * 842, "D"),
	               new Beat(startTime + gap * 846, "F"),
	               new Beat(startTime + gap * 848, "Space"),
	               new Beat(startTime + gap * 851, "K"),
	               
	               new Beat(startTime + gap * 859, "F"),
	               new Beat(startTime + gap * 862, "S"),
	               new Beat(startTime + gap * 864, "K"),
	               new Beat(startTime + gap * 866, "L"),
	               new Beat(startTime + gap * 870, "Space"),
	               
	               new Beat(startTime + gap * 878, "D"),
	               new Beat(startTime + gap * 881, "F"),
	               new Beat(startTime + gap * 884, "L"),
	               new Beat(startTime + gap * 887, "K"),
	               new Beat(startTime + gap * 889, "J"),
	               
	               new Beat(startTime + gap * 896, "S"),
	               new Beat(startTime + gap * 899, "S"),
	               
	               new Beat(startTime + gap * 906, "S"),
	               new Beat(startTime + gap * 910, "D"),
	               new Beat(startTime + gap * 913, "F"),
	               new Beat(startTime + gap * 917, "J"),
	               new Beat(startTime + gap * 923, "J"),
	               new Beat(startTime + gap * 929, "K"),
	               
	               new Beat(startTime + gap * 943, "S"),
	               new Beat(startTime + gap * 947, "K"),
	               new Beat(startTime + gap * 950, "L"),
	               new Beat(startTime + gap * 954, "D"),
	               new Beat(startTime + gap * 959, "K"),
	               new Beat(startTime + gap * 963, "D"),
	               new Beat(startTime + gap * 967, "Space"),
	               
	               new Beat(startTime + gap * 978, "S"),
	               new Beat(startTime + gap * 984, "D"),
	               new Beat(startTime + gap * 986, "F"),
	               new Beat(startTime + gap * 991, "K"),
	               new Beat(startTime + gap * 997, "Space"),
	               new Beat(startTime + gap * 1001, "Space"),
	               
	               new Beat(startTime + gap * 1017, "S"),
	               new Beat(startTime + gap * 1021, "F"),
	               new Beat(startTime + gap * 1023, "Space"),
	               new Beat(startTime + gap * 1027, "K"),
	               new Beat(startTime + gap * 1031, "L"),
	               new Beat(startTime + gap * 1037, "F"),
	               new Beat(startTime + gap * 1041, "S"),
	               
	               new Beat(startTime + gap * 1057, "S"),
	               new Beat(startTime + gap * 1061, "D"),
	               new Beat(startTime + gap * 1066, "F"),
	               new Beat(startTime + gap * 1071, "K"),
	               new Beat(startTime + gap * 1077, "Space"),
	               new Beat(startTime + gap * 1081, "Space"),
	               
	               new Beat(startTime + gap * 1088, "S"),
	               new Beat(startTime + gap * 1092, "F"),
	               new Beat(startTime + gap * 1094, "Space"),
	               new Beat(startTime + gap * 1097, "K"),
	               new Beat(startTime + gap * 1100, "L"),
	               new Beat(startTime + gap * 1108, "S"),
	               new Beat(startTime + gap * 1110, "F"),
	               new Beat(startTime + gap * 1112, "Space"),
	               new Beat(startTime + gap * 1114, "K"),
	               new Beat(startTime + gap * 1116, "L"),
	               
	               new Beat(startTime + gap * 1140, "Space"),
	               new Beat(startTime + gap * 1143, "L"),
	               new Beat(startTime + gap * 1147, "K"),
	               new Beat(startTime + gap * 1151, "S"),
	               new Beat(startTime + gap * 1155, "D"),
	               
	               

	               new Beat(startTime + gap * 1212, "Space"),
	               new Beat(startTime + gap * 1215, "L"),
	               new Beat(startTime + gap * 1219, "K"),
	               new Beat(startTime + gap * 1223, "S"),
	               new Beat(startTime + gap * 1227, "D"),
	               
	                     
	         };
		}
		else if(titleName.equals("Perfect Night")) { //Perfect Night 비트
			int startTime = 14400 - Main.REACH_TIME * 1000;
			int gap = 100;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "F"),
					new Beat(startTime + gap * 8, "K"),
					new Beat(startTime + gap * 10, "L"),
					new Beat(startTime + gap * 12, "K"),
					new Beat(startTime + gap * 14, "S"),
					new Beat(startTime + gap * 16, "D"),
					new Beat(startTime + gap * 18, "J"),
					new Beat(startTime + gap * 20, "Space"),
					new Beat(startTime + gap * 22, "D"),
					new Beat(startTime + gap * 24, "F"),
					new Beat(startTime + gap * 26, "L"),
					new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 32, "K"),
					new Beat(startTime + gap * 34, "D"),
					new Beat(startTime + gap * 36, "S"),
					new Beat(startTime + gap * 38, "J"),
					new Beat(startTime + gap * 40, "Space"),
					new Beat(startTime + gap * 42, "J"),
					new Beat(startTime + gap * 44, "K"),
					new Beat(startTime + gap * 46, "J"),
					new Beat(startTime + gap * 48, "D"),
					new Beat(startTime + gap * 50, "L"),
					new Beat(startTime + gap * 52, "Space"), // 1
					
					new Beat(startTime + gap * 70, "Space"),
					new Beat(startTime + gap * 72, "D"),
					new Beat(startTime + gap * 74, "S"),
					new Beat(startTime + gap * 76, "F"),
					new Beat(startTime + gap * 78, "K"),
					new Beat(startTime + gap * 80, "L"),
					new Beat(startTime + gap * 82, "K"),
					new Beat(startTime + gap * 84, "S"),
					new Beat(startTime + gap * 86, "D"),
					new Beat(startTime + gap * 88, "J"),
					new Beat(startTime + gap * 90, "Space"),
					new Beat(startTime + gap * 92, "D"),
					new Beat(startTime + gap * 94, "F"),
					new Beat(startTime + gap * 96, "L"),
					new Beat(startTime + gap * 98, "K"),
					new Beat(startTime + gap * 100, "Space"),
					new Beat(startTime + gap * 102, "K"),
					new Beat(startTime + gap * 104, "S"),
					new Beat(startTime + gap * 106, "J"),
					new Beat(startTime + gap * 108, "J"),
					new Beat(startTime + gap * 110, "Space"),
					new Beat(startTime + gap * 112, "J"),
					new Beat(startTime + gap * 114, "F"),
					new Beat(startTime + gap * 116, "D"),
					new Beat(startTime + gap * 118, "S"),
					new Beat(startTime + gap * 120, "K"),
					new Beat(startTime + gap * 122, "Space"), //2
					
					
					new Beat(startTime + gap * 137, "Space"),
					new Beat(startTime + gap * 138, "Space"),
					new Beat(startTime + gap * 139, "Space"),
					new Beat(startTime + gap * 140, "Space"),
					new Beat(startTime + gap * 141, "Space"),
					new Beat(startTime + gap * 142, "Space"),
					new Beat(startTime + gap * 143, "Space"),
					new Beat(startTime + gap * 144, "Space"),
					new Beat(startTime + gap * 145, "Space"),
					new Beat(startTime + gap * 146, "Space"),
					new Beat(startTime + gap * 147, "Space"),
					new Beat(startTime + gap * 148, "Space"),
					new Beat(startTime + gap * 149, "Space"),
					new Beat(startTime + gap * 150, "Space"),
					new Beat(startTime + gap * 151, "Space"),
					new Beat(startTime + gap * 152, "Space"),
					new Beat(startTime + gap * 153, "Space"),
					new Beat(startTime + gap * 154, "Space"),
					new Beat(startTime + gap * 155, "Space"),
					new Beat(startTime + gap * 156, "Space"),
					new Beat(startTime + gap * 157, "Space"),
					new Beat(startTime + gap * 158, "Space"),
					new Beat(startTime + gap * 159, "Space"),
					new Beat(startTime + gap * 160, "Space"),
					new Beat(startTime + gap * 161, "Space"),
					new Beat(startTime + gap * 162, "Space"), //3 
					
					
					new Beat(startTime + gap * 172, "S"),
					new Beat(startTime + gap * 174, "K"),
					new Beat(startTime + gap * 178, "F"),
					new Beat(startTime + gap * 182, "L"),
					new Beat(startTime + gap * 190, "Space"),
					new Beat(startTime + gap * 194, "D"),
					new Beat(startTime + gap * 198, "F"),
					new Beat(startTime + gap * 200, "K"),
					new Beat(startTime + gap * 202, "L"),
					
					
					new Beat(startTime + gap * 212, "J"),
					new Beat(startTime + gap * 214, "K"),
					new Beat(startTime + gap * 216, "F"),
					new Beat(startTime + gap * 218, "D"),
					new Beat(startTime + gap * 220, "F"),	
					new Beat(startTime + gap * 222, "L"),
					new Beat(startTime + gap * 224, "K"),	
					new Beat(startTime + gap * 226, "F"),
					new Beat(startTime + gap * 228, "D"),
					new Beat(startTime + gap * 230, "Space"),
					new Beat(startTime + gap * 232, "F"),	
					new Beat(startTime + gap * 234, "K"),
					new Beat(startTime + gap * 236, "L"),	
					new Beat(startTime + gap * 238, "F"),
					
					
					new Beat(startTime + gap * 243, "F"),
					new Beat(startTime + gap * 245, "D"),
					new Beat(startTime + gap * 247, "Space"),
					new Beat(startTime + gap * 249, "F"),	
					new Beat(startTime + gap * 251, "K"),
					new Beat(startTime + gap * 253, "L"),	
					new Beat(startTime + gap * 255, "F"),
					new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 259, "D"),
					new Beat(startTime + gap * 261, "Space"),
					new Beat(startTime + gap * 263, "F"),	
					new Beat(startTime + gap * 265, "K"),
					new Beat(startTime + gap * 267, "L"),	
					new Beat(startTime + gap * 269, "F"),
					new Beat(startTime + gap * 271, "Space"),
					
					
					new Beat(startTime + gap * 280, "J"),
					new Beat(startTime + gap * 282, "K"),
					new Beat(startTime + gap * 284, "F"),
					new Beat(startTime + gap * 286, "D"),
					new Beat(startTime + gap * 288, "F"),	
					new Beat(startTime + gap * 290, "L"),
					new Beat(startTime + gap * 292, "K"),	
					new Beat(startTime + gap * 294, "F"),
					new Beat(startTime + gap * 296, "D"),
					new Beat(startTime + gap * 298, "Space"),
					new Beat(startTime + gap * 300, "F"),	
					new Beat(startTime + gap * 302, "K"),
					new Beat(startTime + gap * 304, "L"),	
					new Beat(startTime + gap * 306, "F"),
					new Beat(startTime + gap * 308, "K"),
					
					
					new Beat(startTime + gap * 317, "F"),
					new Beat(startTime + gap * 319, "D"),
					new Beat(startTime + gap * 321, "Space"),
					new Beat(startTime + gap * 323, "F"),	
					new Beat(startTime + gap * 325, "K"),
					new Beat(startTime + gap * 327, "L"),	
					new Beat(startTime + gap * 329, "F"),
					new Beat(startTime + gap * 331, "K"),
					new Beat(startTime + gap * 333, "D"),
					new Beat(startTime + gap * 335, "Space"),
					new Beat(startTime + gap * 337, "F"),	
					new Beat(startTime + gap * 339, "K"),
					new Beat(startTime + gap * 341, "L"),	
					new Beat(startTime + gap * 343, "F"),
					new Beat(startTime + gap * 345, "Space"),
					
					
					new Beat(startTime + gap * 350, "S"),
					new Beat(startTime + gap * 353, "D"),
					
					new Beat(startTime + gap * 370, "D"),
					new Beat(startTime + gap * 372, "K"),
					new Beat(startTime + gap * 374, "S"),
					new Beat(startTime + gap * 376, "Space"),
					new Beat(startTime + gap * 379, "D"),
					new Beat(startTime + gap * 382, "K"),
					new Beat(startTime + gap * 385, "L"),
					
					new Beat(startTime + gap * 402, "D"),
					new Beat(startTime + gap * 404, "K"),
					new Beat(startTime + gap * 406, "S"),
					new Beat(startTime + gap * 408, "Space"),
					new Beat(startTime + gap * 413, "D"),
					new Beat(startTime + gap * 417, "K"),
					new Beat(startTime + gap * 421, "L"),
					
					new Beat(startTime + gap * 440, "D"),
					new Beat(startTime + gap * 443, "K"),
					new Beat(startTime + gap * 446, "S"),
					new Beat(startTime + gap * 449, "Space"),
					new Beat(startTime + gap * 452, "L"),
					new Beat(startTime + gap * 455, "K"),
					new Beat(startTime + gap * 458, "Space"),
					
					new Beat(startTime + gap * 477, "D"),
					new Beat(startTime + gap * 480, "K"),
					new Beat(startTime + gap * 483, "S"),
					new Beat(startTime + gap * 486, "Space"),
					new Beat(startTime + gap * 489, "L"),
					new Beat(startTime + gap * 492, "K"),
					new Beat(startTime + gap * 495, "Space"),
					
					new Beat(startTime + gap * 502, "F"),
					new Beat(startTime + gap * 505, "D"),
					new Beat(startTime + gap * 507, "Space"),
					new Beat(startTime + gap * 509, "F"),	
					new Beat(startTime + gap * 511, "K"),
					new Beat(startTime + gap * 513, "L"),	
					new Beat(startTime + gap * 515, "F"),
					new Beat(startTime + gap * 517, "K"),
					new Beat(startTime + gap * 519, "D"),
					new Beat(startTime + gap * 521, "Space"),
					new Beat(startTime + gap * 523, "F"),	
					new Beat(startTime + gap * 525, "K"),
					new Beat(startTime + gap * 527, "L"),	
					new Beat(startTime + gap * 529, "F"),
					new Beat(startTime + gap * 531, "Space"),
					new Beat(startTime + gap * 533, "F"),	
					new Beat(startTime + gap * 535, "K"),
					new Beat(startTime + gap * 537, "L"),	
					new Beat(startTime + gap * 539, "F"),
					new Beat(startTime + gap * 541, "Space"),
					new Beat(startTime + gap * 543, "K"),
					new Beat(startTime + gap * 545, "L"),	
					new Beat(startTime + gap * 547, "F"),
					new Beat(startTime + gap * 549, "Space"),
					new Beat(startTime + gap * 552, "F"),
					new Beat(startTime + gap * 554, "Space"),
					
					
					new Beat(startTime + gap * 632, "Space"),
					new Beat(startTime + gap * 633, "Space"),
					new Beat(startTime + gap * 634, "Space"),
					new Beat(startTime + gap * 635, "Space"),
					new Beat(startTime + gap * 636, "Space"),
					new Beat(startTime + gap * 637, "Space"),
					new Beat(startTime + gap * 638, "Space"),
					new Beat(startTime + gap * 639, "Space"),
					new Beat(startTime + gap * 640, "Space"),
					new Beat(startTime + gap * 641, "Space"),
					new Beat(startTime + gap * 642, "Space"),
					new Beat(startTime + gap * 643, "Space"),
					new Beat(startTime + gap * 644, "Space"),
					new Beat(startTime + gap * 645, "Space"),
					new Beat(startTime + gap * 646, "Space"),
					new Beat(startTime + gap * 647, "Space"),
					new Beat(startTime + gap * 648, "Space"),
					new Beat(startTime + gap * 649, "Space"),
					new Beat(startTime + gap * 650, "Space"),
					new Beat(startTime + gap * 651, "Space"),
					new Beat(startTime + gap * 652, "Space"),
					new Beat(startTime + gap * 653, "Space"),
					new Beat(startTime + gap * 654, "Space"),
					new Beat(startTime + gap * 655, "Space"),
					new Beat(startTime + gap * 656, "Space"),
					new Beat(startTime + gap * 657, "Space"), //3 
					
					new Beat(startTime + gap * 667, "S"),
					new Beat(startTime + gap * 669, "K"),
					new Beat(startTime + gap * 671, "F"),
					new Beat(startTime + gap * 673, "L"),
					new Beat(startTime + gap * 675, "Space"),
					new Beat(startTime + gap * 677, "D"),
					new Beat(startTime + gap * 679, "F"),
					new Beat(startTime + gap * 681, "K"),
					new Beat(startTime + gap * 683, "L"),
					
					new Beat(startTime + gap * 693, "J"),
					new Beat(startTime + gap * 695, "K"),
					new Beat(startTime + gap * 697, "F"),
					new Beat(startTime + gap * 699, "D"),
					new Beat(startTime + gap * 701, "F"),	
					new Beat(startTime + gap * 703, "L"),
					new Beat(startTime + gap * 705, "K"),	
					new Beat(startTime + gap * 707, "F"),
					new Beat(startTime + gap * 709, "D"),
					new Beat(startTime + gap * 711, "Space"),
					new Beat(startTime + gap * 713, "F"),	
					new Beat(startTime + gap * 715, "K"),
					new Beat(startTime + gap * 717, "L"),	
					new Beat(startTime + gap * 719, "F"),
						
			};
		}
		else if(titleName.equals("Smoke")) { //Smoke 비트
			int startTime = 150;
			int gap = 100;
			beats = new Beat[] {
					
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 5, "Space"),
					new Beat(startTime + gap * 10, "Space"),
					
					new Beat(startTime + gap * 25, "Space"),
					new Beat(startTime + gap * 30, "Space"),
					new Beat(startTime + gap * 35, "Space"),
					
					new Beat(startTime + gap * 48, "Space"),
					new Beat(startTime + gap * 53, "Space"),
					new Beat(startTime + gap * 58, "Space"),
					
					new Beat(startTime + gap * 71, "F"),
					new Beat(startTime + gap * 71, "J"),
					new Beat(startTime + gap * 76, "D"),
					new Beat(startTime + gap * 76, "K"),
					new Beat(startTime + gap * 83, "S"),
					new Beat(startTime + gap * 83, "L"),
					
					new Beat(startTime + gap * 92, "S"), //나 Hook start
					new Beat(startTime + gap * 94, "J"),
					new Beat(startTime + gap * 96, "D"),
					new Beat(startTime + gap * 98, "K"),
					new Beat(startTime + gap * 100, "F"),
					new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 105, "K"),
					new Beat(startTime + gap * 106, "J"),
					new Beat(startTime + gap * 109, "F"),
					new Beat(startTime + gap * 110, "D"),
					new Beat(startTime + gap * 111, "S"),
					new Beat(startTime + gap * 114, "K"),
					new Beat(startTime + gap * 116, "K"),
					new Beat(startTime + gap * 118, "K"),
					new Beat(startTime + gap * 120, "S"), //하
					new Beat(startTime + gap * 121, "S"),
					new Beat(startTime + gap * 122, "S"),
					new Beat(startTime + gap * 124, "J"),
					new Beat(startTime + gap * 126, "K"),
					new Beat(startTime + gap * 129, "J"),
					new Beat(startTime + gap * 130, "K"), //bike

					new Beat(startTime + gap * 138, "S"), //택도없는
					new Beat(startTime + gap * 140, "D"),
					new Beat(startTime + gap * 142, "F"),
					new Beat(startTime + gap * 144, "D"),
					
					new Beat(startTime + gap * 146, "L"), //것들을 택도안땐 옷 위로
					new Beat(startTime + gap * 148, "K"),
					new Beat(startTime + gap * 149, "J"),
					new Beat(startTime + gap * 151, "K"),
					new Beat(startTime + gap * 153, "L"),
					new Beat(startTime + gap * 155, "L"),
					new Beat(startTime + gap * 157, "K"),
					new Beat(startTime + gap * 159, "J"),
					new Beat(startTime + gap * 161, "K"),
					

					new Beat(startTime + gap * 163, "S"), //STACK IT UP
					new Beat(startTime + gap * 166, "D"),
					new Beat(startTime + gap * 168, "F"),
					new Beat(startTime + gap * 170, "K"),
					new Beat(startTime + gap * 172, "L"),
					new Beat(startTime + gap * 174, "J"),
					new Beat(startTime + gap * 176, "L"),
					new Beat(startTime + gap * 178, "K"),
					new Beat(startTime + gap * 180, "S"),

					new Beat(startTime + gap * 188, "Space"),
					new Beat(startTime + gap * 198, "Space"),
					new Beat(startTime + gap * 208, "Space"),
					new Beat(startTime + gap * 218, "Space"),
					new Beat(startTime + gap * 228, "Space"),
					new Beat(startTime + gap * 238, "Space"),
					new Beat(startTime + gap * 248, "Space"),
					new Beat(startTime + gap * 248, "Space"),
					
					new Beat(startTime + gap * 260, "J"),	//싹다 부수고 원상 복구
					new Beat(startTime + gap * 262, "J"),
					new Beat(startTime + gap * 266, "L"),
					new Beat(startTime + gap * 268, "K"),
					new Beat(startTime + gap * 270, "J"),
					new Beat(startTime + gap * 272, "F"),
					new Beat(startTime + gap * 274, "D"),
					new Beat(startTime + gap * 275, "S"),
					new Beat(startTime + gap * 279, "D"),
					new Beat(startTime + gap * 281, "D"),	//Hook end
					
					new Beat(startTime + gap * 291, "K"),
					new Beat(startTime + gap * 296, "D"),
					new Beat(startTime + gap * 301, "L"),
					new Beat(startTime + gap * 306, "S"),
					new Beat(startTime + gap * 311, "J"),
					new Beat(startTime + gap * 316, "F"),
					new Beat(startTime + gap * 321, "J"),
					new Beat(startTime + gap * 326, "S"),
					new Beat(startTime + gap * 331, "L"),
					new Beat(startTime + gap * 336, "J"),
					new Beat(startTime + gap * 341, "F"),
					new Beat(startTime + gap * 346, "K"),
					new Beat(startTime + gap * 351, "S"),
					new Beat(startTime + gap * 356, "L"),
					new Beat(startTime + gap * 361, "K"),
					new Beat(startTime + gap * 366, "S"),
					new Beat(startTime + gap * 371, "J"),
					new Beat(startTime + gap * 376, "J"),
					new Beat(startTime + gap * 381, "F"),
					new Beat(startTime + gap * 386, "K"),
					new Beat(startTime + gap * 391, "S"),
					new Beat(startTime + gap * 396, "J"),
					new Beat(startTime + gap * 401, "S"),
					new Beat(startTime + gap * 406, "L"),
					new Beat(startTime + gap * 411, "K"),
					new Beat(startTime + gap * 416, "K"),
					new Beat(startTime + gap * 421, "J"),
					new Beat(startTime + gap * 426, "S"),
					new Beat(startTime + gap * 428, "K"),


					
					
			
					

					
					
					

					
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			
			if(i==beats.length) {
				try {
					Thread.sleep(10000);
					close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	public void judge(String input) {
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
		}
		else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
			score += 10;
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
			score += 30;
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
			score += 50;
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
			score += 100;
		}
		else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
			score += 10;
		}
	}
	
}
