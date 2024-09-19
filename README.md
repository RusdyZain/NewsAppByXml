# NewsAppByXml

![Kotlin](https://img.shields.io/badge/Kotlin-1.5.21-blueviolet.svg)
![XML](https://img.shields.io/badge/XML-Layout-orange.svg)

## Deskripsi Proyek

**NewsAppByXml** adalah aplikasi berita sederhana yang dibangun menggunakan **Kotlin** dan **XML** sebagai bagian dari Magang Virtual di **Bank Mandiri** melalui **Rakamin Academy**. Aplikasi ini memungkinkan pengguna untuk membaca berita terbaru dari berbagai kategori, menampilkan informasi seperti judul berita, ringkasan, dan sumbernya.

Proyek ini dirancang untuk memberikan pengalaman pengguna yang mudah dalam mencari dan membaca berita dengan tampilan yang bersih dan responsif. Selain itu, aplikasi ini juga menggunakan **API** untuk mendapatkan berita terkini dari internet.

## Fitur Utama

- **Daftar Berita Terbaru**: Pengguna dapat melihat daftar berita terbaru dari berbagai sumber.
- **Kategori Berita**: Berita dikelompokkan berdasarkan kategori seperti teknologi, bisnis, olahraga, dan lainnya.
- **Desain Responsif**: Tampilan aplikasi yang responsif dan dirancang dengan XML, mendukung berbagai ukuran layar.
- **Detail Berita**: Pengguna dapat mengeklik berita untuk melihat detail lengkap termasuk isi berita.
- **Refresh Berita**: Menggunakan fitur **SwipeRefreshLayout** untuk memperbarui daftar berita secara manual.

## Teknologi yang Digunakan

- **Kotlin**: Bahasa pemrograman utama untuk mengembangkan aplikasi Android ini.
- **XML**: Digunakan untuk mendesain layout antarmuka pengguna.
- **Retrofit**: Untuk mengambil data berita dari API eksternal.
- **Glide**: Untuk memuat gambar berita.
- **RecyclerView**: Untuk menampilkan daftar berita dalam format scrollable yang efisien.
- **SwipeRefreshLayout**: Untuk menyegarkan berita secara manual.

## Instalasi dan Penggunaan

1. **Clone repository ini**:
   ```bash
   git clone https://github.com/RusdyZain/NewsAppByXml.git
   cd NewsAppByXml
   ```

2. **Buka di Android Studio**:
   - Buka Android Studio dan pilih `Open an Existing Project`.
   - Arahkan ke folder proyek yang telah di-clone.

3. **Konfigurasi API**:
   - Aplikasi ini memerlukan API untuk mendapatkan berita. Anda dapat menggunakan [NewsAPI](https://newsapi.org/) untuk mengambil berita.
   - Setelah mendaftar, masukkan API key Anda di file `ApiService.kt`:
     ```kotlin
     const val API_KEY = "your_api_key_here"
     ```

4. **Run Aplikasi**:
   - Klik tombol `Run` di Android Studio untuk menjalankan aplikasi pada emulator atau perangkat fisik.

## Struktur Proyek

```
.
├── MainActivity.kt               # Activity utama yang menampilkan daftar berita
├── NewsAdapter.kt                # Adapter untuk menampilkan item berita dalam RecyclerView
├── ApiService.kt                 # Service untuk mengambil data dari API
├── res/
│   ├── layout/
│   │   └── activity_main.xml     # Layout utama untuk menampilkan berita
│   │   └── item_news.xml         # Layout item berita di RecyclerView
│   ├── drawable/
│   │   └── ...                   # Sumber daya gambar dan icon
│   └── values/
│       └── strings.xml           # String dan nilai resource lainnya
└── README.md                     # Dokumentasi proyek ini
```

## Fitur yang Akan Datang

- **Pencarian Berita**: Menambahkan fitur untuk mencari berita berdasarkan kata kunci tertentu.
- **Bookmark Berita**: Pengguna dapat menyimpan berita favorit mereka.
- **Notifikasi Berita**: Menambahkan fitur push notification untuk berita penting.

## Kontribusi

1. **Fork repository ini**.
2. Buat branch baru (`git checkout -b fitur-anda`).
3. Commit perubahan Anda (`git commit -m 'Menambahkan fitur baru'`).
4. Push branch Anda (`git push origin fitur-anda`).
5. Ajukan pull request untuk ditinjau.
