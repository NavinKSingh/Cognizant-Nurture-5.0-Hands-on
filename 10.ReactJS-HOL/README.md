# officespacerentalapp — JSX Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app officespacerentalapp
   ```
2. In `src/App.js`:
   - **Element** — `<h1>{heading}</h1>` displays the page heading using
     a JS expression in JSX.
   - **Attribute** — `<img src={officeImage} alt="Office Space" />`
     displays the office space image via the `src` attribute.
   - **Object** — an `office` object (`name`, `rent`, `address`) is
     created and its fields are displayed.
   - **List of objects** — `officeList` array of office objects is
     looped through with `.map()` to render more office data.
   - **Inline CSS in JSX** — the rent's text color is set with a style
     object: red when `rent < 60000`, green otherwise:
     ```jsx
     <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
         Rent: {office.rent}
     </p>
     ```
3. Run the app:
   ```
   npm start
   ```
4. Open `http://localhost:3000` — the heading, office image, featured
   office details, and the full list of office spaces are shown, with
   rent shown in red (below ₹60,000) or green (₹60,000 and above).

## How to use this folder

This zip already contains the finished `App.js`, so you don't need to
run `create-react-app` again. Just run:

```
cd officespacerentalapp
npm install
npm start
```

> Note: the exact office data/image in the original screenshots weren't
> fully readable, so sample office details and a placeholder image URL
> were used. Feel free to edit the `office` object and `officeList`
> array in `App.js` with your lab's actual data.
