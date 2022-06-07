/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author Admins
 */
public class ConverterAdapter implements USDTarget {
    // ti gia hien tai
    private static final double RATE = 23190;
    
    private final VNDAdaptee adaptee;
    
    public ConverterAdapter(VNDAdaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public double getVNDfromUSD(double USDAmount) {
        if (USDAmount <= 0) return 0;
        double VNDAmount = this.convert(USDAmount);
        return adaptee.getVNDAmount(VNDAmount);
    }
    
    private double convert(double USDAmount) {
        return RATE * USDAmount;
    }
}
