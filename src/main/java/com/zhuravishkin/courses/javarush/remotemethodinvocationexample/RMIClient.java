package com.zhuravishkin.courses.javarush.remotemethodinvocationexample;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static final String BINDING_NAME = "server.reverse";

    public static void main(String[] args) {
        try {
            final Registry registry = LocateRegistry.getRegistry(1099);
            MyRemote remoteObject = (MyRemote) registry.lookup(BINDING_NAME);
            System.out.println(remoteObject.reverseString("Server running!"));
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
