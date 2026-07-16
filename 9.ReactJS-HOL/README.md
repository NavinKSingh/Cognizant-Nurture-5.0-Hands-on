# cricketapp — ES6 Features Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app cricketapp
   ```
2. `src/ListofPlayers.js`:
   - An array of 11 players with `name` and `score`.
   - Displays all players using the ES6 **`map()`** method.
   - Filters players with a score below 70 using an ES6 **arrow
     function** (`players.filter((player) => player.score < 70)`).
3. `src/IndianPlayers.js`:
   - Uses ES6 **destructuring** to pull individual player names out of
     the array and split them into Odd Team players and Even Team
     players.
   - Declares two arrays, `T20players` and `RanjiTrophyPlayers`, and
     **merges** them using the ES6 spread operator
     (`[...T20players, ...RanjiTrophyPlayers]`).
4. `src/App.js`:
   - Declares a `flag` variable.
   - Uses a simple `if / else` on `flag` to decide which component to
     show on the home page — `ListofPlayers` when `flag = true`,
     `IndianPlayers` when `flag = false`.
5. Run the app:
   ```
   npm start
   ```
6. Open `http://localhost:3000`. Toggle the `flag` value inside
   `App.js` (`true` / `false`) and refresh to see the two different
   component outputs, matching the lab's Figure (Flag=true) and
   (Flag=false) screenshots.

## How to use this folder

This zip already contains the finished components, so you don't need to
run `create-react-app` again. Just run:

```
cd cricketapp
npm install
npm start
```

> Note: the exact player names/scores in the original screenshots
> weren't fully readable, so representative Indian cricket player names
> and sample scores were used. Feel free to edit the arrays in
> `ListofPlayers.js` / `IndianPlayers.js` to match your lab's exact data.
