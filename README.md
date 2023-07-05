# :bulb: molcamp_week_1

> 👍 서로 함께 공통의 과제를 함으로써, 개발에 빠르게 익숙해지기
>
> To become familiar with development by working on a common assignment together.

## 💻 Target Output -> Android Application Development by Kotlin
<img src="https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=android&logoColor=white"/> <img src="https://img.shields.io/badge/Android Studio-3DDC84?style=flat-square&logo=Android Studio&logoColor=white"/>
- [x] Building My Contacts.
- [x] Building My Image Gallery.
- [x] Free topic. In our case, Wise Sayings Generator(Kor).

Download our demo apk here -> 
[download APK](https://drive.google.com/file/d/1h7dVyx5X3itwq6C6Bf_071fLmV-kykjV/view?usp=sharing)
<br/>
## 🙆 Members
|팀원|소속|github ID|
|:---|:---|:---|
|송도윤|GIST 전기전자컴퓨터공학부|[SongDerrick](https://github.com/SongDerrick/)|
|장동우|한양대학교 컴퓨터소프트웨어학부|[jjangddu](https://github.com/jjangddu/)|



## 📖 Table of Contents

- [Project Description](#project-description)
- [Features](#features)
- [Installation](#installation)
- [Contributing](#contributing)
- [Acknowledgements](#acknowledgments)
  
## Project Description

Brief overview and descriptions of our project.

### Loading Page             

|<img src="images/Screenshot_1.jpg" alt="Sc1" width="270" height="570">|

### Tab 1 : ☎️ Contacts
<img src="images/Screenshot_2.jpg" alt="Sc2" width="270" height="570"> <img src="images/Screenshot_5.jpg" alt="Sc5" width="270" height="570"> <img src="images/Tab1.gif" alt="Sc4" width="270" height="570">

First tab is My Contacts.<br>
By clicking the purple floating button, you can add a new contact.<br>
By clicking the gray phone button, you can directed to phone call with designated phone number.<br/>
<br/>
if we want to put initial data into application, we can modify 
```
    private val dataList = mutableListOf(
        PhoneData("Jang", "010-1234-1234"),
        PhoneData("Song", "010-1241-1313"),
        PhoneData("LSLS", "010-1313-1313"),
        PhoneData("SSSS", "010-4142-4224"),
        PhoneData("ALSS", "010-1414-1414")
    )
```
in java>ui>phone>Phonefragment.kt

### Tab 2 : 📑 Gallery             
<img src="images/Screenshot_3.jpg" alt="Sc3" width="270" height="570"> <img src="images/Screenshot_6.jpg" alt="Sc3" width="270" height="570"> <img src="images/Tab2.gif" alt="Sc4" width="270" height="570">

Second tab is My Gallery.<br>
It has layout of staggered grid layout. Even with different size images, each images are not distorted but rather shown in aspect ratio.<br>
You also have access to each images by clicking them, you can zoom out and zoom in by multi-touch pinching motion.<br>
Also, with external storage access granted you can download each images by clicking download button.

### Tab 3 : 👅 Wise Sayings Generator                   
<img src="images/Screenshot_4.jpg" alt="Sc4" width="270" height="570"> <img src="images/Tab3.gif" alt="Sc4" width="270" height="570">

Final tab is Wise Sayings Generator.<br>
Everytime the screen is clicked new wise sayings are generated from APIs from https://api.qwer.pw/.<br>
However, response from the APIs were in JSON format, and actual sayings and the person who said it were all contained in single string.<br>
Therefore, we had to parse them to use as adequate output.


## Features

<br/>Main Activity<br/>
We used navgationcontroller to make three tabs in bottom. It is 'Phone, gallery, Wise Saying'

<br/>Phone<br/>
We used Relativelayout to put floating action button and recyclerview in one page.
In recyclerview, we put phonedata having 'name' and 'phoneNum'. 
<br/>
<img width="178" alt="image" src="https://github.com/SongDerrick/android_three_tab/assets/55375379/6c95836d-4c93-4cc5-b37f-99c82024cb43">
<br/>
one item of recyclerview is like this.

and if We push FAB(Floating Action Button), the bottom sheet appears to add contact.
<br/>
<img width="177" alt="image" src="https://github.com/SongDerrick/android_three_tab/assets/55375379/59ea947d-9f46-4fa2-87c3-2eae30d3fcad"><br/>
This is a capture of bottom sheet. <br/>
We can click 'ic_phone' to change our phone into calling page.

<br/>Gallery<br/>

in fragment_home.xml, we made recyclerview to show our gallery. and in activity_detailed.xml, we made detailed image view.
We used StaggeredGridLayoutManager to make grid resized depending on component image's size.<br/>
<img width="181" alt="image" src="https://github.com/SongDerrick/molcamp_week_1/assets/55375379/bfba0a94-e11b-432e-802c-12662aa9d9c9"><br/>
this is the detailed image view of our application.


<br/>Wise Saying<br/>

in fragment_notifications.xml we made Relativelayout that has progressbar and two textviews.we used api from https://api.qwer.pw/
we parsed wise saying with dashbar, dividing the wise saying and the person who made it.
  
## Installation

Nothing Special.<br/>
Clone and Build project in Android Studio.

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks again!
<br/>
1.Fork the Project<br/>
2.Create your Feature Branch (```git checkout -b feature/AmazingFeature```)<br/>
3.Commit your Changes (```git commit -m 'Add some AmazingFeature'```)<br/>
4.Push to the Branch (```git push origin feature/AmazingFeature```)<br/>
5.Open a Pull Request<br/>

## Acknowledgments

<https://api.qwer.pw/> <br/>
<https://developer.android.com/docs?hl=ko> <br/>





