package frc.robot.components;

import frc.robot.Config;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SolenoidController {
    private final Solenoid forward_solenoid;
    private final Solenoid reverse_solenoid;
    
    private boolean forward;
    private boolean backward;

    public SolenoidController(int forwardPort, int reversePort) {
        forward_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, forwardPort);
        reverse_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, reversePort);
        forward = false;
        backward = false;

        SmartDashboard.putBoolean("Forward", false);
        SmartDashboard.putBoolean("Backward", false);
    }

    public void toggleForward() {
        forward = !forward;
        backward = false; // Ensure backward is false when toggling forward
    }

    public void toggleBackward() {
        backward = !backward;
        forward = false; // Ensure forward is false when toggling backward
    }

    public void poll() {

        if (forward) {
            forward_solenoid.set(true);
            reverse_solenoid.set(false);
        } else if (backward) {
            forward_solenoid.set(false);
            reverse_solenoid.set(true);
        } else {
            forward_solenoid.set(false);
            reverse_solenoid.set(false);
        }

        SmartDashboard.putBoolean("Forward", forward);
        SmartDashboard.putBoolean("Backward", backward);
    }
}
