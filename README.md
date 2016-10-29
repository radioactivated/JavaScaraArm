# JavaScaraArm
Java-based interface for Mason Scioly 2016-17 Robot Arm

Allows user to click on a screen to specify where a robot arm's end effector should go. Designed for SCARA-type arms with two sections, which makes inverse kinematics easier. 

Inverse kinematics and other calculations will be done on the computer. RXTX (https://github.com/rxtx/rxtx) will be used to relay motor angles (steps) to a connected Arduino Mega 2560 with necessary peripherals (drivers) attached.
