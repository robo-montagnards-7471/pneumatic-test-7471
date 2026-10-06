package frc.robot.components;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class PCMCompressor {
    private Compressor pcmCompressor;

    private boolean enabled;
    private boolean pressureSwitch;
    private double current;

    public PCMCompressor( int port ) {
        pcmCompressor = new Compressor(port, PneumaticsModuleType.CTREPCM);

        pcmCompressor.enableDigital();
        // pcmCompressor.disable();

        enabled = pcmCompressor.isEnabled();
        pressureSwitch = pcmCompressor.getPressureSwitchValue();
        current = pcmCompressor.getCurrent();
        
        SmartDashboard.putBoolean( "Disabled", false );
        SmartDashboard.putBoolean("PCM Compressor Enabled", enabled);
        SmartDashboard.putBoolean("PCM Pressure Switch", pressureSwitch);
        SmartDashboard.putNumber("PCM Current Draw", current);
    }

    public void toggleEnable() {
        if (pcmCompressor.isEnabled()) {
            pcmCompressor.disable();
            SmartDashboard.putBoolean( "Disabled", true );
        } else {
            pcmCompressor.enableDigital();
            SmartDashboard.putBoolean( "Disabled", false );
        }
    }

    public void poll() {
        enabled = pcmCompressor.isEnabled();
        pressureSwitch = pcmCompressor.getPressureSwitchValue();
        current = pcmCompressor.getCurrent();

        SmartDashboard.putBoolean("PCM Compressor Enabled", enabled);
        SmartDashboard.putBoolean("PCM Pressure Switch", pressureSwitch);
        SmartDashboard.putNumber("PCM Current Draw", current);
    }
}
