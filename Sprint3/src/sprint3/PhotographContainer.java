package sprint3;

import java.util.ArrayList;

public class PhotographContainer {
	
	
	/**
	 * Constructor for a PhotographContainer object. Takes in a string as the name for a given album.
	 * @param (name): name of the album
	 */
	public PhotographContainer(String name) {
		this.name = name;
	}

	//A string containing the album's name
	private String name;
	
	
	//Array list of photos in the album
	private ArrayList<Photograph> photos = new ArrayList<Photograph>();

	
	/**
	 * Accessor for an Album object. Returns the name of the album.  
	 * @return (name): name of the album
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Mutator for an Album object. Rename an album.
	 * @param (name): name of the album
	 */
	public void setName(String name) {
		this.name = name;
	}
			
	public ArrayList<Photograph> getPhotos() {
		return photos;
	}
	
	/**
	 * Method that adds a photograph to an Album object.
	 * @param (p): instance of photograph
	 * @return (boolean): returns true or false
	 */
	public boolean addPhoto(Photograph p) {
			return getPhotos().add(p);		
	}
	
	
	/**
	 * Method that determines if a Photograph is in the Album object.
	 * @param (p): instance of photograph
	 * @return (boolean): returns true or false
	 */
	public boolean hasPhoto(Photograph p) {
		return (getPhotos().contains(p));
		
	}
	
	
	/**
	 * Method that removes a Photograph from an Album if it is in the object.
	 * @param (p): instance of photograph
	 * @return (boolean): returns true or false
	 */
	public boolean removePhoto(Photograph p) {
		return getPhotos().remove(p);
	}
		
	
	
	/**
	 * Method that determines how many Photographs are in the album.
	 * @return (numPhotos): An integer representing the number of photos in the album.
	 */
	public int numPhotographs() {
		return getPhotos().size();
		
	}
	
	
	/**
	 * Method that determines if the current Album  object's  name  value  is  equal  to  the  name  value  of  the  object passed
	 * @param (p): object being compared to the Album object
	 * @return (boolean): returns true or false
	 */
	public boolean equals(Object o) {
		if (o == null){
			return false;
		}
		if (!(o instanceof Album)) {
			return false;
		}
		else {
			Album a = (Album)o;
			
		
			if  (a.getName().equals(name)) {
				return true;
		}
			else {
				return false;
		}
		}
		}
	
			
	/**
	 * Method that returns the Album name and the filenames of the photographs in the Album as a string.
	 * @return (String): String of Album name and photos.
	 * @author Adair Tabb
	 */
	public String toString() {
		ArrayList<String> photographs = new ArrayList<String>();
		for(Photograph photo : photos) {
			photographs.add(photo.getFileName());
		}
		return "Photo Album: " + name + "\nPhotographs: " + photographs;		
	}
	
	
	/**
	 * Returns a unique integer that corresponds to the given Album. Overrides hashcode()
	 * @return (int): Returns an integer.
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
		
		

}
