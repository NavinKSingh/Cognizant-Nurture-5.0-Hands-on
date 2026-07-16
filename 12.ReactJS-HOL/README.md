# ticketbookingapp — Conditional Rendering Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app ticketbookingapp
   ```
2. **`src/FlightDetails.js`** — shared component that lists flights.
   Accepts a `showBooking` prop; the "Book Ticket" button is only
   rendered when `showBooking` is `true` (prevents that part of the
   component from rendering for guests).
3. **`src/GuestPage.js`** — shows flight details with `showBooking={false}`
   and a message asking the user to log in.
4. **`src/UserPage.js`** — shows flight details with `showBooking={true}`,
   letting logged-in users book tickets.
5. **`src/LoginControl.js`** — conditionally renders a `LoginButton` or
   `LogoutButton` depending on `isLoggedIn`.
6. **`src/App.js`** — holds `isLoggedIn` in state.
   - Uses an **element variable** (`content`) with a simple `if/else`
     to decide whether to render `<UserPage />` or `<GuestPage />` —
     this is React's standard conditional-rendering pattern.
   - `handleLoginClick()` sets `isLoggedIn: true` → switches to
     `UserPage`.
   - `handleLogoutClick()` sets `isLoggedIn: false` → switches back to
     `GuestPage`.
7. Run the app:
   ```
   npm start
   ```
8. Open `http://localhost:3000`:
   - By default the Guest page is shown (flights visible, no booking).
   - Click **Login** → switches to the User page (flights + Book Ticket
     buttons, and the button changes to **Logout**).
   - Click **Logout** → switches back to the Guest page.

## How to use this folder

This zip already contains the finished components, so you don't need to
run `create-react-app` again. Just run:

```
cd ticketbookingapp
npm install
npm start
```

> Note: the exact flight data in the original screenshots wasn't fully
> readable, so sample flight details were used in `FlightDetails.js`.
> Feel free to edit that array with your lab's actual data.
