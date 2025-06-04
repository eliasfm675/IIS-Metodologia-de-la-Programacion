package fernandez_medina_elias_lab03_post;
import src.uo.mp.util.check.ArgumentChecks;

public class Image extends Post{
	private String fileName;
	private String caption;
	public Image(String user) {
		super(user);
		ArgumentChecks.isNotNull(user);
		ArgumentChecks.isNotBlank(user);
		ArgumentChecks.isNotEmpty(user);
		setFileName(fileName);
		setCaption(caption);
	}
	
	/**
	 * @return the fileName
	 */
	protected String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	private void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the caption
	 */
	protected String getCaption() {
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	private void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * Método que devuelve informacion sobre el TextMessage
	 */
	@Override
    public String toString() {
        return "Image: " + getFileName() + ", Caption: " + getCaption() + ", " + super.toString();
    }
	@Override
	public String getFormat() {
		return "<img src = " + fileName  + ">" +  caption + "</img>";
	}
}


