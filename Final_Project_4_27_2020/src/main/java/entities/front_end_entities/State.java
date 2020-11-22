package entities.front_end_entities;

import javafx.collections.ObservableList;

public class State {
	
	private static State instance = null;	//this is a Singleton
	
	private Search_View sv_UserInput = null;						// Search page
	private ObservableList<Search_View> sv_ResultsList = null;		// Search page
	private Person_View pv = null;									// Person page
	private Business_View bv = null;								// Business Page
	private ObservableList<Acct_View> acctResults = null;			// Accounts page
	private Acct_View av = null;									// Account Page
	
	
	private State() {
		// leave the constructor private & blank because we want one instance only
		// Singleton life
	}
	
	public static State getInstance() {
		if(instance == null)
			instance = new State();
		return instance;
	}

	public Search_View getSV_UserInput() {
		return sv_UserInput;
	}

	public void setSV_UserInput(Search_View sv_UserInput) {
		this.sv_UserInput = sv_UserInput;
	}
	
	public ObservableList<Search_View> getSV_ResultsList() {
		return sv_ResultsList;
	}

	public void setSV_ResultsList(ObservableList<Search_View> sv_ResultsList) {
		this.sv_ResultsList = sv_ResultsList;
	}

	public Person_View getPV() {
		return pv;
	}

	public void setPV(Person_View pv) {
		this.pv = pv;
	}

	public Business_View getBV() {
		return bv;
	}

	public void setBV(Business_View bv) {
		this.bv = bv;
	}

	public ObservableList<Acct_View> getAcctResults() {
		return acctResults;
	}

	public void setAcctResults(ObservableList<Acct_View> acctResults) {
		this.acctResults = acctResults;
	}

	public Acct_View getAV() {
		return av;
	}

	public void setAV(Acct_View av) {
		this.av = av;
	}
	
	/*// Pretty positive we don't need this, oh whale
	 * public boolean isChanged(final State newState) {
		final State oldState = this;
		
		if(oldState == null || newState == null) {
			return false;
		}
		else if( !oldState.sv_UserInput.equals(newState.sv_UserInput) || !oldState.pv.equals(newState.pv) || !oldState.bv.equals(newState.bv)
				|| acctResults.equals(newState.acctResults) || !oldState.av.equals(newState.av) ) {
			setState(newState);
			return true;
		}
		else
			return false;
		
	}
	
	private void setState(final State newState) {
		if(newState != null) { 
			instance = newState;
		}
	}
	 */
}