import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        lerArquivo3();
        escreverArquivo1();
        manipulandoPastas();
    }

    public static void lerArquivo1() {
        File file = new File("arquivo.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Erro " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    public static void lerArquivo2() {
        String path = "arquivo.txt";
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void lerArquivo3() {
        String path = "arquivo.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void escreverArquivo1() {
        String[] lines = new String[]{
                "Novo texto01", "Novo texto02", "Novo texto03"
        };
        String path = "escrita.txt";
        //o parâmetro true não recria o arquivo, apenas acrescenta
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void manipulandoPastas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o caminho da pasta: ");
        String strPath = sc.nextLine();
        File path = new File(strPath);
        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("-------------------------------------");
        System.out.println("Pastas");
        for (File folder : folders) {
            System.out.println(folder);
        }
        File[] files = path.listFiles(File::isFile);
        System.out.println("-------------------------------------");
        System.out.println("Arquivos:");
        for (File file : files) {
            System.out.println(file);
        }
        boolean success = new File(strPath + "\\nova pasta").mkdir();
        System.out.println("Directorio criado com successo: " + success);
        sc.close();
    }

    public static void informacaoArquivo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();
        File path = new File(strPath);
        System.out.println("getPath: " + path.getPath());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getName: " + path.getName());
        sc.close();
    }
}