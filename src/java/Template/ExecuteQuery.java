/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Template;

/**
 *
 * @author Admins
 */
public abstract class ExecuteQuery {
    abstract void begin();
    abstract void query();
    abstract void commit();
 
    public final void execute() {
        begin();
        query();
        commit();
    }
}
