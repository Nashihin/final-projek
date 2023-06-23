import java.util.Arrays;
import java.util.Scanner;

public class PesantrenApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxSantri = 100; // Batas maksimal jumlah santri
        String[] namaSantri = new String[maxSantri]; // Array untuk nama santri
        String[] asramaSantri = new String[maxSantri]; // Array untuk asrama santri
        String[] kelasSantri = new String[maxSantri]; // Array untuk kelas santri
        String[] jenisPelanggaran = new String[maxSantri]; //Array untuk jenis pelanggaran
        String[] hukuman = new String[maxSantri]; // Array untuk hukuman
        int countSantri = 0; // Jumlah santri yang sudah didata

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Santri");
            System.out.println("2. Cari Santri Berdasarkan Jenis Pelanggaran");
            System.out.println("3. Urutkan Santri Berdasarkan Hukuman");
            System.out.println("4. Hapus Data Santri yang Sudah Dihukum");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();

            if (menu == 1) {
                if (countSantri == maxSantri) {
                    System.out.println("Kuota santri sudah penuh.");
                    continue;
                }

                System.out.print("Masukkan nama santri: ");
                scanner.nextLine();
                String nama = scanner.nextLine();
                namaSantri[countSantri] = nama;

                System.out.print("Masukkan asrama santri: ");
                String asrama = scanner.nextLine();
                asramaSantri[countSantri] = asrama;

                System.out.print("Masukkan kelas santri: ");
                String kelas = scanner.nextLine();
                kelasSantri[countSantri] = kelas;

                System.out.print("Masukkan jenis pelanggaran: ");
                String jenis = scanner.nextLine();
                jenisPelanggaran[countSantri] = jenis;

                System.out.print("Masukkan hukuman: ");
                String hukum = scanner.nextLine();
                hukuman[countSantri] = hukum;

                countSantri++;
                System.out.println("Data santri berhasil ditambahkan.");
            } else if (menu == 2) {
                System.out.print("Masukkan jenis pelanggaran yang ingin dicari: ");
                scanner.nextLine();
                String cariJenis = scanner.nextLine();

                boolean found = false;
                for (int i = 0; i < countSantri; i++) {
                    if (jenisPelanggaran[i].equalsIgnoreCase(cariJenis)) {
                        System.out.println("Santri dengan jenis pelanggaran " + cariJenis + " ditemukan:");
                        System.out.println("Nama: " + namaSantri[i]);
                        System.out.println("Asrama: " + asramaSantri[i]);
                        System.out.println("Kelas: " + kelasSantri[i]);
                        System.out.println("Hukuman: " + hukuman[i]);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Santri dengan jenis pelanggaran " + cariJenis + " tidak ditemukan.");
                }
            } else if (menu == 3) {
                // Menggunakan algoritma sorting bubble sort untuk mengurutkan santri berdasarkan hukuman
                for (int i = 0; i < countSantri - 1; i++) {
                    for (int j = 0; j < countSantri - i - 1; j++) {
                        if (hukuman[j].compareToIgnoreCase(hukuman[j + 1]) > 0) {
                            // Tukar posisi nama
                            String tempNama = namaSantri[j];
                            namaSantri[j] = namaSantri[j + 1];
                            namaSantri[j + 1] = tempNama;

                            // Tukar posisi asrama
                            String tempAsrama = asramaSantri[j];
                            asramaSantri[j] = asramaSantri[j + 1];
                            asramaSantri[j + 1] = tempAsrama;

                            // Tukar posisi kelas
                            String tempKelas = kelasSantri[j];
                            kelasSantri[j] = kelasSantri[j + 1];
                            kelasSantri[j + 1] = tempKelas;

                            // Tukar posisi jenis pelanggaran
                            String tempJenis = jenisPelanggaran[j];
                            jenisPelanggaran[j] = jenisPelanggaran[j + 1];
                            jenisPelanggaran[j + 1] = tempJenis;

                            // Tukar posisi hukuman
                            String tempHukum = hukuman[j];
                            hukuman[j] = hukuman[j + 1];
                            hukuman[j + 1] = tempHukum;
                        }
                    }
                }

                System.out.println("Data santri diurutkan berdasarkan hukuman:");
                for (int i = 0; i < countSantri; i++) {
                    System.out.println("Nama: " + namaSantri[i]);
                    System.out.println("Asrama: " + asramaSantri[i]);
                    System.out.println("Kelas: " + kelasSantri[i]);
                    System.out.println("Jenis Pelanggaran: " + jenisPelanggaran[i]);
                    System.out.println("Hukuman: " + hukuman[i]);
                    System.out.println();
                }
            } else if (menu == 4) {
                System.out.print("Masukkan nama santri yang ingin dihapus datanya: ");
                scanner.nextLine();
                String namaHapus = scanner.nextLine();

                boolean found = false;
                int index = -1;
                for (int i = 0; i < countSantri; i++) {
                    if (namaSantri[i].equalsIgnoreCase(namaHapus)) {
                        found = true;
                        index = i;
                        break;
                    }
                }

                if (found) {
                    // Geser data santri setelah index ke posisi sebelumnya
                    for (int i = index; i < countSantri - 1; i++) {
                        namaSantri[i] = namaSantri[i + 1];
                        asramaSantri[i] = asramaSantri[i + 1];
                        kelasSantri[i] = kelasSantri[i + 1];
                        jenisPelanggaran[i] = jenisPelanggaran[i + 1];
                        hukuman[i] = hukuman[i + 1];
                    }

                    countSantri--;
                    System.out.println("Data santri berhasil dihapus.");
                } else {
                    System.out.println("Santri dengan nama " + namaHapus + " tidak ditemukan.");
                }
            } else if (menu == 5) {
                System.out.println("Terima kasih, program selesai.");
                break;
            } else {
                System.out.println("Menu tidak valid.");
            }
        }
    }
}
