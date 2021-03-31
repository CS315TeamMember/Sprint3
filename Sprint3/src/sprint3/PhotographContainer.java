package sprint3;
import java.util.ArrayList;

/**
 * Sprint 3
 * @author Alex Dozzi
 * 
 */


public class PhotographContainer {
	
	
	public PhotographContainer() {}
	
	/**
	 * Constructor for a PhotographContainer object. Takes in a string as the name for a given album.
	 * @param (name): name of the album
	 */
	public PhotographContainer(String name) {
		this.name = name;
	}

	//A string containing the album's name
	protected String name;
	
	
	//Array list of photos in the album
	private ArrayList<Photograph> photos = new ArrayList<Photograph>();

	
	/**
	 * Accessor for a PhotographContainer object. Returns the name of the PhotographContainer.  
	 * @return (name): name of the PhotographContainer
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Mutator for a PhotographContainer object. Rename a PhotographContainer.
	 * @param (name): name of the PhotographContainer
	 */
	public void setName(String name) {
		this.name = name;
	}
			
	public ArrayList<Photograph> getPhotos() {
		return photos;
	}
	
	/**
	 * Method that adds a photograph to an PhotographContainer object.
	 * @param (p): instance of photograph
	 * @return (boolean): returns true or false
	 */
	public boolean addPhoto(Photograph p) {
			return getPhotos().add(p);		
	}
	
	
	/**
	 * Method that determines if a Photograph is in the PhotographContainer object.
	 * @param (p): instance of photograph
	 * @return (boolean): returns true or false
	 */
	public boolean hasPhoto(Photograph p) {
		return (getPhotos().contains(p));
		
	}
	
	
	/**
	 * Method that removes a Photograph from a PhotographContainer if it is in the object.
	 * @param (p): instance of photograph
	 * @return (boolean): returns true or false
	 */
	public boolean removePhoto(Photograph p) {
		return getPhotos().remove(p);
	}
		
	
	
	/**
	 * Method that determines how many Photographs are in the PhotographContainer.
	 * @return (numPhotos): An integer representing the number of photos in the PhotographContainer.
	 */
	public int numPhotographs() {
		return getPhotos().size();
		
	}
	
	
	/**
	 * Method that determines if the current PhotographContainer  object's  name  value  is  equal  to  the  name  value  of  the  object passed
	 * @param (p): object being compared to the PhotographContainer object
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
	 * Method that returns the PhotographContainer name and the filenames of the photographs in the PhotographContainer as a string.
	 * @return (String): String of PhotographContainer name and photos.
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
	 * Returns a unique integer that corresponds to the given PhotographContainer. Overrides hashcode()
	 * @return (int): Returns an integer.
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
		
		

}
