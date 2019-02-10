package FilterServlet;

import java.io.*;
import java.util.*;

public class IpFileReader {

    private ArrayList<String> ipList = new ArrayList<String>();
    private String ip;

    ArrayList<String> getIp(String fileOfForbiddenIp) {
        BufferedReader bufferedFileReader = null;
        try{
            bufferedFileReader = new BufferedReader(new FileReader(fileOfForbiddenIp));

            while ((ip = bufferedFileReader.readLine()) != null) {
                ipList.add(ip);
            }
            return ipList;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                bufferedFileReader.close();
            } catch (IOException ignore) {
                //NOP;
            }
            return ipList;

        }
    }
}
