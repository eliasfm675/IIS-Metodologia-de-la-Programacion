/**
 * 
 */
package uo.mp.lab03.dome.ui;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Dvd;
import uo.mp.lab03.dome.model.VideoGame;
import uo.mp.lab03.dome.service.MediaLibrary;

/**
 * @author uo299673
 *
 */
public class MediaPlayer {

    public void run() {
	Cd cd = new Cd("String", "String", 2, 2, true, "String");
	Dvd dvd = new Dvd("String", "String", 20, true, "String");
	VideoGame vg = new VideoGame("String", 20, "String", true, "String", 20, null);
	MediaLibrary ml = new MediaLibrary();
	ml.add(cd);
	ml.add(dvd);
	ml.add(vg);
	ml.numberOfItemsOwned();
	ml.getResponsables();
    }

}
