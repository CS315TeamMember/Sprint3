package sprint3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Sprint 3
 * @author Alex Dozzi
 * @author Evelina
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
	protected ArrayList<Photograph> photos = new ArrayList<Photograph>();

	
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
	
	/**
	 * @author Evelina
	 * Return an ArrayList of photos from the photos feed that have a rating greater than or equal to the given parameter.
	 * @param rating Desired rating for a photo.
	 * @return result Returns an ArrayList of photos
	 */
	public ArrayList<Photograph> getPhotos(int rating){
		
		if (rating >= 0 && rating <= 5) {
			ArrayList<Photograph>result = new ArrayList<Photograph>();
			for (Photograph photoA : photos) {
				//How do I make sure its the rating for photoA being compared to the goal rating
				if (photoA.getRating() >= rating){
					result.add(photoA);
				}
			}
			return result;
		}
		else {
			return null;
		}
	}	
	
	/**
	 * Returns an ArrayList of photos from the photos from the photos feed that were taken in the year provided.
	 * @author Alex Dozzi
	 * @param year Desired year in which the photo was taken.
	 * @return result Returns an ArrayList of photos
	 */
	public ArrayList<Photograph> getPhotosInYear(int year){
		ArrayList<Photograph>photosInYear = new ArrayList<Photograph>();
		for (Photograph photo: photos) {
			Date currDate = convertStringtoDate(photo.getDateTaken());		
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currDate);
			if (year == calendar.get(Calendar.YEAR)) {
				photosInYear.add(photo);
			}	
		}
		return photosInYear;
	}
		
	/**
	 * Helper method to convert strings to dates.
	 * @author Dr. Olteanu?
	 * @param strDate A string of the current date.
	 * @return Returns an instance of the date object. 
	 * 
	 */
	private Date convertStringtoDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}	
		
	/**
	 * Returns an ArrayList of photos from the photos feed that were taken in the month and year provided.
	 * @author Alex Dozzi
	 * @param month Desired month the photo was taken.
	 * @param year Desired year the photo was taken.
	 * @return result Returns an ArrayList of Photos.
	 */
	public ArrayList<Photograph> getPhotosInMonth(int month, int year){
			ArrayList<Photograph>photosInMonth = new ArrayList<Photograph>();
			for (Photograph photo: photos) {
				Date currDate = convertStringtoDate(photo.getDateTaken());	
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(currDate);
				if (year == calendar.get(Calendar.YEAR) && month == calendar.get(Calendar.MONTH)) {
					photosInMonth.add(photo);
				}
			}
			return photosInMonth;		
		}
	
	/**
	 * Return an ArrayList of photos from the photos feed that were taken between beginDate and endDate(inclusive).
	 * @author Evelina
	 * @param beginDate Set begin date.
	 * @param endDate Set end date.
	 * @return result An ArrayList of photos
	 */
	public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate){
		ArrayList<Photograph>photosBetween = new ArrayList<Photograph>();
		
		Date start = convertStringtoDate(beginDate);
		Date end = convertStringtoDate(endDate);
	
		for (Photograph photo: photos) {
			Date currDate = convertStringtoDate(photo.getDateTaken());	
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currDate);
			if (currDate.before(end) && start.before(currDate)) {
				photosBetween.add(photo);
			}
		}
		return photosBetween;
	
	}

}
