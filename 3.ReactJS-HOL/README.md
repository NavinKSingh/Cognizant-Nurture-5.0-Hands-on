# scorecalculatorapp — Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app scorecalculatorapp
   ```
2. Under `src`, create a folder named `Components`, add `CalculateScore.js`
   — a **function component** that accepts `Name`, `School`, `Total`,
   and `goal` as props and calculates the average score:
   ```jsx
   import React from 'react';
   import '../Stylesheets/mystyle.css';

   function CalculateScore(props) {
       const average = props.Total / props.goal;

       return (
           <div className="score-container">
               <h2>Student Score Card</h2>
               <p><strong>Name:</strong> {props.Name}</p>
               <p><strong>School:</strong> {props.School}</p>
               <p><strong>Total Marks:</strong> {props.Total}</p>
               <p><strong>Goal (No. of Subjects):</strong> {props.goal}</p>
               <p className="average">Average Score: {average.toFixed(2)}</p>
           </div>
       );
   }

   export default CalculateScore;
   ```
3. Under `src`, create a folder named `Stylesheets`, add `mystyle.css`
   with styling for the score card (border, padding, colors, shadow).
4. Edit `App.js` to invoke `CalculateScore`, passing sample props:
   ```jsx
   import React from 'react';
   import CalculateScore from './Components/CalculateScore';

   function App() {
       return (
           <div>
               <CalculateScore
                   Name="John Doe"
                   School="Green Valley High School"
                   Total={450}
                   goal={5}
               />
           </div>
       );
   }

   export default App;
   ```
5. Run the app:
   ```
   npm start
   ```
6. Open `http://localhost:3000` — a styled card is shown with the
   student's Name, School, Total, Goal, and the calculated Average Score.

> Note: You can change the `Name`, `School`, `Total`, and `goal` values
> passed to `<CalculateScore />` in `App.js` to test with different data.

## How to use this folder

This zip already contains the finished component and styles, so you
don't need to run `create-react-app` again. Just run:

```
cd scorecalculatorapp
npm install
npm start
```
