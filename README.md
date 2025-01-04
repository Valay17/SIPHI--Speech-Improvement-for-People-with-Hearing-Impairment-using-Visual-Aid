<div id="user-content-toc" align="center">
  <ul>
  <img src="https://github.com/user-attachments/assets/4da8b0ba-08dd-4f63-9f7f-f5e756f01c86" align="center" width="120" height="120"> 
  <summary><h1> <p>SIPHI - Speech Improvement for People with Hearing Impairment using Visual Aid</p> </h1></summary>
  </ul>
</div>

#
This project implements a Mobile Speech Improvement System for individuals with hearing impairment on Android devices. It enables users to improve their speech pronunciation through lip-sync animations, frequency analysis, and real-time feedback. The app is designed to assist the Deaf and Hard of Hearing (DHH) community in overcoming communication barriers and improving their speech skills, while also offering an interactive experience for anyone looking to enhance their pronunciation. The system provides dynamic visual and audio feedback, allowing users to learn and practice words and phrases, with analysis that helps track progress over time.

## **Abstract**
Deafness and hearing loss affect millions of people, including over 63 million in India alone. While some deaf individuals can learn to speak, they often lack access to the infrastructure needed for speech training. This project introduces **SIPHI**, an assistive technology aimed at helping both the Deaf community and normal people improve speech pronunciation using lip-sync animations and dynamic visual feedback.

The application allows users to input any word, records their speech via a microphone, and provides a graphical representation of the sound, comparing it to a standard pronunciation. This provides real-time feedback, helping users improve their pronunciation. The primary goal of the project is to bridge communication gaps, enabling better interaction between Deaf-mute individuals and others without sign language knowledge.

## **Problem Statement**

To develop an application to train and enhance the speaking skills of people with hearing impairment through a visually-stimulating app which utilizes lip-sync animations and dynamic sound representation in the form of line graphs for an interactive and effective training experience.

## **Introduction**
We introduce a mobile-based speech improvement system designed to assist individuals with hearing impairments in refining their speech pronunciation. By leveraging lip-sync animations and frequency analysis, the system provides real-time visual and audio feedback to help users compare their speech with a standard pronunciation. This approach aims to bridge communication gaps for the Deaf and Hard of Hearing (DHH) community, enabling more effective and independent communication. Our system offers an interactive learning experience by analyzing and providing feedback on user pronunciation, ensuring a personalized and scalable solution for speech improvement.

## **Problems with Available Systems/Solutions**

Most of the currently available mobile applications (iOS and Android) serve the deaf and dumb people in a very limited way. For instance, there are some applications that teach the English alphabet only, and some others show the sign language representation and its meaning. 

Other mobile applications use sign language as the only option for communication with deaf users. No such app exists in the mobile market that uses the disrupted speech of Deaf-mutes for the purpose of social connectivity.

## **Methodology**

The SIPHI app helps users improve their pronunciation through a detailed process that includes several steps:

