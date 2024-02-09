Tes QA Engineer DOT Indonesia - Fery Krisnanto

Berikut ini adalah kode otomatis testing kasus login di website PSe. Kode ini ditulis menggunakan framework Selenium Webdriver dengan bahasa Java. Kode terdiri dari 6 jenis test case :
1. Login menggunakan email dan password yang benar (+)
2. Login menggunakan username dan password yang benar (+)
3. Login menggunakan email yang benar namun password salah (-)
4. Login menggunakan email yang tidak terdaftar (-)
5. Login saat field email kosong (-)
6. Login saat field password kosong (-) 

Kode juga telah diintegrasikan dengan Cucumber.
Cara untuk menjalankan :

1. Install IntellijIDEA
2. Clone repository ini dan sesuaikan dengan plugin & maven yang dibutuhkan di IntellijIDEA yang baru diinstall.
3. Setelah repository terbuka, jalankan program java pada folder test/java satu persatu untuk mengecek per test case.
4. Untuk menjalankan semuanya sekaligus, buka folder cucumber/resources/features/cucumber lalu jalankan LoginPSE.features dengan klik button segitiga di tulisan Feature paling atas.
5. Untuk melihat hasil report, buka file HTML_report.hmtl di folder target, buka file tersebut di browser.
Data Dummy telah diberikan pada kode.

Daftar test case lebih lengkap dapat dilihat di spreadsheet berikut : https://docs.google.com/spreadsheets/d/15Q2ZTtqcYxeDv_fi4EXSIm5oul00QYPS-EGOQ6RhqwU/edit?usp=sharing

Hasil yang ditemukan : Ada error saat testing menggunakan otomasi saat login dengan kredensial yang valid. Setelah klik login, halaman kembali ke halaman login. Menghasilkan dua tes case positif yang gagal
