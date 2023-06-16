/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codepaarizky;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CodePAARizky extends JFrame {

    int[][] labirin = new int[][]{
        //Membuat array untuk labirin dengan ukuran 15x15
        {0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
        {1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0},
        {1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
        {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1},
        {0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
        {1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0},
        {1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0},
        {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //0=Jalan
    //1=Tembok
    //2=Posisi awal Droid Merah
    //3=Posisi awal Droid Hijau
    /*
        //Array labirin ukuran 10x10
        {0, 0, 1, 0, 1, 1, 0, 0, 0, 0,},
        {1, 0, 2, 0, 1, 1, 0, 1, 1, 0,},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 1, 1, 0, 1, 1, 1, 1, 0,},
        {1, 0, 1, 1, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 1, 1, 1, 0, 1,},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 1,},
        {0, 1, 0, 1, 1, 0, 1, 0, 1, 1,},
        {0, 0, 0, 0, 1, 0, 1, 3, 0, 0,},
        {0, 1, 1, 0, 0, 0, 0, 0, 1, 1,},
        /*
        
     */};

    //Membuat variabel fitur
    JButton AcakPeta;
    JButton AcakDroidMerah;
    JButton AcakDroidHijau;
    JButton TambahDroidMerah;
    JButton KurangiDroidMerah;
    JButton Mulai;
    JButton Berhenti;
    JButton PandanganDroidMerah;
    JButton PandanganDroidHijau;
    JButton Keluar;
    JSlider Slider;

    //Acak array
    boolean repaint = false;

    private int radius = 0;

    public CodePAARizky() {
        //Pengaturan frame
        setTitle("Mencari dan Menghindar (2101020040-Rizky Ramadhani Kalingga Putra)");
        setSize(790, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        ImageIcon icon = new ImageIcon("merah-hijau.jpeg");
        setIconImage(icon.getImage());
        setVisible(true);

        //Membuat nama fitur
        AcakPeta = new JButton("Acak Peta");
        AcakDroidMerah = new JButton("Acak Droid Merah");
        AcakDroidHijau = new JButton("Acak Droid Hijau");
        TambahDroidMerah = new JButton("Tambah Droid Merah");
        KurangiDroidMerah = new JButton("Kurangi Droid Merah");
        Mulai = new JButton("Mulai");
        Berhenti = new JButton("Berhenti");
        PandanganDroidMerah = new JButton("Pandangan Droid Merah");
        PandanganDroidHijau = new JButton("Pandangan Droid Hijau");
        Keluar = new JButton("Keluar");
        Slider = new JSlider(0, 5, 0);

        //Menambahkan fitur
        add(AcakPeta);
        add(AcakDroidMerah);
        add(AcakDroidHijau);
        add(TambahDroidMerah);
        add(KurangiDroidMerah);
        add(Mulai);
        add(Berhenti);
        add(PandanganDroidMerah);
        add(PandanganDroidHijau);
        add(Keluar);
        add(Slider);

        //Posisi fitur
        Slider.setBounds(530, 20, 175, 50);
        AcakPeta.setBounds(530, 75, 175, 25);
        AcakDroidMerah.setBounds(530, 110, 175, 25);
        AcakDroidHijau.setBounds(530, 145, 175, 25);
        TambahDroidMerah.setBounds(530, 180, 175, 25);
        KurangiDroidMerah.setBounds(530, 215, 175, 25);
        Mulai.setBounds(530, 250, 175, 25);
        Berhenti.setBounds(530, 285, 175, 25);
        PandanganDroidMerah.setBounds(530, 320, 175, 25);
        PandanganDroidHijau.setBounds(530, 355, 175, 25);
        Keluar.setBounds(530, 390, 175, 25);

        radius = Slider.getValue(); // Inisialisasi radius dengan nilai awal slider

        Slider.setPaintTicks(true);
        Slider.setPaintLabels(true);

        Slider.setMajorTickSpacing(1);
        Slider.setMinorTickSpacing(1);

        setVisible(true);

        //MEMBUAT JIKA MENEKAN FITUR
        //Jika menggeser slider
        Slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                JSlider source = (JSlider) event.getSource();
                if (!source.getValueIsAdjusting()) {
                    // Mendapatkan nilai radius dari slider
                    radius = source.getValue();

                    // Memperbarui persegi pandangan droid hijau
                    int[][] updatedLabirin = PandanganDroidHijau(radius);
                }
            }
        });

        //Jika menekan fitur Acak Peta
        AcakPeta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x[][] = AcakPeta();
                repaint = true;
                restore(x);
                repaint();
            }
        });

        //Jika menekan fitur Acak Droid Merah
        AcakDroidMerah.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x[][] = AcakDroidMerah();
                restore(x);
                repaint();
            }
        });

        //Jika menekan fitur Acak Droid Hijau
        AcakDroidHijau.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x[][] = AcakDroidHijau();
                restore(x);
                repaint();
            }
        });

        //Jika menekan fitur Tambah Droid Merah
        TambahDroidMerah.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x[][] = TambahDroidMerah();
                restore(x);
                repaint();
            }
        });

        //Jika menekan fitur Kurangi Droid Merah
        KurangiDroidMerah.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x[][] = KurangiDroidMerah();
                restore(x);
                repaint();
            }
        });

        // Jika menekan fitur Mulai
        Mulai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startMoving();
            }
        });

        //Jika menekan fitur Berhenti
        Berhenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopMoving();
            }
        });

        //Jika menekan fitur Pandangan Droid Merah
        PandanganDroidMerah.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x[][] = PandanganDroidMerah();
                restore(x);
                repaint();
            }
        });

        //Jika menekan fitur Pandangan Droid Hijau
        PandanganDroidHijau.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] x = PandanganDroidHijau(radius);
                restore(x);
                repaint();
            }
        });

        //Jika menekan fitur Keluar
        Keluar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  //menutup aplikasi
            }
        });
    }

    //Buat array yang akan datang sama dengan array labirin
    //Untuk mengembalikan peta ke keadaan awal
    public void restore(int[][] savedLabirint) {
        for (int i = 0; i < labirin.length; i++) {
            for (int j = 0; j < labirin.length; j++) {
                labirin[i][j] = savedLabirint[i][j];
            }
        }
    }

    //MEMBUAT FUNGSI JIKA FITUR SUDAH DITEKAN
    //Fungsi Acak Peta
    public int[][] AcakPeta() {
        int[][] arr = new int[15][15];
        Random rnd = new Random();
        int min = 0;
        int high = 1;

        //Inisialisasi semua sel dengan tembok (1)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = 1;
            }
        }

        //Isi sel-sel dengan jalan (0)
        for (int i = 0; i < arr.length; i += 2) {
            for (int j = 0; j < arr[0].length; j += 2) {
                arr[i][j] = 0;
            }
        }

        //Buat jalur melalui sel-sel jalan (0)
        for (int i = 0; i < arr.length; i += 2) {
            for (int j = 0; j < arr[0].length; j += 2) {
                if (i > 0) {
                    arr[i - 1][j] = arr[i - 1][j] == 0 ? 0 : rnd.nextInt((high - min) + 1) + min;
                }
                if (j > 0) {
                    arr[i][j - 1] = arr[i][j - 1] == 0 ? 0 : rnd.nextInt((high - min) + 1) + min;
                }
                if (i < arr.length - 1) {
                    arr[i + 1][j] = arr[i + 1][j] == 0 ? 0 : rnd.nextInt((high - min) + 1) + min;
                }
                if (j < arr[0].length - 1) {
                    arr[i][j + 1] = arr[i][j + 1] == 0 ? 0 : rnd.nextInt((high - min) + 1) + min;
                }
            }
        }

        //Mempertahankan posisi Droid Merah ketika peta diacak
        for (int i = 0; i < labirin.length; i++) {
            for (int j = 0; j < labirin.length; j++) {
                if (labirin[i][j] == 2) {
                    arr[i][j] = 2;
                }
            }
        }

        //Mempertahankan posisi Droid Hijau ketika peta diacak
        for (int i = 0; i < labirin.length; i++) {
            for (int j = 0; j < labirin.length; j++) {
                if (labirin[i][j] == 3) {
                    arr[i][j] = 3;
                }
            }
        }
        return arr;
    }

    //Fungsi Acak Droid Merah
    public int[][] AcakDroidMerah() {
        int[][] arr = new int[labirin.length][labirin.length];
        Random rand = new Random();
        int row, col;

        //copy nilai labirin ke arr
        for (int i = 0; i < labirin.length; i++) {
            for (int j = 0; j < labirin.length; j++) {
                arr[i][j] = labirin[i][j];
            }
        }

        //cari posisi droid merah dan simpan ke variabel row dan col
        for (int i = 0; i < labirin.length; i++) {
            for (int j = 0; j < labirin.length; j++) {
                if (labirin[i][j] == 2) {
                    row = i;
                    col = j;
                    arr[row][col] = 0; // hapus droid merah dari posisi semula
                }
            }
        }

        //pilih random posisi baru untuk droid merah yang valid
        while (true) {
            row = rand.nextInt(labirin.length);
            col = rand.nextInt(labirin.length);

            if (arr[row][col] == 0) {
                arr[row][col] = 2; // letakkan droid merah di posisi baru
                break;
            }
        }

        return arr;
    }

    //Fungsi Acak Droid Hijau
    public int[][] AcakDroidHijau() {
        int[][] arr = new int[labirin.length][labirin.length];
        Random rand = new Random();
        int row = 0, col = 0;

        // copy nilai labirin ke arr
        for (int i = 0; i < labirin.length; i++) {
            for (int j = 0; j < labirin.length; j++) {
                arr[i][j] = labirin[i][j];
            }
        }

        // cari posisi droid hijau dan simpan ke variabel row dan col
        for (int i = 0; i < labirin.length; i++) {
            for (int j = 0; j < labirin.length; j++) {
                if (labirin[i][j] == 3) {
                    row = i;
                    col = j;
                    arr[row][col] = 0; // hapus droid hijau dari posisi semula
                }
            }
        }

        // pilih random posisi baru untuk droid hijau yang valid
        while (true) {
            int m = rand.nextInt(labirin.length);
            int n = rand.nextInt(labirin.length);

            if (arr[m][n] == 0 && (m != row || n != col)) {
                arr[m][n] = 3; // letakkan droid hijau di posisi baru
                break;
            }
        }

        return arr;
    }

    //Fungsi Tambah Droid Merah
    public int[][] TambahDroidMerah() {
        int[][] arr = labirin.clone(); // clone labirin agar tidak merubah labirin asli
        Random rnd = new Random();

        // Posisi droid merah yang baru
        int row = rnd.nextInt(arr.length);
        int col = rnd.nextInt(arr[0].length);

        // Cari posisi jalan yang kosong untuk menempatkan droid merah
        while (arr[row][col] != 0) {
            row = rnd.nextInt(arr.length);
            col = rnd.nextInt(arr[0].length);
        }

        // Tambahkan droid merah pada posisi yang telah dipilih
        arr[row][col] = 2;

        return arr;
    }

    //Fungsi kurangi Droid Merah
    private final int MIN_DROID_MERAH = 1; // batas minimal droid merah yang diinginkan

    public int[][] KurangiDroidMerah() {
        int[][] arr = labirin.clone(); // clone labirin agar tidak merubah labirin asli
        int countDroidMerah = 0;

        // Hitung jumlah droid merah yang ada di dalam labirin
        for (int[] row : arr) {
            for (int val : row) {
                if (val == 2) {
                    countDroidMerah++;
                }
            }
        }

        // Jika jumlah droid merah lebih besar dari batas minimal, kurangi satu droid merah
        if (countDroidMerah > MIN_DROID_MERAH) {
            Random rnd = new Random();

            // Pilih salah satu droid merah secara acak untuk dihapus
            while (true) {
                int row = rnd.nextInt(arr.length);
                int col = rnd.nextInt(arr[0].length);

                if (arr[row][col] == 2) {
                    arr[row][col] = 0;
                    break;
                }
            }
        }

        return arr;
    }

    // Fungsi Mulai dan Berhenti
    // Deklarasi variabel global
    private boolean stopMoving = false;
    private boolean stopGreen = false;

    // Fungsi untuk menghentikan gerakan
    private void stopMoving() {
        stopMoving = true;
        stopGreen = true;
    }

    // Fungsi untuk memulai gerakan
    private void startMoving() {
        stopMoving = false;
        stopGreen = false;

        Thread moveThread = new Thread(() -> {
            // Temukan posisi awal droid merah
            int startXRed = -1;
            int startYRed = -1;

            // Temukan posisi awal droid hijau
            int startXGreen = -1;
            int startYGreen = -1;

            // Cari posisi awal droid merah dan hijau
            for (int i = 0; i < labirin.length; i++) {
                for (int j = 0; j < labirin[i].length; j++) {
                    if (labirin[i][j] == 2) {
                        startXRed = i;
                        startYRed = j;
                    } else if (labirin[i][j] == 3) {
                        startXGreen = i;
                        startYGreen = j;
                    }

                    if (startXRed != -1 && startXGreen != -1) {
                        break;
                    }
                }

                if (startXRed != -1 && startXGreen != -1) {
                    break;
                }
            }

            // Periksa apakah posisi awal droid merah dan hijau valid
            if (startXRed == -1 || startYRed == -1 || startXGreen == -1 || startYGreen == -1) {
                System.out.println("Posisi awal droid tidak ditemukan");
                return;
            }

            // Panggil fungsi dfs untuk mencari semua jalan di labirin
            boolean[][] visited = new boolean[labirin.length][labirin[0].length];
            visited[startXRed][startYRed] = true;
            visited[startXGreen][startYGreen] = true;
            dfs(startXRed, startYRed, startXGreen, startYGreen, visited);
        });
        moveThread.start();
    }

    private void dfs(int xRed, int yRed, int xGreen, int yGreen, boolean[][] visited) {
        // Array untuk mengacak arah pergerakan droid merah
        int[] directionsRed = {0, 1, 2, 3};
        shuffleArray(directionsRed);

        // Array untuk mengacak arah pergerakan droid hijau
        int[] directionsGreen = {0, 1, 2, 3};
        shuffleArray(directionsGreen);

        // Cek apakah droid merah dan hijau berada pada garis lurus yang sama
        if (areOnSameStraightPath(xRed, yRed, xGreen, yGreen)) {
            // Simpan posisi awal droid merah
            int initialXRed = xRed;
            int initialYRed = yRed;

            // Untuk memeriksa apakah dua droid berada di sebelah atau saling berdekatan
            while (!areAdjacent(xRed, yRed, xGreen, yGreen)) {
                // Cek apakah pergerakan harus dihentikan
                if (stopMoving || stopGreen) {
                    return;
                }

                // Tentukan arah pergerakan droid merah menuju droid hijau
                int direction = determineDirection(xRed, yRed, xGreen, yGreen);

                // Perbarui posisi droid merah berdasarkan arah pergerakan
                if (direction == 0) { // Gerakan ke atas
                    xRed--;
                } else if (direction == 1) { // Gerakan ke kanan
                    yRed++;
                } else if (direction == 2) { // Gerakan ke bawah
                    xRed++;
                } else if (direction == 3) { // Gerakan ke kiri
                    yRed--;
                }

                // Periksa apakah gerakan valid dan belum dikunjungi sebelumnya
                if (isValidMove(xRed, yRed, visited)) {
                    visited[xRed][yRed] = true;

                    // Hapus tanda pada posisi sebelumnya
                    labirin[initialXRed][initialYRed] = 0;

                    // Gambar ulang labirin setelah pergerakan droid merah
                    labirin[xRed][yRed] = 2;
                    repaint();

                    // Beri jeda sebelum langkah berikutnya
                    try {
                        Thread.sleep(500); // Sesuaikan kecepatan pergerakan droid merah di sini
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    // Simpan posisi awal droid merah yang baru
                    initialXRed = xRed;
                    initialYRed = yRed;
                } else {
                    // Batalkan pergerakan jika tidak valid (terhalang tembok)
                    xRed = initialXRed;
                    yRed = initialYRed;
                    break;
                }
            }

            // Droid merah dan hijau menempel, berhenti pergerakan
            if (areAdjacent(xRed, yRed, xGreen, yGreen)) {
                stopMoving();
                System.out.println("Permainan Selesai");
                return;
            }
        }

        // Pergerakan droid merah
        for (int dirRed : directionsRed) {
            // Periksa apakah pergerakan harus dihentikan
            if (stopMoving) {
                return;
            }
            int newXRed = xRed;
            int newYRed = yRed;

            // Perbarui posisi droid merah berdasarkan arah pergerakan
            if (dirRed == 0) { // Gerakan ke atas
                newXRed--;
            } else if (dirRed == 1) { // Gerakan ke kanan
                newYRed++;
            } else if (dirRed == 2) { // Gerakan ke bawah
                newXRed++;
            } else if (dirRed == 3) { // Gerakan ke kiri
                newYRed--;
            }

            // Periksa apakah gerakan valid dan belum dikunjungi sebelumnya
            if (isValidMove(newXRed, newYRed, visited)) {
                visited[newXRed][newYRed] = true;

                // Gambar ulang labirin setelah pergerakan droid merah
                labirin[xRed][yRed] = 0;
                labirin[newXRed][newYRed] = 2;
                repaint();

                // Beri jeda sebelum langkah berikutnya
                try {
                    Thread.sleep(500); // Sesuaikan kecepatan pergerakan droid merah di sini
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Pergerakan droid hijau
                for (int dirGreen : directionsGreen) {
                    // Periksa apakah pergerakan harus dihentikan
                    if (stopMoving || stopGreen) {
                        return;
                    }
                    int newXGreen = xGreen;
                    int newYGreen = yGreen;

                    // Perbarui posisi droid hijau berdasarkan arah pergerakan
                    if (dirGreen == 0) { // Gerakan ke atas
                        newXGreen--;
                    } else if (dirGreen == 1) { // Gerakan ke kanan
                        newYGreen++;
                    } else if (dirGreen == 2) { // Gerakan ke bawah
                        newXGreen++;
                    } else if (dirGreen == 3) { // Gerakan ke kiri
                        newYGreen--;
                    }

                    // Periksa apakah gerakan valid dan belum dikunjungi sebelumnya
                    if (isValidMove(newXGreen, newYGreen, visited)) {
                        visited[newXGreen][newYGreen] = true;

                        // Gambar ulang labirin setelah pergerakan droid hijau
                        labirin[xGreen][yGreen] = 0;
                        labirin[newXGreen][newYGreen] = 3;
                        repaint();

                        // Rekursi untuk mencari semua jalan di labirin
                        dfs(newXRed, newYRed, newXGreen, newYGreen, visited);

                        // Periksa apakah pergerakan harus dihentikan setelah selesai
                        if (stopMoving || stopGreen) {
                            return;
                        }

                        // Kembali ke langkah sebelumnya
                        visited[newXGreen][newYGreen] = false;

                        // Gambar ulang labirin setelah kembali dari langkah sebelumnya
                        labirin[xGreen][yGreen] = 3;
                        labirin[newXGreen][newYGreen] = 0;
                        repaint();

                        // Jeda setelah mengulangi jalur yang sudah dilewati
                        try {
                            Thread.sleep(500); // Sesuaikan kecepatan pergerakan droid merah di sini
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    } else if (newXGreen == xRed && newYGreen == yRed) {
                        // Batalkan pergerakan jika droid hijau bergerak ke posisi droid merah
                        continue;
                    }
                }

                // Kembali ke langkah sebelumnya
                visited[newXRed][newYRed] = false;

                // Gambar ulang labirin setelah kembali dari langkah sebelumnya
                labirin[xRed][yRed] = 2;
                labirin[newXRed][newYRed] = 0;
                repaint();

                // Jeda setelah mengulangi jalur yang sudah dilewati
                try {
                    Thread.sleep(500); // Sesuaikan kecepatan pergerakan droid merah di sini
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private boolean areOnSameStraightPath(int xRed, int yRed, int xGreen, int yGreen) {
        if (xRed == xGreen) { // Jika droid merah dan droid hijau memiliki koordinat x yang sama
            int minY = Math.min(yRed, yGreen);
            int maxY = Math.max(yRed, yGreen);

            // Periksa apakah ada tembok di antara droid merah dan droid hijau
            for (int y = minY + 1; y < maxY; y++) {
                if (labirin[xRed][y] == 1) {
                    return false; // Terdapat tembok yang menghalangi garis lurus
                }
            }
            return true;
        } else if (yRed == yGreen) { // Jika droid merah dan droid hijau memiliki koordinat y yang sama
            int minX = Math.min(xRed, xGreen);
            int maxX = Math.max(xRed, xGreen);

            // Periksa apakah ada tembok di antara droid merah dan droid hijau
            for (int x = minX + 1; x < maxX; x++) {
                if (labirin[x][yRed] == 1) {
                    return false; // Terdapat tembok yang menghalangi garis lurus
                }
            }
            return true;
        }

        return false; // Jika droid merah dan droid hijau tidak berada pada garis lurus yang sama
    }

    // Fungsi untuk mengecek apakah dua droid berada di sebelah/saling berdekatan
    private boolean areAdjacent(int xRed, int yRed, int xGreen, int yGreen) {
        return (Math.abs(xRed - xGreen) == 1 && yRed == yGreen) || (xRed == xGreen && Math.abs(yRed - yGreen) == 1);
    }

    // Fungsi untuk menentukan arah pergerakan droid merah menuju droid hijau
    private int determineDirection(int xRed, int yRed, int xGreen, int yGreen) {
        if (xRed < xGreen) { // Droid hijau berada di bawah droid merah
            return 2; // Gerakan ke bawah
        } else if (xRed > xGreen) { // Droid hijau berada di atas droid merah
            return 0; // Gerakan ke atas
        } else if (yRed < yGreen) { // Droid hijau berada di sebelah kanan droid merah
            return 1; // Gerakan ke kanan
        } else { // Droid hijau berada di sebelah kiri droid merah
            return 3; // Gerakan ke kiri
        }
    }

    // Untuk mengacak urutan angka dalam array
    private void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // Untuk memeriksa apakah langkah pergerakan ke koordinat (x, y) valid dalam labirin
    private boolean isValidMove(int x, int y, boolean[][] visited) {
        return x >= 0 && x < labirin.length && y >= 0 && y < labirin[0].length && !visited[x][y] && labirin[x][y] != 1;
    }

    //Fungsi Pandangan Droid Merah
    public int[][] PandanganDroidMerah() {
        int[][] arr = labirin.clone(); // clone labirin agar tidak merubah labirin asli

        // Set semua posisi yang bukan droid merah menjadi jalan
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] != 2) {
                    arr[row][col] = (arr[row][col] == 1) ? 1 : 0; // Set jalan atau tembok sesuai dengan labirin asli
                }
            }
        }

        return arr;
    }

    // Fungsi Pandangan Droid Hijau
    public int[][] PandanganDroidHijau(int radius) {
        this.radius = radius; // Update nilai radius instance
        int[][] arr = labirin.clone(); // clone labirin agar tidak merubah labirin asli
        int droidHijauRow = -1; // posisi baris droid hijau
        int droidHijauCol = -1; // posisi kolom droid hijau

        // Cari posisi droid hijau dalam labirin
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == 3) {
                    droidHijauRow = row;
                    droidHijauCol = col;
                    break;
                }
            }
            if (droidHijauRow != -1) {
                break;
            }
        }

        // Set semua posisi di luar persegi pandangan menjadi biru
        int startX = Math.max(0, droidHijauCol - radius);
        int endX = Math.min(arr[0].length - 1, droidHijauCol + radius);
        int startY = Math.max(0, droidHijauRow - radius);
        int endY = Math.min(arr.length - 1, droidHijauRow + radius);

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] != 2 && arr[row][col] != 3) {
                    if (col < startX || col > endX || row < startY || row > endY) {
                        arr[row][col] = 4;
                    }
                }
            }
        }

        return arr;
    }

    //Gambar peta pada JFrame
    @Override
    public void paint(Graphics g) {
        g.translate(30, 50);

        //Gambar peta
        if (repaint == true) {
            for (int row = 0; row < labirin.length; row++) {
                for (int col = 0; col < labirin.length; col++) {
                    Color color;

                    switch (labirin[row][col]) {
                        case 1:
                            color = Color.black;
                            break;
                        case 2:
                            color = Color.red;
                            break;
                        case 3:
                            color = Color.green;
                            break;
                        case 4:
                            color = Color.blue;
                            break;
                        default:
                            color = Color.white;
                    }

                    g.setColor(color);
                    g.fillRect(30 * col, 30 * row, 30, 30);
                    g.setColor(Color.black);
                    g.drawRect(30 * col, 30 * row, 30, 30);

                }
            }
        }

        if (repaint == false) {
            for (int row = 0; row < labirin.length; row++) {
                for (int col = 0; col < labirin.length; col++) {
                    Color color;

                    switch (labirin[row][col]) {
                        case 1:
                            color = Color.black;
                            break;
                        case 2:
                            color = Color.red;
                            break;
                        case 3:
                            color = Color.green;
                            break;
                        case 4:
                            color = Color.blue;
                            break;
                        default:
                            color = Color.white;
                    }

                    g.setColor(color);
                    g.fillRect(30 * col, 30 * row, 30, 30);
                    g.setColor(Color.black);
                    g.drawRect(30 * col, 30 * row, 30, 30);
                }
            }
        }
    }

    //Metode utama, merupakan tempat mulainya eksekusi program
    public static void main(String[] args) {

        //Menjalankan kode GUI dalam thread
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            //untuk run file
            public void run() {
                CodePAARizky codepaarizky = new CodePAARizky();
            }
        });
    }
}
