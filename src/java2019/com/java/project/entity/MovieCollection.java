package java2019.com.java.project.entity;

public class MovieCollection {
private Integer mId;
private String mTitle;
private String mDuration;
private String mAuthor;
private String mLink;
private String mSummary;
private String mType;

public MovieCollection() {
	super();
	// TODO Auto-generated constructor stub
}

public MovieCollection(Integer mId, String mTitle, String mDuration, String mAuthor, String mLink, String mSummary,
		String mType) {
	super();
	this.mId = mId;
	this.mTitle = mTitle;
	this.mDuration = mDuration;
	this.mAuthor = mAuthor;
	this.mLink = mLink;
	this.mSummary = mSummary;
	this.mType = mType;

}

public String getmType() {
	return mType;
}
public void setmType(String mType) {
	this.mType = mType;
}
public Integer getmId() {
	return mId;
}
public void setmId(Integer mId) {
	this.mId = mId;
}
public String getmTitle() {
	return mTitle;
}
public void setmTitle(String mTitle) {
	this.mTitle = mTitle;
}
public String getmDuration() {
	return mDuration;
}
public void setmDuration(String mDuration) {
	this.mDuration = mDuration;
}
public String getmAuthor() {
	return mAuthor;
}
public void setmAuthor(String mAuthor) {
	this.mAuthor = mAuthor;
}
public String getmLink() {
	return mLink;
}
public void setmLink(String mLink) {
	this.mLink = mLink;
}
public String getmSummary() {
	return mSummary;
}
public void setmSummary(String mSummary) {
	this.mSummary = mSummary;
}

@Override
public String toString() {
	return "MovieCollection [mId=" + mId + ", mTitle=" + mTitle + ", mDuration=" + mDuration + ", mAuthor=" + mAuthor
			+ ", mLink=" + mLink + ", mSummary=" + mSummary + ", mType=" + mType + "]";
}



}
