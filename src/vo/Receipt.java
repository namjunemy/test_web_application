package vo;

public class Receipt {
	private int rNo;
	private int mNo;
	private int pNo;
	private String rDate;
	private String mId;
	private String mName;
	private String pName;
	private String pSize;
	private int pPrice;
	private String pDescription;

	public Receipt() {
	}

	public Receipt setrNo(int rNo) {
		this.rNo = rNo;
		return this;
	}

	public Receipt setmNo(int mNo) {
		this.mNo = mNo;
		return this;
	}

	public Receipt setpNo(int pNo) {
		this.pNo = pNo;
		return this;
	}

	public Receipt setrDate(String rDate) {
		this.rDate = rDate;
		return this;
	}

	public Receipt setmId(String mId) {
		this.mId = mId;
		return this;
	}

	public Receipt setmName(String mName) {
		this.mName = mName;
		return this;
	}

	public Receipt setpName(String pName) {
		this.pName = pName;
		return this;
	}

	public Receipt setpSize(String pSize) {
		this.pSize = pSize;
		return this;
	}

	public Receipt setpPrice(int pPrice) {
		this.pPrice = pPrice;
		return this;
	}

	public Receipt setpDescription(String pDescription) {
		this.pDescription = pDescription;
		return this;
	}

	public int getrNo() {
		return rNo;
	}

	public int getmNo() {
		return mNo;
	}

	public int getpNo() {
		return pNo;
	}

	public String getrDate() {
		return rDate;
	}

	public String getmId() {
		return mId;
	}

	public String getmName() {
		return mName;
	}

	public String getpName() {
		return pName;
	}

	public String getpSize() {
		return pSize;
	}

	public int getpPrice() {
		return pPrice;
	}

	public String getpDescription() {
		return pDescription;
	}
}
