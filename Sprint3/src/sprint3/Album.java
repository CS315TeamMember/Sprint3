package sprint3;
import java.util.*;


/**
 * Sprint 3
 * @author Alex Dozzi
 * 
 */

public class Album extends PhotographContainer{

	//A string containing the album's name
	private String name;
	
	
	//Array list of photos in the album
	private ArrayList<Photograph> photos = new ArrayList<Photograph>();

	
	/**
	 * Constructor for an Album object. Takes in a string as the name for a given album.
	 * @param (name): name of the album
	 */
	public Album(String name) {
		this.name = name;
	}

	

	

}

