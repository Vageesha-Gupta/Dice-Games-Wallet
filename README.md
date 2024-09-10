[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/R_7cjhEg)
# A2-PersistUI

Project Name
Dice Games - Persisting the UI state

Student Details
| Name | Roll Number | Email ID |
|----------|----------|----------|
| Vageesha Gupta | 2022A7PS1107G | f20221107@goa.bits-pilani.ac.in |
| Priya Rathi | 2022A7PS1096G | f20221096@goa.bits-pilani.ac.in |

Description of App
The Dice Games is an engaging app for simulating rolls of a six-sided die while tracking various gameplay metrics. As users roll the die, their balance is dynamically updated based on the results. Rolling a six awards 5 coins, and consecutive sixes provide an additional bonus of 10 coins. Conversely, rolling the same non-six number twice in a row results in a deduction of 5 coins. The app also monitors and displays important statistics, including the total number of dice rolls, the frequency of rolling a six, and the value of the previous roll. Users receive immediate feedback through a congratulatory toast whenever a six is rolled. The app is designed to accommodate both portrait and landscape orientations, ensuring a responsive and user-friendly interface across different device orientations.

Implementation
To implement the Dice Games app, we began by designing the user interface (UI) for both portrait and landscape orientations. The portrait layout was created to display the textview for game rules at the top, the balance,the dice value, and the roll statistics. For landscape orientation, a separate XML layout was developed to ensure that the UI elements are arranged in a way that optimizes visibility and usability in landscape mode.Then, we developed the WalletViewModel, which manages and persists the application's state. This ViewModel tracks critical information such as the user's balance, the total number of dice rolls, and the frequency of rolling a six. By utilizing LiveData, the ViewModel ensures that these metrics are updated in real-time and retained across configuration changes, such as screen rotations.In the WalletActivity, we integrated the ViewModel to handle user interactions and display updates. A toast notification was added to congratulate the user whenever a six is rolled, leveraging LiveData from the ViewModel to trigger this feedback. Additionally, the UI was enhanced to present win rates and other statistics, including the total number of dice rolls and the count of sixes rolled. These statistics are managed by the ViewModel to maintain consistency and persistence through configuration changes, ensuring a reliable and continuous user experience.

Testing
Although we did not start with test-driven development (TDD), it proved to be extremely useful for debugging as the project advanced. We conducted extensive testing to ensure that the app functioned correctly and met all requirements. These tests validated that both the app’s logic and user interface worked well together, delivering accurate results and helpful error messages. No crashes have been detected till now.

Additionally, throughout the development process, we utilized ChatGPT for assistance with coding issues and to better understand challenging concepts. This guidance was instrumental in solving problems and progressing confidently while keeping our solutions original.(chatgpt.com)
We also took various code snippets from the slides provided in the Activity Lifespan module.(https://swaroopjoshi.in/courses/mobile-app-dev/07-activity-lifecycle/)
We also consulted the stackoverflow.com and developer.android.com whenever we faced technical errors or challenges during development.

Accessibility 
-Using TalkBack revealed that while basic navigation was functional, some UI elements needed better labeling for clarity. Specifically, the die button lacked a label, making it difficult for users relying on TalkBack to understand its purpose. On tapping it, the value of dice is read aloud instead of the label- die. Additionally, the text displaying roll statistics was too small, causing it to be missed often during navigation. 
-Accessibilty Scanner Suggestions:
1)The Font of Dice Games in toolbar is in dip and could be specified in scaled pixels(sp).
2) Since there is no content description, all views displaying roll statistics show an integer. As the initial value is zero for all, the Accessibility Scanner flags that multiple items have the same description.
3)It suggested increasing the text contrast for the die.
4) The die has a fixed size and scaleable text. It was suggested to allow text expansion.

Time Taken
Approximately 20 hours were taken to complete the assignment.

To what extent did you use pair programming on this assignment
5(used pair programming thoroughly)

Rate this assignment in terms of difficulty
5/10
