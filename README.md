[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/UHdL4bOm)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=12595853)
# Fishing Game
## Dates & Points
 - Thurs 11/2 - Pull Request with game name and SURF poster start in repository. 5 points.
 - Thurs 11/9 - Finalized game name and group member info due to STEM Center for SURF.
 - Thurs 11/16 - SURF Poster and presentation files/video due to STEM Center. 15 points.
 - Thurs 12/7 - SURF presentations in Library. 40 points. 
 - Tues 12/12 - Final game version due on GitHub. 40 points

### Group Contributions
 * Each group member should fill out the [Group Contribution F23 Google form](https://forms.gle/8RLYBoqC5KQaqUbf8) after the assignment is submitted.
 * If all contributions are roughly equal, each group member will recieve the same grade. If some members have not contributed equally, their grades will be adjusted accordingly.
 
 
 ## Instructions

 ### These are the minimum suggestions, you can be more creative and do more!
 * Finish implementation of Fishable interface for I_a fish hierarchy.
 * Build a two player text-based Fishing Tournament game program using your I_a object classes.
   * Two players will alternate turns on the same computer.
   * The players will catch fish and put them into a "sack" (an ArrayList, sorted in descending order by length)
   * After 12 turns each, the player with the three largest fish is the winner.
 * Present/demo your game at the Student Undergraduate Research Fair on Wed May 3rd, in the Library.

### Fishable I_a Implementation
All `Fishable` fish need to be subclasses of a `FishableI_a` subclass of `I_a`.  See image:
  
![heirarchy](https://user-images.githubusercontent.com/279775/165010522-62a8f40d-7a9e-4496-9bb8-0686a603844a.png)

I am providing you with a new `Fishable.java` interface and a new `FishableI_a.java` abstract subclass of the `I_a` superclass. I have also fully implemented `Fishable` in the `Moi` family of fish. These new files are included here in this repository. Use the `MoiLi_i.java` - `Moi.java` classes as an example.

* You will need to move your `Oama`, `Ohua`, and `Pua_ama` fish families into this repo and modify them as follows:
  * Remove `implements Fishable` if it was there before. (Leave `implements ColorChangeable` and `SexChangeable` as is)
  * Change `extends I_a` to `extends FishableI_a` in the baby fish classes `Oama`, `Ohua`, and `Pua_ama`. The other inheritance remains the same.
  * Add (or modify if you made before) the methods required by `Fishable`
     * `isLegalSize`
     * `isBait`
     * `isGameFish`
     * `isInSeason`
     * `getCatchMethods`
     * I suggest implementing most `Fishable` methods from the baby fish type and have it handle most of the Fishable requirements. See `MoiLi_i.java`. You may need to add overloaded methods to a fish type that becomes legal size if it isn't the smallest, depending on your implementation of the methods (see `MoiMana.java`).
#### Fishable Values for Fish Families
* `Pua_ama` mullet family:
   *  Legal size is 11 inches and above
   *  Season is open April - November, closed December - March
   *  IsGameFish returns true if legal size
   *  Is not bait
   *  No bag limit (number of fish you're allowed to catch). Use `Integer.MAX_VALUE` as the limit.
   *  Valid catch methods for legal size fish are: `"net", "pole"`   
* `Ohua`/`Uhu` fish family:
   *  Legal size is 12 inches and above
   *  Season is always open
   *  IsGameFish if legal size
   *  Is not bait
   *  No bag limit (number of fish you're allowed to catch). Use `Integer.MAX_VALUE` as the limit.
   *  Valid catch methods for legal size fish are: `"throw net", "spear", "pole"`   
* `Oama`/`Weke` fish family:
   *  No minimum legal size 
   *  Season is always open
   *  IsGameFish
   *  IsBait
   *  Bag limit is 50
   *  Valid catch methods for legal size fish are: `"net", "trap", "pole"`  

There are new JUnit test for all of the fish types in this repository.

### Fishing Tournament Phase 1 - Loko i'a (Fish Pond) Setup
  * The first thing that should happen in the Fishing Tournament is the Fish Pond (ArrayList) should be filled up with baby fish of all `Fishable` types, then it should loop for around 2 pretend years (24 months) so the fish can grow to be roughly legal size.
      * I have given you some of the code required for this in `FishingDriver.java`. After you have your `I_a` modified for `Fishable` as above, run the `FishingDriver` and examine the code.

### Fishing Tournament Phase 2 - Lawa i'a (Fishing)
 * In the second (main game play) phase of the game, the fishing tournament should last for a whole "year" (12 months)
 * The two players should alternate turns. Once both players have had a turn, the "month" will be over and change to the next "month". 
 * When the "month" changes, the fish in the pond should eat and grow once, like in the `FishingDriver.java` example. 
 * During each player's turn, they will get to attempt to catch a fish three times.
    - The player should get to pick their catch method each time ("pole", "net", "spear", "trap", "throw net")
 * Each catch attempt will have three possible outcomes: No fish is caught (random empty ArrayList location hit) or a fish is caught (fish randomly picked from ArrayList pond) and is either landed or gets away.
    * If the fish is landed, the player will then need to decide whether or not to keep it.
        - Optionally, the player could be given an opportunity to view the fishing rules here.
       * If the fish is kept, the fish should be checked for legal size, legal catch method, and legal month.
       * If the kept fish is legal, it should be added to the player's sack and removed from the pond.
       * If the kept fish is not legal, the player will be punished by having all of their fish confiscated (sack of fish emptied) 
 
 Example of game play:
 ```
Player 1, it is your turn! 
 * Choose:
   1. Cast out for a fish
   2. View fishing rules
   3. View sack of fish
   4. Throw back a fish in the sack.
   
   Choice: 1
    You have hooked a fish!
    You have caught a fish!
      Name: Uhu
      English name: Parrotfish
      Scientific name: Scarus Psittacus
      Length: 12.487740994862454
      Weight: 24.97548198972491
      Body color: blue-green
      Fin color: blue
      Sex: supermale
      
  * Do you want to keep this fish y/n? y
      - Possibly it would be nice to be able to view the fishing rules here, after the player knows what the fish is.
   You have kept your fish
   Your fish is legal and has been added to your sack
```
Other outcomes would be:
```
   You have kept your fish
   You kept an illegal fish! It is February and Ama'ama season is closed.
   You got a ticket and all of your fish were confiscated!
```
or 
```
  Your fish got away!
```  
* The option to view the fishing rules should list the rules (see Fishable Values) in an easy to read way.
* The option to view the sack of fish should list the sack of fish in order by length, longest first (like you did in Assignment 5). 
* The throw back option will list the sack of fish (with the index number too) then ask the player to enter the number of the fish they want to throw back. 
    * The throw back option should remove the chosen fish from the player's list and add it back to the fish pond list.
    * The idea behind this is that towards the end of the game, the pond might be getting pretty empty and a player might want to put some fish back in.


Regardless, each player should get to attempt catching a fish three times before their turn is over. They can list and release fish as many times as they want in a turn.
 
### Game Phase 3 - Game Over
 * Once 12 "months" of turns have been taken, the two players' lists should be compared. The player with the largest three fish (sum of the three longest lengths) is the winner! 
  - The winning scores and fish stats should be listed out.
* You probably will need to adjust how many fish are in the pond and how much they get to grow to make the game more or less challenging.

## SURF Presentation
This assignment will be presented at the Student Undergraduate Research Fair during the last week of classes in December.
  - As a group, you will need to create a poster for your project and share it with students in person in the Library on December 7th.
  - All the information for the SURF presentations will be posted on the [KCCStem.com website](https://kapcc-research.wixsite.com/surf)
  - [Poster Template](https://docs.google.com/presentation/d/1-EYhCVzO5f1h097MEMSRoB3QIrV1b8HJ/edit?usp=sharing&ouid=109034211379461484747&rtpof=true&sd=true)
## Code Grading Rubric:  40 points
----
### Code Review:
- [x] **5/5** Code review for Group:   .
- [x] **5/5** Respond to Code review from Group:        .

### Game Code:
- [x] **5/5** Fishable interface upgrade to I_a classes.
- [X] **3/3** Setup of fish pond
- [x] **3/3** Implementation of players (can be an object or something else)
- [x] **4/4** Alternating turns, three casts per turn
- [x] **4/4** Tracking of "months"/ fish eat/grow between.
- [x] **3/3** Implementation of illegal fish penalty
- [x] **3/3** Implementation of throwing back functionality
- [x] **3/3** Correct win/lose calculation.
- [x] **2/2** Comments, coding style, documentation.

## SURF Presentation: 40 points

- [x] **15/15** SURF Poster.
- [x] **25/25** SURF Presentation.
