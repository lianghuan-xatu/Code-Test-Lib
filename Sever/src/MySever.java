import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MySever {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(8080);
        Socket socket=ss.accept();
        OutputStream os= socket.getOutputStream();
        //读取html资源
        FileInputStream fis=new FileInputStream("Sever/src/index.html");
        byte[] buffer=new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        fis.close();
        os.close();
        socket.close();
        ss.close();
    }
}
