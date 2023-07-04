# android_three_tab

Kotlin based Android application project that is composed of three tabs.
Each tab have specific functions.
- first tab : Contacts
- second tab : Gallery
- third tab : Wise Sayings Generator(Kor)


## Table of Contents

- [Project Description](#project-description)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Project Description

Brief overview and screen shots of our project.

| Loading Page                 |
| ---------------------------- |
|<img src="images/Screenshot_1.jpg" alt="Sc1" width="270" height="570">|

| Contacts                   |
| ---------------------------- |
|<img src="images/Screenshot_2.jpg" alt="Sc2" width="270" height="570">|

| Gallery                 | 
| ---------------------------- |
|<img src="images/Screenshot_3.jpg" alt="Sc3" width="270" height="570">|

|Wise Sayings Generator                   |
| ---------------------------- |
|<img src="images/Screenshot_4.jpg" alt="Sc4" width="270" height="570">|

| Gif of Wise Sayings Generator                 |
| ---------------------------- |
|<img src="images/Tab3.gif" alt="Sc4" width="270" height="570">|

everytime the screen is clicked new wise sayings are generated from APIs from https://api.qwer.pw/.


## Features

<Main Activity>
We used navgationcontroller to make three tabs in bottom. It is 'Phone, gallery, Wise Saying'

<Phone>
We used Relativelayout to put floating action button and recyclerview in one page.
In recyclerview, we put phonedata having 'name' and 'phoneNum'. 
<img width="178" alt="image" src="https://github.com/SongDerrick/android_three_tab/assets/55375379/6c95836d-4c93-4cc5-b37f-99c82024cb43">
one item of recyclerview is like this.

and if We push FAB(Floating Action Button), the bottom sheet appears to add contact.
<img width="177" alt="image" src="https://github.com/SongDerrick/android_three_tab/assets/55375379/59ea947d-9f46-4fa2-87c3-2eae30d3fcad">
This is a capture of bottom sheet. 

We can click 'ic_phone' to change our phone into calling page.

<Gallery>



<Wise Saying>
  
## Installation

Nothing Special
Clone and Build project in Android Studio.
```
npm install
```

## Usage

Provide examples or instructions on how to use your project. Include code snippets or screenshots if applicable. Explain any relevant details that users need to know to use your project effectively.

## Contributing

Explain how others can contribute to your project. Include guidelines for submitting bug reports, feature requests, or pull requests. Specify any coding styles, conventions, or standards that contributors should follow.

## License

Specify the license under which your project is distributed. Provide a link to the license file if applicable.

## Acknowledgments

If your project builds upon or uses external resources or libraries, acknowledge and give credit to those sources here.

## Contact

Provide contact information for users to reach out to you with questions, feedback, or support inquiries.


