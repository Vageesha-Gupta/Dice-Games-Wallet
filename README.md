[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/R_7cjhEg)
# A2-PersistUI

## Project Name
**Dice Games - Persisting the UI state**

## Student Details
| Name | Roll Number | Email ID |
|----------|----------|----------|
| Vageesha Gupta | 2022A7PS1107G | f20221107@goa.bits-pilani.ac.in |
| Priya Rathi | 2022A7PS1096G | f20221096@goa.bits-pilani.ac.in |

## Description of App
The Dice Games is an engaging app for simulating rolls of a six-sided die while tracking various gameplay metrics. As users roll the die, their balance is dynamically updated based on the results. Rolling a six awards 5 coins, and consecutive sixes provide an additional bonus of 10 coins. Conversely, rolling the same non-six number twice in a row results in a deduction of 5 coins. The app also monitors and displays important statistics, including the total number of dice rolls, the frequency of rolling a six, and the value of the previous roll. Users receive immediate feedback through a congratulatory toast whenever a six is rolled. The app is designed to accommodate both portrait and landscape orientations, ensuring a responsive and user-friendly interface across different device orientations.

## Implementation
The Dice Games is an engaging app for simulating rolls of a six-sided die while tracking various gameplay metrics. As users roll the die, their balance is dynamically updated based on the results. Rolling a six awards 5 coins, and consecutive sixes provide an additional bonus of 10 coins. Conversely, rolling the same non-six number twice in a row results in a deduction of 5 coins. The app also monitors and displays important statistics, including the total number of dice rolls, the frequency of rolling a six, and the value of the previous roll. Users receive immediate feedback through a congratulatory toast whenever a six is rolled. The app is designed to accommodate both portrait and landscape orientations, ensuring a responsive and user-friendly interface across different device orientations.

## Testing
Although we did not start with test-driven development (TDD), it proved to be extremely useful for debugging as the project advanced. We conducted extensive testing to ensure that the app functioned correctly and met all requirements. These tests validated that both the app’s logic and user interface worked well together, delivering accurate results and helpful error messages. No crashes have been detected till now.

Additionally, throughout the development process, we utilized ChatGPT for assistance with coding issues and to better understand challenging concepts. This guidance was instrumental in solving problems and progressing confidently while keeping our solutions original.(chatgpt.com)
We also took various code snippets from the slides provided in the Activity Lifespan module.(https://swaroopjoshi.in/courses/mobile-app-dev/07-activity-lifecycle/)
We also consulted the stackoverflow.com and developer.android.com whenever we faced technical errors or challenges during development.

## Accessibility
### TalkBack Experience:
Using TalkBack revealed that while basic navigation was functional, some UI elements needed better labeling for clarity. Specifically, the die button lacked a label, making it difficult for users relying on TalkBack to understand its purpose. On tapping it, the value of dice is read aloud instead of the label- die. Additionally, the text displaying roll statistics was too small, causing it to be missed often during navigation. 

### Accessibility Scanner Suggestions:
1. The font of "Dice Games" in the toolbar was defined in **dp** but should be specified in **sp** (scaled pixels).
2.Since there is no content description, all views displaying roll statistics show an integer. As the initial value is zero for all, the Accessibility Scanner flags that multiple items have the same description
3. The scanner suggested increasing the text contrast for the die.
4. The die had a fixed size with scalable text. It recommended enabling text expansion for better accessibility.
   
## Time Taken
Approximately **20 hours** were taken to complete the assignment.

## Pair Programming
Extent of pair programming used: **5** (used thoroughly).

## Difficulty Rating
Assignment difficulty: **5/10**
