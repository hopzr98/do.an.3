package entity;

public class ProductDetails {
	private int id;
	private int productId;
	    private String screenTechnology;
	    private String screenResolution;
	    private String glassQuality;
	    private String screenSize;
	    private String rearCameraResolution;
	    private String frontCameraResolution;
	    private String rearCameraDetails;
	    private String videoRecordingCapability;
	    private String cameraFeatures;
	    private String processor;
	    private String chip;
	    private String operatingSystem;
	    private String ram;
	    private String storage;
	    private String mobileNetworkSupport;
	    private String wifiSupport;
	    private String bluetoothSupport;
	    private String gpsSupport;
	    private String connectivityPorts;
	    private String batteryCapacity;
		public ProductDetails(int id, int productId, String screenTechnology, String screenResolution,
				String glassQuality, String screenSize, String rearCameraResolution, String frontCameraResolution,
				String rearCameraDetails, String videoRecordingCapability, String cameraFeatures, String processor,
				String chip, String operatingSystem, String ram, String storage, String mobileNetworkSupport,
				String wifiSupport, String bluetoothSupport, String gpsSupport, String connectivityPorts,
				String batteryCapacity) {
			super();
			this.id = id;
			this.productId = productId;
			this.screenTechnology = screenTechnology;
			this.screenResolution = screenResolution;
			this.glassQuality = glassQuality;
			this.screenSize = screenSize;
			this.rearCameraResolution = rearCameraResolution;
			this.frontCameraResolution = frontCameraResolution;
			this.rearCameraDetails = rearCameraDetails;
			this.videoRecordingCapability = videoRecordingCapability;
			this.cameraFeatures = cameraFeatures;
			this.processor = processor;
			this.chip = chip;
			this.operatingSystem = operatingSystem;
			this.ram = ram;
			this.storage = storage;
			this.mobileNetworkSupport = mobileNetworkSupport;
			this.wifiSupport = wifiSupport;
			this.bluetoothSupport = bluetoothSupport;
			this.gpsSupport = gpsSupport;
			this.connectivityPorts = connectivityPorts;
			this.batteryCapacity = batteryCapacity;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getScreenTechnology() {
			return screenTechnology;
		}
		public void setScreenTechnology(String screenTechnology) {
			this.screenTechnology = screenTechnology;
		}
		public String getScreenResolution() {
			return screenResolution;
		}
		public void setScreenResolution(String screenResolution) {
			this.screenResolution = screenResolution;
		}
		public String getGlassQuality() {
			return glassQuality;
		}
		public void setGlassQuality(String glassQuality) {
			this.glassQuality = glassQuality;
		}
		public String getScreenSize() {
			return screenSize;
		}
		public void setScreenSize(String screenSize) {
			this.screenSize = screenSize;
		}
		public String getRearCameraResolution() {
			return rearCameraResolution;
		}
		public void setRearCameraResolution(String rearCameraResolution) {
			this.rearCameraResolution = rearCameraResolution;
		}
		public String getFrontCameraResolution() {
			return frontCameraResolution;
		}
		public void setFrontCameraResolution(String frontCameraResolution) {
			this.frontCameraResolution = frontCameraResolution;
		}
		public String getRearCameraDetails() {
			return rearCameraDetails;
		}
		public void setRearCameraDetails(String rearCameraDetails) {
			this.rearCameraDetails = rearCameraDetails;
		}
		public String getVideoRecordingCapability() {
			return videoRecordingCapability;
		}
		public void setVideoRecordingCapability(String videoRecordingCapability) {
			this.videoRecordingCapability = videoRecordingCapability;
		}
		public String getCameraFeatures() {
			return cameraFeatures;
		}
		public void setCameraFeatures(String cameraFeatures) {
			this.cameraFeatures = cameraFeatures;
		}
		public String getProcessor() {
			return processor;
		}
		public void setProcessor(String processor) {
			this.processor = processor;
		}
		public String getChip() {
			return chip;
		}
		public void setChip(String chip) {
			this.chip = chip;
		}
		public String getOperatingSystem() {
			return operatingSystem;
		}
		public void setOperatingSystem(String operatingSystem) {
			this.operatingSystem = operatingSystem;
		}
		public String getRam() {
			return ram;
		}
		public void setRam(String ram) {
			this.ram = ram;
		}
		public String getStorage() {
			return storage;
		}
		public void setStorage(String storage) {
			this.storage = storage;
		}
		public String getMobileNetworkSupport() {
			return mobileNetworkSupport;
		}
		public void setMobileNetworkSupport(String mobileNetworkSupport) {
			this.mobileNetworkSupport = mobileNetworkSupport;
		}
		public String getWifiSupport() {
			return wifiSupport;
		}
		public void setWifiSupport(String wifiSupport) {
			this.wifiSupport = wifiSupport;
		}
		public String getBluetoothSupport() {
			return bluetoothSupport;
		}
		public void setBluetoothSupport(String bluetoothSupport) {
			this.bluetoothSupport = bluetoothSupport;
		}
		public String getGpsSupport() {
			return gpsSupport;
		}
		public void setGpsSupport(String gpsSupport) {
			this.gpsSupport = gpsSupport;
		}
		public String getConnectivityPorts() {
			return connectivityPorts;
		}
		public void setConnectivityPorts(String connectivityPorts) {
			this.connectivityPorts = connectivityPorts;
		}
		public String getBatteryCapacity() {
			return batteryCapacity;
		}
		public void setBatteryCapacity(String batteryCapacity) {
			this.batteryCapacity = batteryCapacity;
		}
		@Override
		public String toString() {
			return "ProductDetails [id=" + id + ", productId=" + productId + ", screenTechnology=" + screenTechnology
					+ ", screenResolution=" + screenResolution + ", glassQuality=" + glassQuality + ", screenSize="
					+ screenSize + ", rearCameraResolution=" + rearCameraResolution + ", frontCameraResolution="
					+ frontCameraResolution + ", rearCameraDetails=" + rearCameraDetails + ", videoRecordingCapability="
					+ videoRecordingCapability + ", cameraFeatures=" + cameraFeatures + ", processor=" + processor
					+ ", chip=" + chip + ", operatingSystem=" + operatingSystem + ", ram=" + ram + ", storage="
					+ storage + ", mobileNetworkSupport=" + mobileNetworkSupport + ", wifiSupport=" + wifiSupport
					+ ", bluetoothSupport=" + bluetoothSupport + ", gpsSupport=" + gpsSupport + ", connectivityPorts="
					+ connectivityPorts + ", batteryCapacity=" + batteryCapacity + "]";
		}
	    
	    
}
