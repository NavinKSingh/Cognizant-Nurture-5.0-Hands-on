# counterapp — React State Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app counterapp
   ```
2. `src/CountPeople.js` — class component:
   - `constructor()` initializes `state = { entrycount: 0, exitcount: 0 }`
   - `UpdateEntry()` increments `entrycount` by 1 (called on **Login**
     button click)
   - `UpdateExit()` increments `exitcount` by 1 (called on **Exit**
     button click)
   - `render()` displays both counts and the two buttons:
   ```jsx
   import React, { Component } from 'react';

   class CountPeople extends Component {
       constructor(props) {
           super(props);
           this.state = {
               entrycount: 0,
               exitcount: 0
           };

           this.UpdateEntry = this.UpdateEntry.bind(this);
           this.UpdateExit = this.UpdateExit.bind(this);
       }

       UpdateEntry() {
           this.setState((prevState) => ({
               entrycount: prevState.entrycount + 1
           }));
       }

       UpdateExit() {
           this.setState((prevState) => ({
               exitcount: prevState.exitcount + 1
           }));
       }

       render() {
           return (
               <div>
                   <h2>Mall People Counter</h2>
                   <p>Number of people entered the mall: {this.state.entrycount}</p>
                   <p>Number of people exited the mall: {this.state.exitcount}</p>
                   <button onClick={this.UpdateEntry}>Login</button>
                   <button onClick={this.UpdateExit}>Exit</button>
               </div>
           );
       }
   }

   export default CountPeople;
   ```
3. `src/App.js` renders `<CountPeople />`.
4. Run the app:
   ```
   npm start
   ```
5. Open `http://localhost:3000`:
   - Clicking **Login** increments the entry count.
   - Clicking **Exit** increments the exit count.

## How to use this folder

This zip already contains the finished component, so you don't need to
run `create-react-app` again. Just run:

```
cd counterapp
npm install
npm start
```
