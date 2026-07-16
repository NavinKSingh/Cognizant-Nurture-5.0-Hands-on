# StudentApp — Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app StudentApp
   ```
2. Under `src`, create a folder named `Components`.
3. Inside `Components`, create `Home.js`:
   ```jsx
   import React, { Component } from 'react';

   class Home extends Component {
       constructor(props) {
           super(props);
       }

       render() {
           return (
               <div>
                   <h1>Welcome to the Home page of Student Management Portal</h1>
               </div>
           );
       }
   }

   export default Home;
   ```
4. Similarly create `About.js` and `Contact.js` inside `Components`,
   with the message changed to:
   - About → "Welcome to the About page of the Student Management Portal"
   - Contact → "Welcome to the Contact page of the Student Management Portal"
5. Edit `App.js` to import and render all three components:
   ```jsx
   import React, { Component } from 'react';
   import Home from './Components/Home';
   import About from './Components/About';
   import Contact from './Components/Contact';

   class App extends Component {
       render() {
           return (
               <div>
                   <Home />
                   <About />
                   <Contact />
               </div>
           );
       }
   }

   export default App;
   ```
6. Run the app:
   ```
   npm start
   ```
7. Open `http://localhost:3000` in the browser — all three messages
   (Home, About, Contact) are displayed one below the other.

## How to use this folder

This zip already contains the finished components, so you don't need to
run `create-react-app` again. Just run:

```
cd StudentApp
npm install
npm start
```
