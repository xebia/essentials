package nl.ideal.app.rabobank;

public interface AppCapabilitiesStoreI {

	void setAppReadyToPay(boolean inUse);

	boolean isAppReadyToPay();

}