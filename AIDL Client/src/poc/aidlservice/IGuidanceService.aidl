package poc.aidlservice;

// Copied from the client project.  Unfortunately, copying the interface into the correct package
// in the client app's codebase is the recommended way of distributing an AIDL interface.  Upcoming
// changes to Android's build tools (e.g., the new AAR format and replacing ANT with Graddle and/or
// Maven) may change that but for now, that's how it works.

interface IGuidanceService {
	void resetGuidance();
	boolean markB(boolean completeSwath);
}


