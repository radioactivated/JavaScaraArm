# JavaScaraArm
Java-based interface for Mason Scioly 2016-17 Robot Arm

Allows user to click on a screen to specify where a robot arm's end effector should go. Designed for SCARA-type arms with two sections, which makes inverse kinematics easier. 

Inverse kinematics and other calculations will be done on the computer. RXTX will be used to relay motor angles (steps) to a connected Arduino Mega 2560 with necessary peripherals (drivers) attached.

RXTX can be downloaded from http://fizzed.com/oss/rxtx-for-java and installed per the instructions at http://rxtx.qbang.org/wiki/index.php/Installation_for_Windows . A copy of the jar is included in lib/, but the installation also requires two DLL files that must be installed locally.

(We are waiting for a licensing issue with the current library setup.)
