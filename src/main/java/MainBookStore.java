import java.io.*;
import java.util.TreeSet;

public class MainBookStore {
    public static void main(String[] args) {

    String home = System.getProperty("user.home");
    TreeSet<Library> books = new TreeSet<>();

    String folderPath=home + File.separator+"Downloads"+File.separator+"Books";
    String fileName="books.txt";

    readBooksFromFile(books,folderPath,fileName);
    fillBooksSet(books);
    saveBooksToFile(books,folderPath,fileName);
     printNewBooksSet(books);// from File
}

    private static void printNewBooksSet(TreeSet<Library> books) {
        for(Library book:books){
            System.out.println(book);
        }
    }

    private static void readBooksFromFile(TreeSet<Library> books,
                                          String folderPath,
                                          String fileName) {
        String filepath= folderPath+File.separator+fileName;
        File fl= new File(filepath);
        if(fl.exists() == false){
            System.out.println("file"+filepath+"not exist");
            return;
        } try {

            FileReader fr = new FileReader(fl);
            BufferedReader br = new BufferedReader(fr);
            while(true){
                String fromFile=br.readLine();

                if(fromFile==null){
                    br.close();
                    break;
                }
                String[] ar =fromFile.split("#");
                String title=ar[0];
                String author=ar[1];
                String description=ar[2];
                int pages=Integer.parseInt(ar[3]);
                double price=Double.parseDouble(ar[4]);
                Library book=new Library(title,author,description,pages,price);
                books.add(book);

            }

        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

private static void saveBooksToFile(TreeSet<Library> books, String folderPath, String fileName) {
        File Folder = new File(folderPath);
        if(!Folder.exists()){
            Folder.mkdir();
        }
        String filePath = folderPath+File.separator+fileName;
        File fl = new File(filePath);
        if(!fl.exists()){
            try {
                fl.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            FileWriter fw = null;
            fw = new FileWriter(fl);

            BufferedWriter bw = new BufferedWriter(fw);
            for(Library book:books){
                String toFile=book.getTitle()
                        + "#" + book.getAuthor() + "#"
                        + book.getDescription() + "#"
                        + book.getPages()+ "#"
                        +book.getPrice();
                bw.write(toFile);
                bw.newLine();

            }
            bw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

      private static void fillBooksSet(TreeSet<Library> books)  {

        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        while(true){
           try{
                System.out.print("Enter Book Title: ");
                String title= br.readLine();

                System.out.print("Enter Book Author: ");
                String author= br.readLine();

                System.out.print("Enter Book Description: ");
                String description= br.readLine();

                System.out.print("Enter Book Pages: ");
                int pages= Integer.parseInt(br.readLine());

                System.out.print("Enter Book Price: ");
                double price= Double.parseDouble(br.readLine());

                Library book=new Library(title,author,description,pages,price);
                books.add(book);
                System.out.println("Another one ? y/n");
                String answer=br.readLine();
                if (answer.equals("n")){
                    br.close();
                    break;
                }

            }catch(Exception e){
           System.out.print(e.getMessage());
            }
        }
        }


    }



