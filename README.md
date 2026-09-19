# 📱 BabyGuard Android (AISecurity)

**BabyGuard Android** is the mobile application for the **BabyGuard Smart Security (BGSS)** system. It connects to the Python/Flask backend over a local network and provides a mobile interface for live monitoring, family management, and security event history.

## 🚀 Features

- 🎥 Live camera monitoring
- 📊 AI security dashboard
- 👥 View registered family members
- 📜 Event history
- 🔴 Live system status
- 🌐 Flask REST API integration
- 📡 Real-time communication with the backend
- 📱 Mobile-friendly security monitoring

## 🧠 AI Backend

The Android application works together with the **BabyGuard Smart Security Python backend**, which provides:

- Face recognition
- YOLO-based object detection
- Unknown person photo capture
- Zone monitoring
- Event logging
- Live video streaming

> The AI processing is performed by the Python backend, while the Android application provides the mobile monitoring interface.

## 🛠️ Technologies

### Android

- Java
- Android Studio
- XML
- Retrofit
- WebView
- Android CameraX

### Backend Communication

- REST API
- HTTP
- JSON
- Flask

## 📂 Project Structure

```text
BabyGuard-Android/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/akash/aisecurity/
│   │       │       ├── api/
│   │       │       ├── MainActivity.java
│   │       │       ├── LiveCameraActivity.java
│   │       │       ├── FamilyActivity.java
│   │       │       ├── EventsActivity.java
│   │       │       └── ...
│   │       │
│   │       └── res/
│   │           ├── layout/
│   │           └── ...
│   │
│   └── build.gradle.kts
│
├── gradle/
├── build.gradle.kts
└── settings.gradle.kts
```

## 🔗 Backend Connection

The Android application communicates with the Flask backend using the laptop's local IP address.

Example:

```text
http://192.168.1.X:5000/
```

The Android device and the computer running the backend must be connected to the same local network.

### Main API endpoints

| Endpoint | Purpose |
|---|---|
| `/live` | Live camera stream |
| `/family` | Family members |
| `/events` | Security event history |
| `/status` | System status |
| `/unknown` | Unknown person data |
| `/add_person` | Add family member |

## ⚙️ Setup

### 1. Clone the repository

```bash
git clone https://github.com/AKASHBAG01/BabyGuard-Android.git
```

### 2. Open in Android Studio

Open the cloned project in **Android Studio** and allow Gradle to synchronize.

### 3. Configure Backend IP

Open:

```text
ApiClient.java
```

and set the IP address of the computer running the Flask backend:

```java
private static final String BASE_URL =
        "http://192.168.1.X:5000/";
```

Also update the live camera URL in:

```text
LiveCameraActivity.java
```

Example:

```java
webView.loadUrl("http://192.168.1.X:5000/live");
```

### 4. Start the Python Backend

Run the BabyGuard Smart Security backend:

```bash
python ai_security_system.py
```

The backend should be accessible on:

```text
http://192.168.1.X:5000/
```

### 5. Connect Android Device

Connect the Android phone to the same Wi-Fi network as the computer running the backend.

Then build and run the application from Android Studio.

## 📸 Screenshots

Add screenshots of the application here:

- Android home screen
- Live camera
- Family members
- Event history
- Security dashboard

Example:

```text
screenshots/
├── home.png
├── live_camera.png
├── family.png
└── events.png
```

## 🔄 System Architecture

```text
                 ┌──────────────────────┐
                 │      Android App     │
                 │       Java/XML       │
                 └──────────┬───────────┘
                            │
                       HTTP / JSON
                            │
                            ▼
                 ┌──────────────────────┐
                 │    Flask Backend     │
                 │       Python         │
                 └──────────┬───────────┘
                            │
              ┌─────────────┼─────────────┐
              │             │             │
              ▼             ▼             ▼
         OpenCV          YOLOv8       Event Logger
      Face Recognition   Detection
              │             │             │
              └─────────────┼─────────────┘
                            ▼
                   AI Security System
```

## 🔮 Future Improvements

- Push notifications
- Cloud monitoring
- Firebase integration
- Multiple camera support
- Voice alerts
- Improved AI behaviour detection
- Remote internet access
- Emergency notifications

## 👨‍💻 Developer

**Akash kumar Bag**

Electronics & Communication Engineering

Haldia Institute of Technology

## 🔗 Main Project

The Android application is part of the larger **BabyGuard Smart Security (BGSS)** project.

**Main project:**  
https://github.com/AKASHBAG01/BabyGuard-Smart-Security

## 📄 License

This project is developed for educational and project purposes.
