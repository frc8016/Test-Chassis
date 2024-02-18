package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{
    private final CANSparkMax m_frontLeft = new CANSparkMax(3, MotorType.kBrushless);
    private final CANSparkMax m_backLeft = new CANSparkMax(1, MotorType.kBrushless);
    private final CANSparkMax m_frontRight = new CANSparkMax(4, MotorType.kBrushless);
    private final CANSparkMax m_backRight = new CANSparkMax(2, MotorType.kBrushless);

    private final DifferentialDrive m_DifferentialDrive = new DifferentialDrive(m_frontLeft, m_frontRight);

    public void arcadeDrive(double speed, double rotation){
        m_DifferentialDrive.arcadeDrive(-speed, -rotation);
        m_frontLeft.setInverted(false);
        m_frontRight.setInverted(true);
    }

    @Override
    public void periodic(){
        m_backLeft.follow(m_frontLeft);
        m_backRight.follow(m_frontRight);
    }
}
