import java.io.*;
public class ex
{
    public static void main(String[] args) throws IOException
    {
        File src = new File("original.txt");
        File dest = new File("copie.txt");
        FileReader fr = new FileReader(src);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(dest);
        String str = null;
        while((str = br.readLine()) != null)
        {
            fw.write(str);
            fw.write("\n");
            fw.flush();
        }
        BufferedReader bufferFrom;
        BufferedWriter bufferTo;
        bufferFrom = new BufferedReader(new FileReader("original.txt"));
        bufferTo = new BufferedWriter(new FileWriter("copie.txt"));

        String line = "";
        String trimmedLine = "";
        boolean inComment = false;
        while ( (line = bufferFrom.readLine()) != null) {
            trimmedLine = line.trim();
            if (trimmedLine.startsWith("//")) {
                continue;
            } else if (trimmedLine.startsWith("/*")) {
                inComment = true;
            } else if (trimmedLine.startsWith("*/")) {
                inComment = false;
            } else if (inComment) {
                continue;
            } else {
                bufferTo.write(line+"\n");
            }
        }
        bufferFrom.close();
        bufferTo.close();
        fw.close();
    }



}