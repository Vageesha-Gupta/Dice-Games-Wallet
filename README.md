[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/R_7cjhEg)
# A2-PersistUI

# Project Name
Dice Games - Persisting the UI state

Student Details
| Name | Roll Number | Email ID |
|----------|----------|----------|
| Vageesha Gupta | 2022A7PS1107G | f20221107@goa.bits-pilani.ac.in |
| Priya Rathi | 2022A7PS1096G | f20221096@goa.bits-pilani.ac.in |

## Description of App
**Dice Games** is an engaging app for simulating rolls of a six-sided die while tracking various gameplay metrics. As users roll the die, their balance is dynamically updated based on the results:
- **Roll a six**: Earn 5 coins.
- **Consecutive sixes**: Earn a bonus of 10 coins.
- **Same non-six number twice**: Deduct 5 coins.

The app also tracks:
- Total number of dice rolls.
- Frequency of rolling a six.
- Value of the previous roll.

Users receive immediate feedback through a congratulatory toast whenever a six is rolled. The app is designed for both portrait and landscape orientations, ensuring a responsive and user-friendly interface across all devices.

## Implementation

To implement the **Dice Games** app, we followed these steps:

1. **User Interface (UI)**: 
   - Designed the UI for both **portrait** and **landscape** orientations.
   - In **portrait mode**, the layout includes the balance, dice value, and roll statistics.
   - In **landscape mode**, a separate XML layout ensures optimal visibility and usability.

2. **ViewModel**:
   - Developed the `WalletViewModel` to manage and persist the application’s state.
   - This ViewModel tracks key metrics like the user’s balance, total dice rolls, and frequency of sixes.
   - By using `LiveData`, the ViewModel ensures real-time updates and retains data across configuration changes, such as screen rotations.

3. **WalletActivity**:
   - Integrated the ViewModel to handle user interactions and display updates.
   - A toast notification was implemented to congratulate the user when a six is rolled, based on LiveData from the ViewModel.
   - The UI was further enhanced to display win rates and statistics, ensuring a reliable user experience across configuration changes.

## Testing

Initially, we did not employ **Test-Driven Development (TDD)**, but it became valuable during debugging in the later stages of the project. We conducted extensive testing to ensure the app functioned as expected:
- Verified that the app’s logic and UI worked seamlessly together, providing accurate results and clear error messages.
- No crashes were detected during the testing phase.

Additionally, throughout development, we used **ChatGPT** to clarify coding challenges and understand complex concepts. This assistance helped us solve problems confidently while maintaining originality in our solutions.  
We also referred to resources such as:
- [Activity Lifecycle](https://swaroopjoshi.in/courses/mobile-app-dev/07-activity-lifecycle/)
- [StackOverflow](https://stackoverflow.com/)
- [Android Developer Documentation](https://developer.android.com/)

## Accessibility

### TalkBack Experience:
Using **TalkBack** revealed that while basic navigation was functional, some UI elements required better labeling:
- The **die button** lacked a label, making it unclear for users relying on TalkBack.
- The **roll statistics text** was too small, leading to missed information during navigation.

### Accessibility Scanner Suggestions:
1. The font of "Dice Games" in the toolbar was defined in **dp** but should be specified in **sp** (scaled pixels).
2. Since there was no content description, all views displaying roll statistics showed integers, leading to duplicate descriptions when their initial values were zero.
3. The scanner suggested increasing the text contrast for the die.
4. The die had a fixed size with scalable text. It recommended enabling text expansion for better accessibility.

## Time Taken
Approximately **20 hours** were spent completing this assignment.

## Pair Programming
Extent of pair programming used: **5** (used thoroughly).

## Difficulty Rating
Assignment difficulty: **5/10**
