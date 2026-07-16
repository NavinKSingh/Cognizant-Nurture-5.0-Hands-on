# eventexamplesapp — React Events Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app eventexamplesapp
   ```
2. **`src/Counter.js`** — Increment / Decrement buttons.
   - `Increment` button calls `handleIncrement()`, which invokes
     **two** methods: `incrementValue()` (increases the counter) and
     `sayHello()` (shows a static "Hello..." message) — demonstrating
     that one button can invoke multiple methods.
   - `Decrement` button calls `handleDecrement()` to decrease the count.
   - Methods are bound to `this` in the constructor so `this.state`
     works correctly inside the handlers.
3. **`src/SayWelcome.js`** — "Say Welcome" button invokes
   `sayWelcomeMessage('welcome')`, passing `"welcome"` as an argument
   via an inline arrow function (`onClick={() => sayWelcomeMessage('welcome')}`).
4. **`src/OnPressButton.js`** — button's `onClick` fires `OnPress`,
   whose parameter is React's **SyntheticEvent** object, and displays
   `alert('I was clicked')`.
5. **`src/CurrencyConvertor.js`** — a class component with an input for
   Rupees and a "Convert" button. Clicking Convert calls
   `handleSubmit()`, which converts the entered rupee amount to Euro
   using a conversion rate and displays the result.
6. `src/App.js` renders all four pieces together.
7. Run the app:
   ```
   npm start
   ```
8. Open `http://localhost:3000` and try each button:
   - Increment/Decrement the counter
   - Say Welcome
   - Click Me (synthetic event alert)
   - Enter a Rupee amount and click Convert to see the Euro value

## How to use this folder

This zip already contains the finished components, so you don't need to
run `create-react-app` again. Just run:

```
cd eventexamplesapp
npm install
npm start
```

> Note: the exact INR→EUR conversion rate used in the original lab
> screenshot wasn't fully readable, so an approximate rate (0.011) is
> used in `CurrencyConvertor.js`. You can update `conversionRate` to
> match your lab's expected value.
