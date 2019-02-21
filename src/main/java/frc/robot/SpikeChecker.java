/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class SpikeChecker {
/**
 * 
 * @param threshold the number used to determine whether a certain value is a spike or not
 * @param sampleSize how many numbers to take the average of
 * @param bufferSize how many averages to store
 */


    private double threshold;
    private double[] samples, buffer;
    public SpikeChecker(double threshold, int sampleSize, int bufferSize){
        this.threshold = threshold;
        this.samples = new double[sampleSize];
        this.buffer = new double[bufferSize];

        for(int i = 0;i<sampleSize;i++){
            this.samples[i] = 0;
        }
        for(int i = 0;i<bufferSize;i++){
            this.buffer[i] = 0;
        }
    }

    public void addValue(double value){
        for(int i = 1;i<samples.length;i++){
            samples[i-1] = samples[i];
        }
        samples[samples.length-1] = value;
        getAverage();
    }

    private void getAverage(){
        double sum = 0;
        double currentAverage = 0;
        for(double value : samples){
            sum+=value;
        }
        currentAverage = sum/samples.length;

        for(int i = 1;i<buffer.length;i++){
            buffer[i-1] = buffer[i];
        }
        buffer[buffer.length-1] = currentAverage;
        
    }

    public double[] getBuffer(){
        return buffer;
    }
    public double[] getSamples(){
        return samples;
    }

    public boolean didSpike(){
        return (buffer[buffer.length-1]-buffer[0]>threshold);
    }
}
