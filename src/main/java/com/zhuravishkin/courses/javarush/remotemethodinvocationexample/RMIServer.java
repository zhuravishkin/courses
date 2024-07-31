package com.zhuravishkin.courses.javarush.remotemethodinvocationexample;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
    public static final String BINDING_NAME = "server.reverse";

    public static void main(String[] args) {
        System.out.println("Server start...");
        try {
            final MyRemote remoteObject = new MyRemoteImpl();
            final Registry registry = LocateRegistry.createRegistry(1099);
            Remote stub = UnicastRemoteObject.exportObject(remoteObject, 0);
            registry.bind(BINDING_NAME, stub);
            System.out.println("Объект зарегистрирован...");

            Thread.sleep(5000);
            UnicastRemoteObject.unexportObject(remoteObject, false);
            System.out.println("Server stop...");
        } catch (RemoteException | AlreadyBoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface MyRemote extends Remote {
    String reverseString(String string) throws RemoteException;
}

class MyRemoteImpl implements MyRemote {
    @Override
    public String reverseString(String string) throws RemoteException {
        return new StringBuffer(string).reverse().toString();
    }
}
