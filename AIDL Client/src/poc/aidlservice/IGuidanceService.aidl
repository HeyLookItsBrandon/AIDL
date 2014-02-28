package poc.aidlservice;

// Copied from the service project.  Unfortunately, copying the interface into the client app's
// codebase is the recommended way of incorporating an AIDL interface into a client project.
// Upcoming changes to Android's build tools (e.g., the new AAR archive format) may or may not
// change that but for now, that's how it works.
// 
// As a potential workaround, I once tried exporting the generated .class files from the service
// project (as a JAR) and importing them into the client project but the project just wouldn't run
// using that approach.

interface IGuidanceService {
	void resetGuidance();
	boolean markB(boolean completeSwath);
}


