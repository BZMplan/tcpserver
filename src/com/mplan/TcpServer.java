package com.mplan;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
//服务器
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer{
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream out = null;
        try {
            serverSocket =  new ServerSocket(1899);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            out =  new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            System.out.println(out.toString());
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            out.close();
            is.close();
            socket.close();
            serverSocket.close();
        }      
    }
}