1. **Speech Scoring**:  
   English speech scoring is based on the similarity between standard speech (ideal pronunciation) and rated speech (user's spoken input). A comprehensive score is computed for each aspect of the speech, with **different weights** assigned to each aspect. This helps to evaluate the user's pronunciation more effectively, considering multiple factors like clarity, tone, and articulation.

2. **Learning Process**:  
   Once the user selects the desired learning option (e.g., words or phrases), the app shows Lip Movements and Broken-Down Pronunciation for the selected words. The user is then asked to speak the words out loud. 

3. **Voice Input & Noise Cancellation**:  
   The app records the user's speech input via the microphone. To enhance accuracy, Noise Cancellation is applied to filter out background and white noise. This ensures that only the clean, relevant speech signal is analyzed.

4. **Speech Signal Cutting & Recognition**:  
   The clean speech sample is then fed into a Speech Recognition Algorithm. This algorithm uses speech signal cutting to break the input into segments, aligning it with the pre-trained English pronunciation acoustic model. This helps to accurately isolate and evaluate the correct pronunciation segment from the input.

5. **Waveform Comparison & Quantitative Score Calculation**:  
   The app performs a Waveform Comparison between the user's speech input and the ideal pronunciation. The results are then analyzed quantitatively to calculate a score that indicates how close the user’s pronunciation is to the correct standard. 

6. **Feedback & Learning Improvement**:  
   After the analysis, the results are displayed to the user with the following:
   - Waveform Comparison: A side-by-side comparison showing how the user’s pronunciation matches the ideal waveform.
   - Quantitative Score: A score that provides feedback on how well the user was able to speak the word or phrase.
   - Lip Movements & Pronunciation Breakdown: Visual cues showing how well the user pronounced the words, with feedback to guide them towards improvement.

This process helps language learners understand how well they are doing in terms of pronunciation and provides clear feedback for clarity on how to improve their speech.

## **Challenges and Limitations of the Current Version**

The current version of the SIPHI app has some limitations:

1. **Lip Sync Animation API**:  
   Google does not currently have an API for lip-sync animation, which would significantly improve the app’s usability and make it more accurate and engaging.

2. **Speech Comparison**:  
   Speech comparison is limited and requires large-scale model training. Current solutions provide basic feedback but do not scale well for diverse accents and complex speech patterns. Accents can greatly affect the frequency and tone of the audio input, which can lead to lower accuracy when comparing the user’s speech to the ideal pronunciation. Different regional accents and speech nuances can alter the sound frequency, making it harder for the algorithm to accurately assess and compare pronunciation.

3. **Limited Word Selection**:  
   The current solution uses a limited selection of words stored locally in the app. Ideally, the app should have an online backend to send user data for analysis, expanding the word pool and providing dynamic updates.

4. **Proof of Concept**:  
   This is a proof-of-concept version and not a fully functional application. The app requires a small amount of funding and the development of a non-existent API for proper scaling.

5. **Noise Cancellation**:  
   Noise cancellation for audio input can be challenging, as it often increases noise and reduces the accuracy of speech recognition. High levels of background noise may interfere with the quality of speech data used for analysis. The current filter reduces background noise by lowering the overall amplitude of all sounds, rather than selectively isolating noise from speech.


## **Details of Hardware & Software**

**Hardware Modules to be used**:
- Any Android device with **Android 4.2** (or higher) and a microphone.

**Software Modules to be used**:
- **Flutter SDK 3.0.5**
- **Android Studio Chipmunk**
- **Google Firebase Cloud Store**
- **Google Translate API**

**Other Requirements**:
- Active internet connection (100 kbps or higher).

## **Installation**

### **Prerequisites**

Before you begin, ensure that you have the following software installed:

- **Android Studio**: Download and install Android Studio
- **Flutter SDK**: Make sure Flutter SDK is installed if you're building the layout using Flutter. 
- **Java JDK**: Ensure Java JDK is installed to work with Android Studio.

### **Clone the repository**
```bash
https://github.com/Valay17/SIPHI--Speech-Improvement-for-People-with-Hearing-Impairment-using-Visual-Aid.git
```
### **Open the project in Android Studio**
1. Launch Android Studio.
2. Open the cloned project folder (`SIPHI`).
3. Sync the Gradle files by clicking **"Sync Now"** when prompted.

### **Run the app**
1. Connect an Android device via USB or start an Android emulator.
2. Click the **"Run"** button in Android Studio to install and launch the app on your device.

### **Permissions**
The app will ask for necessary permissions:
- **Audio**: To record the user's speech input.
- **Storage**: To save any necessary data files.

Ensure these permissions are granted for the app to function properly.

## **Video Demo**
Here’s a video demo showing how the app works, showcasing all the features such as lip-sync animations, frequency analysis, and the ability to track pronunciation progress.

1. **Open the app** – The user is greeted by the app’s home screen.
2. **Enter ID/Number** – The user inputs their ID or phone number.
3. **Enter Password** – The user inputs their password.
4. **Register / Log in / Forgot Password** – Options to register, log in, or reset the password are available.
5. **Request Permissions** – The app asks for necessary permissions to access audio and storage for functionality.
6. **Show Features**:
   - **Lip Sync API** – The app displays lip-sync animations corresponding to the pronunciation of words.
   - **Frequency Analysis** – The app shows the frequency of the word being spoken and compares it to the standard pronunciation.
   - **Control Options** – The user can start, stop, pause, and play the recording for analysis.
7. **Enter User Name for Analysis** – The user enters their name to track progress.
8. **Show Frequency Comparison and Feedback** – The app compares the frequency of the user’s speech to the standard, providing feedback on pronunciation.
9. **Integration with Server** (if fully integrated) – Data is sent to the server for analysis by a speech therapist or doctor to help assess and improve the user's speech progress.
10. **Log Out** – The user can log out from the app.

<video src="https://github.com/user-attachments/assets/c3514a3b-b2f2-44c4-9e03-2dd622f58e77"></video>

**Current Release Info**:  
For the current release, you can use the following login credentials to access the app and test its features.
- **ID/Number**: 9833829560  
- **Password**: valay  

## **Contributors**

This project was successfully prototyped in collaboration with:

- **User1**
- **User2**
- **User2**

## **License**

This project is **not licensed**. No rights are granted to use, modify, distribute, or otherwise use the code in this repository unless explicitly stated otherwise. By using or accessing the repository, you acknowledge that you are not being granted any rights or licenses to the content or code.
