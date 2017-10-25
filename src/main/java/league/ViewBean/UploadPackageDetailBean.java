package league.ViewBean;

public class UploadPackageDetailBean {
	String DVID;
	String USAG;
	String FNSCODE;
	String BS;
	String BSVS;
	String BSLA;
	String CXEB;
	String OS;
	String TZON;
	String SCNRES;
	String FLSVER;

	/**
	 * @return Flash版本
	 */
	public String getFLSVER() {
		return FLSVER;
	}
	/**
	 * @param Flash版本 to set
	 */
	public void setFLSVER(String fLSVER) {
		FLSVER = fLSVER;
	}
	/**
	 * @return 设备GUID
	 */
	public String getDVID() {
		return DVID;
	}
	/**
	 * @param dVID 设备GUID to set
	 */
	public void setDVID(String dVID) {
		DVID = dVID;
	}
	/**
	 * @return the USAG
	 */
	public String getUSAG() {
		return USAG;
	}
	/**
	 * @param uSAG the USAG to set
	 */
	public void setUSAG(String uSAG) {
		USAG = uSAG;
	}
	/**
	 * @return 字体库code
	 */
	public String getFNSCODE() {
		return FNSCODE;
	}
	/**
	 * @param fNSCODE 字体库code to set
	 */
	public void setFNSCODE(String fNSCODE) {
		FNSCODE = fNSCODE;
	}
	/**
	 * @return 浏览器
	 */
	public String getBS() {
		return BS;
	}
	/**
	 * @param bS 浏览器 to set
	 */
	public void setBS(String bS) {
		BS = bS;
	}
	/**
	 * @return 浏览器版本
	 */
	public String getBSVS() {
		return BSVS;
	}
	/**
	 * @param bSVS 浏览器版本 to set
	 */
	public void setBSVS(String bSVS) {
		BSVS = bSVS;
	}
	/**
	 * @return 浏览器语言
	 */
	public String getBSLA() {
		return BSLA;
	}
	/**
	 * @param bSLA 浏览器语言 to set
	 */
	public void setBSLA(String bSLA) {
		BSLA = bSLA;
	}
	/**
	 * @return COOKIE ENABLE
	 */
	public String getCXEB() {
		return CXEB;
	}
	/**
	 * @param cXEB COOKIE ENABLE to set
	 */
	public void setCXEB(String cXEB) {
		CXEB = cXEB;
	}
	/**
	 * @return OS
	 */
	public String getOS() {
		return OS;
	}
	/**
	 * @param oS OS to set
	 */
	public void setOS(String oS) {
		OS = oS;
	}
	/**
	 * @return 时区信息
	 */
	public String getTZON() {
		return TZON;
	}
	/**
	 * @param tZON 时区信息 to set
	 */
	public void setTZON(String tZON) {
		TZON = tZON;
	}
	/**
	 * @return 屏幕分辨率
	 */
	public String getSCNRES() {
		return SCNRES;
	}
	/**
	 * @param sCNRES 屏幕分辨率 to set
	 */
	public void setSCNRES(String sCNRES) {
		SCNRES = sCNRES;
	}

}
