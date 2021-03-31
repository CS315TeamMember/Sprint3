/* Sprint 3
 * Evelina Teran
 */

package sprint3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class PhotoLibrary{
	
	/**
	 * "name" is a string containing the PhotoLibrary's name in whatever
	 * form it was provided
	 * 
	 * "id" is an integer containing the PhotoLibrary's unique id. Once
	 * set it will never change.
	 * 
	 * "photos" is an ArrayList<Photograph> of photos the user has posted
	 * to their feed in this library
	 * 
	 * "albums" is a Hashset of Albums that this user created. Each album will
	 * then contain photos from this user's photos stream that they have organized into albums.
	 */
	private String name;
	private final int ID;
	private ArrayList<Photograph> photos = new ArrayList<Photograph>(); // Was declared but not instantiated. Fixed! (: -- Adair
	private HashSet<Album> albums = new HashSet<Album>();
	/**
	 * Constructor for name and id
	 * 
	 * @param name
	 * @param id
	 */
	public PhotoLibrary(String name, int id) {
		this.name = name;
		this.ID = id;		
	}
	
	/**
	 * Accessor/getter for name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Accessor/getter for id
	 * @return ID
	 */
	public int getId() {
		return ID;
	}
	
	/**
	 * Accessor/getter for photos
	 * @return ArrayList for photos
	 */
	public ArrayList<Photograph> getPhotos(){
		return photos;
	}
	
	/**
	 * Mutator/setter for the field name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	/**
	 * Adds the photograph p to the current object's 
	 * photo feed if and only if p is not already in the list
	 * 
	 * @param p represents a photograph
	 * @return boolean operator returns true if photo was added
	 * 		   boolean operator returns false if photo was not added
	 */
	public boolean addPhoto(Photograph p) {
		if (!photos.contains(p)) {
			return photos.add(p);
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param p represents a photograph
	 * @return
	 */
	//Checks to see if p is in the list of photos
	public boolean hasPhoto(Photograph p) {
		if (photos.contains(p)) {
			return getPhotos().contains(p);
		}
		else {
			return false;
		}
	}
	
	//Erases a photo from the feed
	//Modify this one
	public boolean erasePhoto(Photograph p) {
		if (!photos.contains(p)) {
			return false;
		}
		else {
			photos.remove(p);
			albums.remove(p); //removePhotoFromAlbum?
			return getPhotos().remove(p);
		}
		
	}
	/**
	 * Returns the number of photos in a photo feed.
	 * @author Evelina
	 * @return numPhotos 
	 */
	public int numPhotographs() {
		int numPhotos = photos.size();
		return numPhotos;
	}
	
	/**
	 * This method is meant to compare one PhotoLibrary object against the current Photolibrary object and returns true or false depending on if the IDs match.
	 *
	 * @param o The object being compared to the PhotoLibrary object.
	 * @return If the object is not a PhotoLibrary object, it will return false. If the object is a PhotoLibrary object, but its ID is different from the current PhotoLibrary object, the method will return false. If the object is a PhotoLibrary object AND has the same ID as the current Photolibrary object, it will return true.
	 * @author Adair Tabb
	 */
	public boolean equals(Object o) {
		if (!(o instanceof PhotoLibrary)) {
			return false;
		}
		PhotoLibrary that = (PhotoLibrary) o;
		
		return (this.ID == that.ID);
	}
	
	/**
	 * A method to allow PhotoLibrary's field information to be printed as an easily readable String the object is called in a print() or println().
	 * @return A String containing the PhotoLibrary object's fields in an understandable format.
	 * @author Adair Tabb
	 */
	public String toString() {
		ArrayList<String> photographs = new ArrayList<String>();
		for(Photograph photo : photos) {
			photographs.add(photo.toString());
		}
		return "Name: " + name + "\n" + "ID: " + ID + "\n" + "Photos: " + photographs;
	}

	/**
	 * @author Evelina
	 * Compares two photo feeds and seeing how many photos they have in common.
	 * @param a represents a feed of photographs
	 * @param b represents a feed of photographs
	 * @return result The number of photos the two feeds have in common
	 */
	public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b){
		ArrayList<Photograph>aPhotos = a.getPhotos();
		ArrayList<Photograph>bPhotos = b.getPhotos();
		
		ArrayList<Photograph>result = new ArrayList<Photograph>();
		
		// Using for each loops to loop through every photo in the ArrayLists aPhotos and bPhotos
		// Structure for these loops are "for (type variableName : arrayName)"
		for (Photograph photoA : aPhotos) {
			if(bPhotos.contains(photoA)) {
					result.add(photoA);
				}
			}
		return result;
	}
	
	/**
	 * @author Evelina
	 * Returns a measure of how similar the photo beeds are between PhotoLibrary a and PhotoLibrary b, in terms of
	 * a numerical value between 0 and 1.
	 * @param a represents a photo feed
	 * @param b represents a photo feed
	 * @return simVal Returns a value between 0 and 1
	 */
	
	public static double similarity(PhotoLibrary a, PhotoLibrary b) {
		double simVal;
		
		ArrayList<Photograph>result = PhotoLibrary.commonPhotos(a, b);
		if (result.isEmpty()) {
			return 0.0;
		}
		else {
			// number of common photos divided by total number of photos (percentage of similarity)
			simVal = (double)result.size() / ((double)a.numPhotographs() + (double)b.numPhotographs());
			return simVal;
		}
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
	
	/**
	 * Creates a new Album with the name albumName if an Album with that name exists in the set of albums.
	 * @author Evelina
	 * @param albumName Name of the album being created.
	 * @return Returns true if the add was successful, false otherwise.
	 */
	public boolean createAlbum(String albumName) {
		if (!albums.contains(albumName)) {
			Album a1 = new Album(albumName);
			return albums.add(a1);
		}
		else {
			return false;
		}
	}
	
	/**
	 * Removes the Album with name albumName if an Album with that name exists in the set of albums.
	 * @author Evelina
	 * @param albumName Name of the album being removed.
	 * @return Returns true if the remove was successful, false otherwise.
	 */
	public boolean removeAlbum(String albumName) {
		if (!albums.contains(getAlbumByName(albumName))) {
			return false;
		}
		else {
			return albums.remove(getAlbumByName(albumName));
			//return getPhotos().remove(albumName);
		}
	}
	
	/**
	 * Add the Photograph p to the Album in the set of albums that has name albumName if and only if 
	 * it is in the PhotoLibrary's list of photos and it was not already in that album.
	 * @author Evelina
	 * @param p The photo that is being added to the album.
	 * @param albumName The name of the album for which the photo is being added.
	 * @return Returns true if the Photograph was added; return false if it was not added.
	 */
	public boolean addPhotoToAlbum(Photograph p, String albumName) {
		if (photos.contains(p)) {
			return getAlbumByName(albumName).addPhoto(p);
		}
		else {
			return false;
		}
	}
	
	/**
	 * Removes the Photograph p from the Album in the set of albums that has name albumName.
	 * @author Evelina
	 * @param p Photograph that is being removed.
	 * @param albumName Name of the album for which the photo is being removed from.
	 * @return Returns true if the photo was successfully removed. Otherwise return false.
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName) {
		if (hasPhoto(p)) {
			return getAlbumByName(albumName).removePhoto(p);
		}
		else {
			return false;
		}
	}
	
	/**
	 * Given an album name, return the Album with that name from the set of albums.
	 * @author Evelina
	 * @param albumName Name of the album that is being searched for.
	 * @return Returns the Album. If an album with that name is not found, returns null.
	 */
	private Album getAlbumByName(String albumName) {
		Album albumSearched = null;
		for(Album album1: albums) {
			if (album1.getName().equals(albumName)){
				albumSearched = album1;
			}
		}
		return albumSearched;
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
	
	
}
