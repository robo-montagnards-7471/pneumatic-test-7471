package frc.robot.components;

import frc.robot.Config;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SolenoidController {
    DoubleSolenoid double_solenoid;

    private boolean forward;
    private boolean backward;

    public SolenoidController(int forwardPort, int reversePort) {
        double_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, forwardPort, reversePort);

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

        if( forward ) {
            double_solenoid.set( DoubleSolenoid.Value.kForward );
        }
        else if( backward ) {
            double_solenoid.set( DoubleSolenoid.Value.kReverse );
        }
        else {
            double_solenoid.set( DoubleSolenoid.Value.kOff );
        }

        SmartDashboard.putBoolean("Forward", forward);
        SmartDashboard.putBoolean("Backward", backward);
    }
}
