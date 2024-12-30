/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI;

import java.rmi.*;

/**
 *
 * @author Admin
 */
public interface ByteService extends Remote {

    public byte[] requestData(String studentCode, String qCode) throws RemoteException;

    public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}
