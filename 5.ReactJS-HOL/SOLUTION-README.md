# cohorttracker — Styling Hands-on Lab Solution

The attached `cohorttracker.zip` react app (embedded in the lab docx) was
extracted and completed as follows:

## Steps followed

1. Extracted the attached app, ran `npm install` to restore packages.
2. Opened the app in VS Code.
3. Created `src/CohortDetails.module.css` (CSS Module):
   ```css
   .box {
       width: 300px;
       display: inline-block;
       margin: 10px;
       padding: 10px 20px;
       border: 1px solid black;
       border-radius: 10px;
   }

   dt {
       font-weight: 500;
   }
   ```
   - `.box` → width 300px, `display: inline-block`, overall 10px margin,
     10px top/bottom padding, 20px left/right padding, 1px black border,
     10px border-radius.
   - `dt` (tag selector) → font-weight 500.
4. In `src/CohortDetails.js`, imported the CSS Module and applied the
   `box` class to the container `<div>` via `className={styles.box}`.
5. Styled the `<h3>` so it shows **green** when `currentStatus` is
   "Ongoing", and **blue** for every other status, using an inline
   `style` object driven by the cohort's status.
6. Added a `key` prop to each `<CohortDetails />` in `App.js` (React
   best practice for list rendering).

## How to run

```
cd cohorttracker
npm install
npm start
```

Open `http://localhost:3000` — each cohort renders as a bordered,
rounded 300px box with green/blue headings depending on status.
