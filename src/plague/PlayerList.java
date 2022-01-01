package plague;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private List<String> players;
    private FileOutputStream outputStream;

    public PlayerList() {
        players = new ArrayList<>();
        try {
            File dataFile = new File(System.getProperty("user.dir") + "/players.txt");
            BufferedReader reader = new BufferedReader(new FileReader(dataFile));
            String a;
            while((a = reader.readLine()) != null){
                players.add(a);
            }
            outputStream = new FileOutputStream(dataFile, true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean hasPlayer(String player){
        if(players.contains(player)) {
            return true;
        } else {
            try{
                outputStream.write((player + '\n').getBytes(StandardCharsets.UTF_8));
                players.add(player);
            } catch (IOException e){
                e.printStackTrace();
            }
            return false;
        }
    }
}
