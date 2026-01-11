# Mobile Automation Testing – Appium & Cucumber

This project is a mobile test automation framework for Android applications using
Appium, Java, Cucumber (BDD), and Maven.

## Tech Stack
- Java 17
- Appium Server v2
- Appium Java Client 8
- Selenium 4
- Cucumber
- Maven

## Application Under Test
- My Demo App (Sauce Labs)
- Android platform

## How to Run
1. Start Android Emulator
2. Start Appium Server
3. Run test:
```bash
mvn clean test
```

## Test Scenarios

Test Scenario 1: Login with Valid Credentials
Preconditions
1. Aplikasi sudah terinstal
2. User belum login
3. Device/Emulator & Appium server berjalan

Test Steps
1. User membuka aplikasi
2. User login menggunakan username dan password yang valid

Expected Result
1. User berhasil login
2. User diarahkan ke halaman Product Page

Test Scenario 2: Add Product to Cart
Preconditions
1. User sudah login
2. User berada di halaman Product Page

Test Steps
1. User memilih salah satu produk
2. User menekan tombol Add to Cart
3. User membuka halaman Cart

Expected Result
1. Produk berhasil ditambahkan ke Cart
2. Produk tampil di Cart sesuai dengan yang dipilih

Test Scenario 3: Checkout Product
Preconditions
1. User sudah login
2. Minimal 1 produk sudah ada di Cart

Test Steps
1. User menekan tombol Proceed to Checkout
2. User mengisi informasi checkout (nama, alamat, dll)
3. User mengisi informasi pembayaran
4. User meninjau kembali detail pesanan
5. User menekan tombol Place Order

Expected Result
1. Order berhasil diproses
2. Muncul halaman Order Success / Confirmation
3. Status pesanan berhasil dibuat
