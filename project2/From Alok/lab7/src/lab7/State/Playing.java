package lab7.State;


import lab7.State.RemoteDevice;

/**
 * Playing.java
 *
 * This file represents the Playing state
 */

public class Playing implements State {
	private RemoteDevice remote;
	
	public Playing(RemoteDevice remote) {
		this.remote = remote;
	}

	// the Play button is pressed
	public boolean pressPlay() {
		System.out.println("The player is already playing.");
		
		return false;
	}

	// the Pause button is pressed
	public boolean pressPause() {
		System.out.println("The player is paused.");
		remote.setState(remote.getPausedState());
		
		return true;
	}

	// the Stop button is pressed
	public boolean pressStop() {
		System.out.println("The player is stopped.");
		remote.setState(remote.getPlayingState());
		remote.setPosition(0);

		return true;
	}

        
        public boolean pressRewind() {
                System.out.println("Can't rewind");
                return false;
        }
        
        public boolean pressLock(){
                System.out.println("System is now locked");
                remote.setState(remote.getLockedState());
                return true;
        }

}
