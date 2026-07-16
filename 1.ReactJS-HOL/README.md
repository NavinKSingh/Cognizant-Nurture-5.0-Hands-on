# myfirstreact — Hands-on Lab Solution

## Steps followed (as per the lab)

1. Install Node.js and NPM: https://nodejs.org/en/download/
2. Install create-react-app globally:
   ```
   npm install -g create-react-app
   ```
3. Create the React app:
   ```
   npx create-react-app myfirstreact
   ```
4. Move into the project folder:
   ```
   cd myfirstreact
   ```
5. Open the folder in Visual Studio Code:
   ```
   code .
   ```
6. Open `src/App.js`, remove the existing content, and replace it with:
   ```jsx
   import React from 'react';

   function App() {
     return (
       <div>
         <h1>welcome to the first session of React</h1>
       </div>
     );
   }

   export default App;
   ```
7. Run the app:
   ```
   npm start
   ```
8. Open the browser and go to `http://localhost:3000` — the page shows
   the heading **"welcome to the first session of React"**.

## How to use this folder

This zip already contains the finished `src/App.js`, `src/index.js`, and
`public/index.html`, so you don't need to run `create-react-app` again.
Just run:

```
cd myfirstreact
npm install
npm start
```

This installs `react`, `react-dom`, and `react-scripts`, then starts the
dev server at `http://localhost:3000`.
